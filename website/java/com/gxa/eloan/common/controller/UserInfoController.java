package com.gxa.eloan.common.controller;

import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.domain.Systemdictionaryitem;
import com.gxa.eloan.common.service.ISystemdictionaryitemService;
import com.gxa.eloan.common.service.IUserInfoService;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfoController {
    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private ISystemdictionaryitemService iSystemdictionaryitemService;

    private static Long INCOME_GRADES = 1L;
    private static Long EDUCATION_BACKGROUND = 2L;
    private static Long MARRIAGES = 3L;
    private static Long KID_COUNTS = 4L;
    private static Long HOUSE_CONDITIONS = 5L;

    @RequestMapping("userInfo")
    public String userInfo(Model model){

        LoginInfo loginInfo = UserContext.getLoginInfo();

        model.addAttribute("userinfo", iUserInfoService.getCurrentUserinfo(loginInfo.getId()));
        model.addAttribute("educationBackgrounds", iSystemdictionaryitemService.getItemList(EDUCATION_BACKGROUND));
        model.addAttribute("incomeGrades", iSystemdictionaryitemService.getItemList(INCOME_GRADES));
        model.addAttribute("marriages", iSystemdictionaryitemService.getItemList(MARRIAGES));
        model.addAttribute("kidCounts", iSystemdictionaryitemService.getItemList(KID_COUNTS));
        model.addAttribute("houseConditions", iSystemdictionaryitemService.getItemList(HOUSE_CONDITIONS));

        return "userInfo";
    }
}
