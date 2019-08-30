package com.gxa.eloan.business.service.impl;

import com.gxa.eloan.business.domain.Bidrequest;
import com.gxa.eloan.business.domain.Bidrequestaudithistory;
import com.gxa.eloan.business.mapper.BidrequestMapper;
import com.gxa.eloan.business.mapper.BidrequestaudithistoryMapper;
import com.gxa.eloan.business.query.BidRequestQueryObject;
import com.gxa.eloan.business.service.IBidrequestService;
import com.gxa.eloan.business.utils.CalculatetUtil;
import com.gxa.eloan.common.domain.Account;
import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.domain.UserInfo;
import com.gxa.eloan.common.query.PageResultSet;
import com.gxa.eloan.common.service.IAccountService;
import com.gxa.eloan.common.service.IUserInfoService;
import com.gxa.eloan.common.util.BitStatesUtils;
import com.gxa.eloan.common.util.SysConstant;
import com.gxa.eloan.common.util.UserContext;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BidrequestServiceImpl implements IBidrequestService {
    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private BidrequestMapper bidRequestMapper;
    @Autowired
    private BidrequestaudithistoryMapper bidRequestAuditHistoryMapper;

    /**
     * 判断当前用户是否可以申请借款
     */
    public boolean canApply(UserInfo userInfo) {
        //判断基本资料 绑定手机 绑定邮箱 风控积分
        return userInfo.getIsBasicInfo()
                && userInfo.getIsBindPhone()
                && userInfo.getIsBindEmail()
                && userInfo.getAuthscore() >= SysConstant.CREDIT_BORROW_SCORE;
    }

    /**
     * 申请借款的流程
     */
    @Override
    public void apply(Bidrequest bidRequestVo) {
        //得到当前的用户
        LoginInfo loginInfo = UserContext.getLoginInfo();
        Long id = loginInfo.getId();
        UserInfo userInfo = iUserInfoService.getCurrentUserinfo(id);
        Account account = iAccountService.getCurrentAccount(id); //剩余信用额度等信息会用到
//        if(
//                null == bidRequestVo.getBidrequestamount()
//             || null == bidRequestVo.getCurrentrate()
//             || null == bidRequestVo.getMinbidamount()
//        ) return;
        if (
            //表示当前用户满足借款的基本条件
                canApply(userInfo)
                        // 判断 当前用户是否有借款在审核流程中
                        && !userInfo.getHasBidRequestInProcess()

                        // 判断借款金额规则：系统最小的借款金额<= 借款金额<=剩余信用额度
                        // 判断用户设置的 借款金额 >= 系统最小的借款金额
                        && bidRequestVo.getBidrequestamount().compareTo(SysConstant.SMALLEST_BIDREQUEST_AMOUNT) >= 0
                        // 判断用户设置的 借款金额<=剩余信用额度
                        && bidRequestVo.getBidrequestamount().compareTo(account.getRemainborrowlimit()) <= 0

                        // 判断年化利率规则：系统最低年化率<= 年化率 <= 系统最高年化率
                        // 判断用户设置的 年化利率 >= 系统最低年化率
                        && bidRequestVo.getCurrentrate().compareTo(SysConstant.SMALLEST_CURRENT_RATE) >= 0
                        // 判断用户设置的 年化率 <= 系统最高年化率
                        && bidRequestVo.getCurrentrate().compareTo(SysConstant.MAX_CURRENT_RATE) <= 0

                        // 判断用户设置的 最小投标金额 >= 系统最小投标额
                        && bidRequestVo.getMinbidamount().compareTo(SysConstant.SMALLEST_BID_AMOUNT) >= 0
        ) {
            //判断成功 创建一个 bidrequest  设置相应的属性
            Bidrequest bidRequest = new Bidrequest();

            //设置借款类型 :信用标
            bidRequest.setBidrequesttype(SysConstant.BIDREQUEST_TYPE_NORMAL);
            //设置当前标的状态 .待发布
            bidRequest.setBidrequeststate(SysConstant.BIDREQUEST_STATE_PUBLISH_PENDING);
            //借款总金额
            bidRequest.setBidrequestamount(bidRequestVo.getBidrequestamount());
            //年化利率
            bidRequest.setCurrentrate(bidRequestVo.getCurrentrate());
            // 最小投标金额
            bidRequest.setMinbidamount(bidRequestVo.getMinbidamount());
            //还款月数
            bidRequest.setMonthes2return(bidRequestVo.getMonthes2return());
            //设置总的回报金额(总利息)    工具类中计算
            bidRequest.setTotalrewardamount(
                    CalculatetUtil.calTotalInterest(bidRequestVo.getReturntype(), bidRequestVo.getBidrequestamount(), bidRequestVo.getCurrentrate(), bidRequestVo.getMonthes2return()
                    )
            );
            //借款标题
            bidRequest.setTitle(bidRequestVo.getTitle());
            //借款描述
            bidRequest.setDescription(bidRequestVo.getDescription());
            System.out.println("---- Title ---- ：" + bidRequestVo.getTitle());
            System.out.println("---- Description ---- ：" + bidRequestVo.getDescription());
            //借款申请时间
            bidRequest.setApplytime(new Date());
            //招标天数
            bidRequest.setDisabledays(bidRequestVo.getDisabledays());
            //还款类型
            bidRequest.setReturntype(bidRequestVo.getReturntype());
            // 借款人
            bidRequest.setCreateUser(loginInfo);

            //Version
            bidRequest.setVersion(0);
            //bidCount
            bidRequest.setBidcount(0);
            //Current Sum
            bidRequest.setCurrentsum(SysConstant.ZERO);

            // 新增借款
            bidRequestMapper.insert(bidRequest);

            // 给用户添加一个状态码
            userInfo.addState(BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);
            // 更新用户状态
            iUserInfoService.updateUserinfo(userInfo);
        }
    }


    /**
     * 借款申请分页查询
     */
    @Override
    public PageResultSet queryForPage(BidRequestQueryObject bidRequestQueryObject) {
        int count = bidRequestMapper.queryForCount(bidRequestQueryObject);
        if (count > 0) {
            List<Bidrequest> list = bidRequestMapper.queryForList(bidRequestQueryObject);
            PageResultSet pageResultSet = new PageResultSet(list, count, bidRequestQueryObject.getCurrentPage(), bidRequestQueryObject.getPageSize());
            return pageResultSet;
        } else {
            return PageResultSet.empty(bidRequestQueryObject.getPageSize());
        }
    }


    /**
     * 后台发标前的审核
     */
    @Override
    public void publishAudit(Long id, String remark, Byte state) {
        //得到借款对象  ,判断状态处于发标前审核
        Bidrequest bidRequest = bidRequestMapper.selectByPrimaryKey(id);
        if (null != bidRequest && bidRequest.getBidrequeststate() == SysConstant.BIDREQUEST_STATE_PUBLISH_PENDING) {
            //创建一个审核历史 对象  设置相关参数
            Bidrequestaudithistory bidRequestAuditHistory = new Bidrequestaudithistory();
            bidRequestAuditHistory.setState(state); //设置审核状态
            bidRequestAuditHistory.setRemark(remark);
            bidRequestAuditHistory.setApplytime(new Date());
            bidRequestAuditHistory.setApplytime(bidRequest.getApplytime());
            bidRequestAuditHistory.setAuditor(UserContext.getLoginInfo());
            bidRequestAuditHistory.setApplier(bidRequest.getCreateUser());
            bidRequestAuditHistory.setBidrequestid(bidRequest.getId());
            bidRequestAuditHistory.setAudittype(Bidrequestaudithistory.PUBLISH_AUDIT); // 设置为 发标审核
            bidRequestAuditHistoryMapper.insert(bidRequestAuditHistory);

            bidRequest.setNote(remark); //给借款对象设置审核意见
            if (state == Bidrequestaudithistory.STATE_AUDIT) { //表示审核通过
                // 给借款对象修改状态   修改借款信息
                bidRequest.setBidrequeststate(SysConstant.BIDREQUEST_STATE_BIDDING);// 设置状态为招标中
                bidRequest.setPublishtime(new Date()); //设置标的发布
                bidRequest.setDisabledate(DateUtils.addDays(bidRequest.getPublishtime(), bidRequest.getDisabledays())); //设置该标的到期时间
            } else {  //表示审核失败
                //修改借款状态
                bidRequest.setBidrequeststate(SysConstant.BIDREQUEST_STATE_PUBLISH_REFUSE);//设置状态为 发标审核被拒绝
                //移除状态码     借款人的状态码
                UserInfo userInfo = iUserInfoService.getCurrentUserinfo(bidRequest.getCreateUser().getId());
                userInfo.removeState(BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);
                iUserInfoService.updateUserinfo(userInfo);
            }
            this.update(bidRequest);
        }
    }


    public void update(Bidrequest bidRequest) {
        int count = bidRequestMapper.updateByPrimaryKey(bidRequest);
        if (count <= 0) {
            throw new RuntimeException("更新失败" + bidRequest.getId());
        }
    }

    /**
     * 根据id得到bidrequest
     */
    @Override
    public Bidrequest getBidRequest(Long id) {
        return bidRequestMapper.selectByPrimaryKey(id);
    }


    /**
     *  查询一个借款相关的所有审核对象
     */
    @Override
    public List<Bidrequestaudithistory> listAuditHistorayByBidRequest(Long id) {
        return bidRequestAuditHistoryMapper.listAuditHistorayByBidRequest(id);
    }


    /**
     * 前台首页查询5条按照 多个借款类型列出
     */
    public List<Bidrequest> queryForList(BidRequestQueryObject bidRequestQueryObject) {

        return bidRequestMapper.queryForList(bidRequestQueryObject);
    }
}
