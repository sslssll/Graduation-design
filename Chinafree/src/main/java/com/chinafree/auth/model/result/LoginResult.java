package com.chinafree.auth.model.result;

import lombok.Builder;
import lombok.Data;

import java.util.List;


/**
 * 用户登录返回值
 */
@Data
@Builder
public class LoginResult {
    private String loginId;
    private Integer loginUserType;
    private String userType;
    private String userId;
    private boolean isRegister;
//    private String token;
//    private List<ThirdPartAccountResult> thirdPartAccountResults;
}
