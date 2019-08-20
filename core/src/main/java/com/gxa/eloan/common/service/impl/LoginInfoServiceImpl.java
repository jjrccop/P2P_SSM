package com.gxa.eloan.common.service.impl;

import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.mapper.LoginInfoMapper;
import com.gxa.eloan.common.service.ILoginInfoService;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginInfoServiceImpl implements ILoginInfoService {

    @Autowired
    private LoginInfoMapper logininfoMapper;

    /**
     * 检查用户名是否已存在
     *
     * @param username
     * @return 返回用户个数
     */
    @Override
    public int checkUsername(String username) {
        int count = logininfoMapper.selectCountByUsername(username);
        return count;
    }
    /**
     * 新用户注册
     * @param username
     * @param password
     */
    @Override
    public void register(String username, String password) {
        /*
         * 逻辑思路
         * 1. 判断用户名是否存在
         * 2. 如果不存在,设值并保存这个对象
         * 3. 如果存在,直接抛错
         *
         */
        int count = checkUsername(username);

        if (count <= 0) {
            LoginInfo li = new LoginInfo();
            li.setUsername(username);
            li.setPassword(password);
            li.setState(LoginInfo.STATE_NORMAL);
            logininfoMapper.insert(li);
        } else {
            // 如果存在,直接抛错
            throw new RuntimeException("用户名已经存在!");
        }
    }

    /**
     *
     * 用户登陆
     *
     * @param username
     * @param password
     */
    @Override
    public void login(String username, String password) {
        LoginInfo loginInfo = logininfoMapper.login(username,password);
        if (loginInfo != null) {
            /* 将登录用户的数据，通过UserContext工具类，存放至session*/
            UserContext.putLoginInfo(loginInfo);
        } else {
            throw new RuntimeException("用户名或密码错误，登录失败!");
        }
    }

}
