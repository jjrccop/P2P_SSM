package com.gxa.p2p.common.controller;

import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.service.ILoginInfoService;
import com.gxa.eloan.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginInfoController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    @RequestMapping("login")
    @ResponseBody
    public JSONResult login(String username, String password, HttpServletRequest request) {

        LoginInfo loginInfo = iLoginInfoService.login(username, password, request, LoginInfo.USER_MGR);

        JSONResult json = new JSONResult();
        if(null == loginInfo){
            json.setSuccess(false);
            json.setMsg("登录失败,用户名或密码无效");
        }
        return json;
    }

    @RequestMapping("index")
    public String index(){
        return "main";
    }

}