package com.yunlan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2022-01-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 评论id
     */
        @TableId(value = "comment_id", type = IdType.AUTO)
      private Long commentId;

      /**
     * 订单关联购物项主键id
     */
      private Long orderItemId;

      /**
     * 评论
     */
      private String comment;

      /**
     * 关联商品id
     */
      private Long goodsId;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 用户id
     */
      private Long userId;

      /**
     * 登陆名称
     */
      private String loginName;


}
