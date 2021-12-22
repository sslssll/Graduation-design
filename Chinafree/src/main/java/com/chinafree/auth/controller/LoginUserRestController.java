package com.chinafree.auth.controller;

import com.chinafree.auth.model.param.LoginParam;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.auth.service.LoginService;


import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.chinafree.common.model.request.RequestParameter;
import com.chinafree.common.model.response.EntityResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2018/8/24 14:33
 */
@RestController
@Api(produces = "application/json",tags = "LoginUserRestController",description="登录接口")
public class LoginUserRestController  {
    private static final String EMAIL_LOGIN_URL = "/normal/login";
    private static final String SHORT_MESSAGE_LOGIN_URL = "/short/message/login";
    private static final String THIRD_PART_LOGIN_URL = "/third/part/login";

    @Autowired
    private LoginService loginService;

    @ApiOperation(value="正常登录" , notes = "邮箱和手机+密码登录")
    @RequestMapping(value = EMAIL_LOGIN_URL, method = RequestMethod.POST)
    public EntityResponse<LoginResult> emailLogin(@RequestBody RequestParameter<LoginParam> request) {
        LoginParam loginParam = request.getBody();
        LoginResult loginResult = loginService.loginByUsernameAndPwd(loginParam);
        return new EntityResponse<>(ResponseCodeEnum.SUCCESS,"登录成功",null);

    }

}
