package com.gxa.eloan.common.controller;

import com.gxa.eloan.common.service.IMailVerifyService;
import com.gxa.eloan.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailVerifyController {

    @Autowired
    private IMailVerifyService iEmailVerifyService;

    @RequestMapping("sendEmail")
    @ResponseBody
    public JSONResult sendEmail(String email){
        System.out.println("asdfadfa");
        JSONResult json = new JSONResult();
        try {
            iEmailVerifyService.sendVerifyEmail(email);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json ;
    }
}

