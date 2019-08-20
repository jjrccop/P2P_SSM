package com.gxa.eloan.common.service.impl;

import com.gxa.eloan.common.domain.Account;
import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.mapper.LoginInfoMapper;
import com.gxa.eloan.common.service.ILoginInfoService;
import com.gxa.eloan.common.service.IAccountService;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class LoginInfoServiceImpl implements ILoginInfoService {

    @Autowired
    private LoginInfoMapper logininfoMapper;
    @Autowired
    private IAccountService iAccountService;

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

            Long id = li.getId();   //这样写的好处？？？
            Account account = new Account();
            account.setId(id);
            iAccountService.add(account);
        } else {
            // 如果存在,直接抛错
            throw new RuntimeException("用户名已经存在!");
        }

        // 初始化账户信息Account


    }

    /**
     *
     * 用户登陆
     *
     * @param username
     * @param password
     */
    @Override
    public LoginInfo login(String username, String password, HttpServletRequest request, int usertype) {
        LoginInfo loginInfo = logininfoMapper.login(username,password,usertype);

        Iplog iplog = new Iplog();
        iplog.setIp(request.getRemoteAddr());
        iplog.setUsername(username);
        iplog.setLogintime(new Date());
        //iplog.setUsertype((byte)LoginInfo.USER_WEB);

        if (loginInfo != null) {
            /* 将登录用户的数据，通过UserContext工具类，存放至session*/
            UserContext.putLoginInfo(loginInfo);
            iplog.setState(Iplog.LOGIN_SUCCESS);
        } else {
            iplog.setState(Iplog.LOGIN_FAILED);
        }

        iIpLogService.add(iplog);

        return loginInfo;
    }


}
