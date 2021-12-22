package com.chinafree.auth.model.po;


import lombok.Data;

/**
 * 用户影射实体类
 */
@Data
public class LoginRef extends BaseEntity {
    private String loginId;
    private String userId;
}
