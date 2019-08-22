package com.gxa.eloan.common.service;

import com.gxa.eloan.common.domain.UserInfo;

public interface IUserInfoService{
    /**
     * 新增个人资料
     *
     * @param userInfo
     */
    void add(UserInfo userInfo);

    UserInfo getCurrentUserinfo(Long id);

}
