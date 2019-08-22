package com.gxa.eloan.common.service.impl;

import com.gxa.eloan.common.domain.UserInfo;
import com.gxa.eloan.common.mapper.UserInfoMapper;
import com.gxa.eloan.common.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void add(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public UserInfo getCurrentUserinfo(Long id){
        return userInfoMapper.selectByPrimaryKey(id);
    }
}

