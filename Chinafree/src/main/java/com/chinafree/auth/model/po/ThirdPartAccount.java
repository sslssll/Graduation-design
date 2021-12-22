package com.chinafree.auth.model.po;

import lombok.Data;

/**
 * 第三方登录实体类
 */
@Data
public class ThirdPartAccount extends BaseEntity {
    private String loginId;
    private String openId;
    private String thirdPartyAccountType;
}
