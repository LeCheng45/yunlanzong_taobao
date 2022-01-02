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
    public class MallCarousel implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 首页轮播图主键id
     */
        @TableId(value = "carousel_id", type = IdType.AUTO)
      private Integer carouselId;

      /**
     * 轮播图
     */
      private String carouselUrl;

      /**
     * 点击后的跳转地址(默认不跳转)
     */
      private String redirectUrl;

      /**
     * 排序值(字段越大越靠前)
     */
      private Integer carouselRank;

      /**
     * 删除标识字段(0-未删除 1-已删除)
     */
      private Integer isDeleted;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 创建者id
     */
      private Integer createUser;

      /**
     * 修改时间
     */
      private LocalDateTime updateTime;

      /**
     * 修改者id
     */
      private Integer updateUser;


}
