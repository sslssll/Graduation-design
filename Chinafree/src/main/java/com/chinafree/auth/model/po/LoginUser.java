package com.chinafree.auth.model.po;

//import com.chinafree.registermodule.domain.entity.LoginRef;
//import com.chinafree.registermodule.domain.entity.ThirdPartAccount;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Builder
@TableName("user")
@Data
public class LoginUser {

    private String id;
    private String loginName;
    private String loginMobile;
    private String loginMail;
    private String password;
    private String loginStatus;
    private Date lastLoginTime;
    private String lastLoginIp;
    private String lastLoginDevice;
    private Date registerTime;
    private String loginUserType;
    private String userId;
    private LoginRef loginRef;
    private List<ThirdPartAccount> thirdPartAccountList;
}
