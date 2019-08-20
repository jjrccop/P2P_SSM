package com.gxa.eloan.common.mapper;

import com.gxa.eloan.common.domain.LoginInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoginInfo record);

    LoginInfo selectByPrimaryKey(Long id);

    List<LoginInfo> selectAll();

    int updateByPrimaryKey(LoginInfo record);

    int selectCountByUsername(String username);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    LoginInfo login(@Param("username") String username,
                    @Param("password") String password);

}