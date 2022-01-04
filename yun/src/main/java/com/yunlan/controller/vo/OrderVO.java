package com.yunlan.controller.vo;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OrderVO implements Serializable {

    /**
     * 订单id
     */
    private Long orderItemId;
    /**
     * 关联商品id
     */
    private Long goodsId;
    /**
     * 下单时商品的名称(订单快照)
     */
    private String goodsName;

    /**
     * 订单商品分类id
     */
    private Long categoryId;

    /**
     * 下单时商品的主图(订单快照)
     */
    private String goodsCoverImg;

    /**
     * 下单时商品的价格(订单快照)
     */
    private Integer sellingPrice;

    /**
     * 数量(订单快照)
     */
    private Integer goodsCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单状态:0.待支付 1.已支付 2.配货完成 3:出库成功 4.交易成功 -1.手动关闭 -2.超时关闭 -3.商家关闭
     */
    private Integer orderStatus;


    private String loginName;

    private Long userId;
}