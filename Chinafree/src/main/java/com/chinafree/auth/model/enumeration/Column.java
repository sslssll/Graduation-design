package com.chinafree.auth.model.enumeration;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.chinafree.auth.model.po.LoginUser;

public enum Column {


    LOGIN_MAIL("LOGIN_MAIL"),
    LOGIN_MOBILE("LOGIN_MOBILE");


    private String column;


    private Column(final String column){
        this.column=column;
    }


    public String getColumn() {
        return column;
    }

}
