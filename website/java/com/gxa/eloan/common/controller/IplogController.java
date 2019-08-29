package com.gxa.eloan.common.controller;

import com.gxa.eloan.common.query.IplogQueryObject;
import com.gxa.eloan.common.query.PageResultSet;
import com.gxa.eloan.common.service.IIpLogService;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆日志
 *
 * @author novo
 */
@Controller
public class IplogController {

    @Autowired
    private IIpLogService iIpLogService;

    /**
     * 个人用户登陆记录列表
     *
     * @param iplogQueryObject
     * @param model
     * @return
     */


    @RequestMapping("ipLog")
    public String iplogList(IplogQueryObject iplogQueryObject, Model model) {

        /* 登录日志 条件对象*/
        iplogQueryObject.setUsername(UserContext.getLoginInfo().getUsername());
        model.addAttribute("iplogQueryObject", iplogQueryObject);

        /* 登录日志 分页对象*/
        PageResultSet pageResultSet = iIpLogService.query(iplogQueryObject);
        model.addAttribute("pageResultSet", pageResultSet);

        return "iplog_list";
    }

}

