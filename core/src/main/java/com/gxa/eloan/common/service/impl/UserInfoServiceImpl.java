package com.gxa.eloan.common.service.impl;

import com.gxa.eloan.common.domain.LoginInfo;
import com.gxa.eloan.common.domain.UserInfo;
import com.gxa.eloan.common.mapper.UserInfoMapper;
import com.gxa.eloan.common.service.IUserInfoService;
import com.gxa.eloan.common.util.BitStatesUtils;
import com.gxa.eloan.common.util.UserContext;
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

    @Override
    public void updateUserinfo(UserInfo userInfo){
        userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public void updateBasicInfo(UserInfo userInfoVo) {
        try {

            // 获取需要保存userinfo对象（数据库原始对象）
            LoginInfo loginInfo = UserContext.getLoginInfo();
            UserInfo userInfo = getCurrentUserinfo(UserContext.getLoginInfo().getId());

            //将页面提交的数据 设置到原有userinfo对象中
            userInfo.setEducationbackgroundItem(userInfoVo.getEducationbackgroundItem());
            userInfo.setKidcountItem(userInfoVo.getKidcountItem());
            userInfo.setIncomegradeItem(userInfoVo.getIncomegradeItem());
            userInfo.setHouseconditionItem(userInfoVo.getHouseconditionItem());
            userInfo.setMarriageItem(userInfoVo.getMarriageItem());

            // 设置状态码
            if ( !userInfo.getIsBasicInfo()) {
                userInfo.addState(BitStatesUtils.OP_USER_INFO);
            }

            // 更新个人资料
            updateUserinfo(userInfo);

        } catch (Exception e) {
            throw new RuntimeException("个人资料保存出错");

        }
    }

}

