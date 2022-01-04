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
    public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 分类id
     */
        @TableId(value = "category_id", type = IdType.AUTO)
      private Long categoryId;

      /**
     * 分类级别(1-一级分类 2-二级分类 3-三级分类)
     */
      private Integer categoryLevel;

      /**
     * 父分类id
     */
      private Long parentId;

      /**
     * 分类名称
     */
      private String categoryName;

      /**
     * 排序值(字段越大越靠前)
     */
      private Integer categoryRank;

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
