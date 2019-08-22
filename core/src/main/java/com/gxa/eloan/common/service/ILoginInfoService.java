package com.gxa.eloan.common.service;

import com.gxa.eloan.common.domain.LoginInfo;

import javax.servlet.http.HttpServletRequest;

public interface ILoginInfoService {

    int checkUsername(String username);
    void register(String username, String password);
    LoginInfo login(String username, String password, HttpServletRequest request, int usertype);
    LoginInfo getCurrentAccount(Long id);
}
