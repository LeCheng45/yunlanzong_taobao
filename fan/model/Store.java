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
    public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 商家主键id
     */
        @TableId(value = "store_id", type = IdType.AUTO)
      private Long storeId;

      /**
     * 商家昵称
     */
      private String storeName;

      /**
     * 用户主键id
     */
      private Long userId;

      /**
     * 个性签名
     */
      private String introduceSign;

      /**
     * 注销标识字段(0-正常 1-已注销)
     */
      private Integer isDeleted;

      /**
     * 锁定标识字段(0-未锁定 1-已锁定)
     */
      private Integer lockedFlag;

      /**
     * 开通时间
     */
      private LocalDateTime createTime;


}
