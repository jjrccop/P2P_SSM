package com.gxa.p2p.common.controller;

import com.gxa.eloan.common.query.LoginInfoQueryObject;
import com.gxa.eloan.common.service.ILoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户信息
 *
 * @author novo
 *
 */
@Controller
public class UserListController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    @RequestMapping("user_list")
    public String userList(LoginInfoQueryObject loginInfoQueryObject, Model model) {

        model.addAttribute("pageResultSet",iLoginInfoService.queryForPage(loginInfoQueryObject));
        return "user/list";
    }
}
