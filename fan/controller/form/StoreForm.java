package com.yunlan.controller.form;

import lombok.Data;

@Data
public class StoreForm{
    private Long storeId;

    private String storeName;

    private Long userId;

    private String introduceSign;

    private Integer isDeleted;

    private Integer lockedFlag;
}
