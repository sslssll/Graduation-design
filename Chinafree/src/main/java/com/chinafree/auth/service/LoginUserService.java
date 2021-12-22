package com.chinafree.auth.service;


import com.chinafree.auth.model.po.LoginUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public interface LoginUserService  {
    //根据邮箱获取用户信息
    LoginUser getLoginUserByLoginMail(String loginMail);
    //根据手机获取用户信息
    LoginUser getLoginUserByLoginMobile(String loginMobile);
    //根据OpenId获取用户信息
    LoginUser getLoginUserByOpenId(String openId, String thirdPartAccountType);
    //计算该邮箱登录的用户个数
    int countByLoginMail(String loginMail);
    //计算该手机号码登录的用户个数
    int countByLoginMobile(String loginMobile);
    //修改密码
    void modifyPassword(String loginId, String password);


}
