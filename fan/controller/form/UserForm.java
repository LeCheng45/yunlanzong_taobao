package com.yunlan.controller.form;

import lombok.Data;

@Data
public class UserForm {

    private Long userId;

    private String nickName;

    private String loginName;

    private String passwordMd5;

    private String introduceSign;

    private Integer isDeleted;

    private Integer lockedFlag;
}
