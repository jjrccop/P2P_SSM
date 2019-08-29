package com.gxa.eloan.common.controller;

import com.gxa.eloan.common.service.IVerifyCodeService;
import com.gxa.eloan.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendVerifyCodeController {

    @Autowired
    IVerifyCodeService iVerifyCodeService;
    /**
     * 发送验证码
     * @param phoneNumber
     * @return
     */

    @RequestMapping("sendVerifyCode")
    @ResponseBody
    public JSONResult sendVerifyCode(String phoneNumber){
        JSONResult json = new JSONResult();
        try {
            this.iVerifyCodeService.sendVerifyCode(phoneNumber);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json ;
    }

}
