package com.gxa.eloan.common.service;

public interface ILoginInfoService {

    int checkUsername(String username);
    void register(String username, String password);
    void login(String username, String password);
}
