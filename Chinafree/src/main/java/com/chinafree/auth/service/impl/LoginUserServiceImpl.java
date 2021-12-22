package com.chinafree.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinafree.auth.mapper.UserMapper;
import com.chinafree.auth.model.enumeration.Column;
import com.chinafree.auth.model.po.LoginUser;
import com.chinafree.auth.service.LoginUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginUser getLoginUserByLoginMail(String loginMail) {
        QueryWrapper<LoginUser> loginUserQueryWrapper = new QueryWrapper<>();
        loginUserQueryWrapper.eq(Column.LOGIN_MAIL.getColumn(), loginMail);
        LoginUser user = userMapper.selectOne(loginUserQueryWrapper);
        return user;
    }

    @Override
    public LoginUser getLoginUserByLoginMobile(String loginMobile) {
        QueryWrapper<LoginUser> loginUserQueryWrapper = new QueryWrapper<>();
        loginUserQueryWrapper.eq(Column.LOGIN_MOBILE.getColumn(), loginMobile);
        LoginUser user = userMapper.selectOne(loginUserQueryWrapper);
        return user;
    }

    @Override
    public LoginUser getLoginUserByOpenId(String openId, String thirdPartAccountType) {
        return null;
    }

    @Override
    public int countByLoginMail(String loginMail) {
        return 0;
    }

    @Override
    public int countByLoginMobile(String loginMobile) {
        return 0;
    }

    @Override
    public void modifyPassword(String loginId, String password) {

    }
}
