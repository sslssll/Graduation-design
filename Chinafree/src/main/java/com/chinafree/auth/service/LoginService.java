package com.chinafree.auth.service;

import com.chinafree.auth.model.param.LoginParam;
import com.chinafree.auth.model.result.LoginResult;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResult loginByUsernameAndPwd(LoginParam body);
}
