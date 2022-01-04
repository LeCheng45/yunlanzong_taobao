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
    public class ShoppingCartItem implements Serializable {
  public ShoppingCartItem(Long cartItemId, Integer goodsCount) {
    this.cartItemId = cartItemId;
    this.goodsCount = goodsCount;
  }

  public ShoppingCartItem() {

  }

  private static final long serialVersionUID = 1L;

      /**
     * 购物车主键id
     */
        @TableId(value = "cart_item_id", type = IdType.AUTO)
      private Long cartItemId;

      /**
     * 用户主键id
     */
      private Long userId;

      /**
     * 关联商品id
     */
      private Long goodsId;

      /**
     * 数量(最大为5)
     */
      private Integer goodsCount;

      /**
     * 删除标识字段(0-未删除 1-已删除)
     */
      private Integer isDeleted;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 最新修改时间
     */
      private LocalDateTime updateTime;


}
