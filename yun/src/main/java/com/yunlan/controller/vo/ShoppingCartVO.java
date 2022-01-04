/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本软件已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2021 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package com.yunlan.controller.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 购物车页面购物项VO
 */

@Data
public class ShoppingCartVO extends GoodsVO implements Serializable {
    /**
     * 购物车主键id
     */
    private Long cartItemId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 数量(最大为5)
     */
    private Integer goodsCount;

}