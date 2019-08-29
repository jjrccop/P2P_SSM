package com.gxa.eloan.common.service.impl;

import com.gxa.eloan.common.domain.Account;
import com.gxa.eloan.common.domain.Iplog;
import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.domain.UserInfo;
import com.gxa.eloan.common.mapper.LoginInfoMapper;
import com.gxa.eloan.common.query.LoginInfoQueryObject;
import com.gxa.eloan.common.query.PageResultSet;
import com.gxa.eloan.common.service.IIpLogService;
import com.gxa.eloan.common.service.ILoginInfoService;
import com.gxa.eloan.common.service.IAccountService;
import com.gxa.eloan.common.service.IUserInfoService;
import com.gxa.eloan.common.util.Init.AccountInit;
import com.gxa.eloan.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.IconUIResource;
import java.util.Date;
import java.util.List;

@Service
public class LoginInfoServiceImpl implements ILoginInfoService {

    @Autowired
    private LoginInfoMapper logininfoMapper;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private IIpLogService iIpLogService;

    @Override
    public int checkUsername(String username) {
        int count = logininfoMapper.selectCountByUsername(username);
        return count;
    }

    @Override
    public void register(String username, String password) {
        int count = checkUsername(username);

        if (count <= 0) {
            LoginInfo li = new LoginInfo();
            li.setUsername(username);
            li.setPassword(password);
            li.setState(LoginInfo.STATE_NORMAL);
            li.setUsertype(LoginInfo.USER_WEB);
            logininfoMapper.insert(li);
            Long id = li.getId();
            Account account = new AccountInit().getInitAccount();
            account.setId(id);
            iAccountService.add(account);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(id);
            userInfo.setVersion(0);
            userInfo.setBitstate((long)0);
            iUserInfoService.add(userInfo);
        } else {
            throw new RuntimeException("用户名已经存在!");
        }
    }

    @Override
    public LoginInfo login(String username, String password, HttpServletRequest request, Byte usertype) {

        LoginInfo loginInfo = logininfoMapper.login(username,password,usertype);

        Iplog iplog = new Iplog();
        iplog.setIp(request.getRemoteAddr());

        if (loginInfo != null) {
            /* 将登录用户的数据，通过UserContext工具类，存放至session*/
            UserContext.putLoginInfo(loginInfo);
            iplog.setState(Iplog.LOGIN_SUCCESS);
            iplog.setUsername(username);
            iplog.setLogintime(new Date());
            iplog.setUsertype(usertype);
            iplog.setLogininfoid(loginInfo.getId());
        } else {
            iplog.setState(Iplog.LOGIN_FAILED);
        }

        iIpLogService.add(iplog);

        return loginInfo;
    }

    @Override
    public LoginInfo getCurrentAccount(Long id){
        LoginInfo loginInfo = logininfoMapper.selectByPrimaryKey(id);
        return loginInfo;
    }


    @Override
    public PageResultSet queryForPage(LoginInfoQueryObject loginInfoQueryObject) {

        int count = logininfoMapper.queryForCount();
        PageResultSet pageResultSet;
        if (count > 0) {
            List<LoginInfo> list = logininfoMapper.queryForPage(loginInfoQueryObject);
            pageResultSet = new PageResultSet(
                    list,
                    count,
                    loginInfoQueryObject.getCurrentPage(),
                    loginInfoQueryObject.getPageSize()
            );
        } else {
            pageResultSet = PageResultSet.empty(loginInfoQueryObject.getPageSize());
        }

        return pageResultSet;
    }

}
