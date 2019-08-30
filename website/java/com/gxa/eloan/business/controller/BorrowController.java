package com.gxa.eloan.business.controller;

import com.gxa.eloan.business.domain.Bidrequest;
import com.gxa.eloan.business.service.IBidrequestService;
import com.gxa.eloan.common.domain.Account;
import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.domain.UserInfo;
import com.gxa.eloan.common.service.IAccountService;
import com.gxa.eloan.common.service.IUserInfoService;
import com.gxa.eloan.common.util.SysConstant;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class BorrowController {
    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IBidrequestService iBidrequestService;

    @RequestMapping("borrow")
    public String borrow(Model model){
        LoginInfo loginInfo = UserContext.getLoginInfo();
        if (null != loginInfo) {
            Long id = loginInfo.getId();
            model.addAttribute("account", iAccountService.getCurrentAccount(id));
            model.addAttribute("userinfo", iUserInfoService.getCurrentUserinfo(id));
            model.addAttribute("creditBorrowScore", SysConstant.CREDIT_BORROW_SCORE);
            return "borrow";
        } else {
            //如果没有登录 直接导向到静态页面中
            return "redirect:borrow.html";
        }
    }

    @RequestMapping("borrowInfo")
    public String borrowInfo(Model model){
        LoginInfo loginInfo = UserContext.getLoginInfo();
        Long id = loginInfo.getId();
        UserInfo userInfo = iUserInfoService.getCurrentUserinfo(id);

        if (iBidrequestService.canApply(userInfo)) {
            if (!userInfo.getHasBidRequestInProcess()) {//用户是否有借款在审核流程中
                //如果没有 添加属性到到model  跳转页面
                model.addAttribute("account", iAccountService.getCurrentAccount(id));
                model.addAttribute("minBidRequestAmount", SysConstant.SMALLEST_BIDREQUEST_AMOUNT);
                model.addAttribute("minBidAmount", SysConstant.SMALLEST_BID_AMOUNT);
                return "borrow_apply";
            } else {
                //如果有 ,返回到 借款的等待审核页面
                return "borrow_apply_result";
            }
        } else {
            //否则 返回到borrow.do  申请借款首页
            return "redirect:/borrow.do";
        }
    }

    @RequestMapping("borrow_apply")
    public String borrowApply(Bidrequest bidrequest){
        iBidrequestService.apply(bidrequest);
        return "redirect:/borrowInfo.do";
    }
}
