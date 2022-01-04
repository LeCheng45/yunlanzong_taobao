package com.yunlan.controller.form;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UploadGoodForm {
    private Long goodsId;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 商品简介
     */
    private String goodsIntro;

    /**
     * 关联分类id
     */
    private Long goodsCategoryId;

    /**
     * 商品详情
     */
    private String goodsDetailContent;

    /**
     * 商品实际售价
     */
    private Integer sellingPrice;

    /**
     * 商家主键id
     */
    private Long storeId;

}
