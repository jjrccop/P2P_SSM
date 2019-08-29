package com.gxa.eloan.common.service;

import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.query.LoginInfoQueryObject;
import com.gxa.eloan.common.query.PageResultSet;

import javax.servlet.http.HttpServletRequest;

public interface ILoginInfoService {

    int checkUsername(String username);
    void register(String username, String password);
    LoginInfo login(String username, String password, HttpServletRequest request, Byte usertype);
    LoginInfo getCurrentAccount(Long id);
    PageResultSet queryForPage(LoginInfoQueryObject loginInfoQueryObject);
}
