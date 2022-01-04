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
    public class GoodsInfo implements Serializable {

    private static final long serialVersionUID = 1L;
      /**
     * 商品表主键id
     */
        @TableId(value = "goods_id", type = IdType.AUTO)
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
     * 商品主图
     */
      private String goodsCoverImg;

      /**
     * 商品轮播图
     */
      private String goodsCarousel;

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
     * 商品标签
     */
      private String tag;

      /**
     * 商品上架状态 1-下架 0-上架
     */
      private Integer goodsSellStatus;

      /**
     * 添加者主键id
     */
      private Integer createUser;

      /**
     * 商品添加时间
     */
      private LocalDateTime createTime;

      /**
     * 修改者主键id
     */
      private Integer updateUser;

      /**
     * 商品修改时间
     */
      private LocalDateTime updateTime;

      /**
     * 商家主键id
     */
      private Long storeId;


}
