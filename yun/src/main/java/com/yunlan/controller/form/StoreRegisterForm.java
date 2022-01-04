package com.yunlan.controller.form;

import lombok.Data;

@Data
public class StoreRegisterForm {

    /**
     * 商家昵称
     */
    private String storeName;

    /**
     * 用户主键id
     */
    private Long userId;

    /**
     * 个性签名
     */
    private String introduceSign;

}
