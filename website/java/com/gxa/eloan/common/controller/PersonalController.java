package com.gxa.eloan.common.controller;

import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.service.IAccountService;
import com.gxa.eloan.common.service.IIpLogService;
import com.gxa.eloan.common.service.IUserInfoService;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IIpLogService iIpLogService;

    @RequestMapping("personal")
    public String personalCenter(Model model) {

        LoginInfo loginInfo = UserContext.getLoginInfo();

        model.addAttribute("account", iAccountService.getCurrentAccount(loginInfo.getId()));
        model.addAttribute("iplog",iIpLogService.getCurrentIplog(loginInfo.getUsername()));

        return "personal";
    }
}
