package com.yunlan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 订单关联购物项主键id
     */
        @TableId(value = "order_item_id", type = IdType.AUTO)
      private Long orderItemId;

      /**
     * 订单主键id
     */
      private Long orderId;

      /**
     * 关联商品id
     */
      private Long goodsId;

      /**
     * 下单时商品的名称(订单快照)
     */
      private String goodsName;

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
   * 用户主键id
   */
  private Long userId;

  /**
   * 订单总价
   */
  private Integer totalPrice;

  /**
   * 订单状态:0.待支付 1.已支付 2.配货完成 3:出库成功 4.交易成功 -1.手动关闭 -2.超时关闭 -3.商家关闭
   */
  private Integer orderStatus;

}
