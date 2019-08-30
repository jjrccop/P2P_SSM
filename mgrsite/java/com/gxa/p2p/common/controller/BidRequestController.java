package com.gxa.p2p.common.controller;

import com.gxa.eloan.business.domain.Bidrequest;
import com.gxa.eloan.business.query.BidRequestQueryObject;
import com.gxa.eloan.business.service.IBidrequestService;
import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.domain.UserInfo;
import com.gxa.eloan.common.service.IUserInfoService;
import com.gxa.eloan.common.util.JSONResult;
import com.gxa.eloan.common.util.SysConstant;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BidRequestController {

    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private IBidrequestService iBidRequestService;


    /**
     * 发标之前的标的列表
     *
     * @param bidRequestQueryObject
     * @param model
     * @return
     */
    @RequestMapping("bidrequest_publishaudit_list")
    public String publishAuditList(@ModelAttribute("bidRequestQueryObject") BidRequestQueryObject bidRequestQueryObject, Model model) {
        bidRequestQueryObject.setBidrequeststate(SysConstant.BIDREQUEST_STATE_PUBLISH_PENDING);
        model.addAttribute("pageResult", iBidRequestService.queryForPage(bidRequestQueryObject));
//
//        LoginInfo loginInfo = UserContext.getLoginInfo();
//        model.addAttribute("logininfo", loginInfo);
        return "bidrequest/publish_audit";
    }

    /**
     * 发标之前的审核
     */
    @RequestMapping("bidrequest_publishaudit")
    @ResponseBody
    public JSONResult publishAudit(Long id, String remark, Byte state) {
        JSONResult json = new JSONResult();
        try {
            iBidRequestService.publishAudit(id, remark, state);
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * 查看标的的详细信息
     *
     * @return
     */
    @RequestMapping("borrow_info")
    public String borrowInfoDetail(Long id, Model model) {

        Bidrequest bidRequest = iBidRequestService.getBidRequest(id);
        //获得当前的借款人
        UserInfo userInfo = iUserInfoService.getCurrentUserinfo(bidRequest.getCreateUser().getId());

        model.addAttribute("userInfo", userInfo);
        model.addAttribute("bidRequest", bidRequest);

        //查询当前标的 历史审核对象
        model.addAttribute("audits", iBidRequestService.listAuditHistorayByBidRequest(bidRequest.getId()));

        LoginInfo loginInfo = UserContext.getLoginInfo();
        model.addAttribute("logininfo", loginInfo);

        return "bidrequest/borrow_info";
    }
}