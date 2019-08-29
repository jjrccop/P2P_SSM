package com.gxa.eloan.common.controller;

import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.service.IAccountService;
import com.gxa.eloan.common.service.IIpLogService;
import com.gxa.eloan.common.service.IUserInfoService;
import com.gxa.eloan.common.util.JSONResult;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonalController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IIpLogService iIpLogService;
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping("personal")
    public String personalCenter(Model model) {

        LoginInfo loginInfo = UserContext.getLoginInfo();

        model.addAttribute("account", iAccountService.getCurrentAccount(loginInfo.getId()));
        model.addAttribute("iplog",iIpLogService.getCurrentIplog(loginInfo.getUsername()));
        model.addAttribute("userinfo",iUserInfoService.getCurrentUserinfo(loginInfo.getId()));

        return "personal";
    }

    /**
     * 用户绑定手机
     *
     * @param phoneNumber
     * @param verifyCode
     * @return
     */
    @RequestMapping("bindPhone")
    @ResponseBody
    public JSONResult bindPhone(String phoneNumber, String verifyCode) {
        JSONResult json = new JSONResult();
        try {
            iUserInfoService.bindPhone(phoneNumber, verifyCode);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }

}
