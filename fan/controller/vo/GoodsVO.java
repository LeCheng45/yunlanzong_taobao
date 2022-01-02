package com.yunlan.controller.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class GoodsVO implements Serializable {

    /**
     * 商品id
     */
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
     * 分类id
     */
    private Long goodsCategoryId;

    /**
     * 商品主图
     */
    private String goodsCoverImg;



    /**
     * 商品详情
     */
    private String goodsDetailContent;

    /**
     * 商品价格
     */
    private Integer originalPrice;

    /**
     * 商品实际售价
     */
    private Integer sellingPrice;

    /**
     * 商品库存数量
     */
    private Integer stockNum;

    /**
     * 商家名字
     */
    private String storeName;
}