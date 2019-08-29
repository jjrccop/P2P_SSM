package com.gxa.eloan.common.service;

import com.gxa.eloan.common.domain.UserInfo;

public interface IUserInfoService{
    void add(UserInfo userInfo);
    UserInfo getCurrentUserinfo(Long id);
    void updateUserinfo(UserInfo userInfo);
    void updateBasicInfo(UserInfo userInfo);
    void bindPhone(String phoneNumber, String verifyCode);
    void bindEmail(String uuid);
}
