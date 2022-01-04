package com.yunlan.controller.vo;

import lombok.Data;

@Data
public class StoreVO {

    private Long storeId;
    /**
     * 商家昵称
     */
    private String storeName;


    /**
     * 个性签名
     */
    private String introduceSign;

}
