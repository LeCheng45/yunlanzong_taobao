package com.yunlan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 管理员id
     */
        @TableId(value = "admin_id", type = IdType.AUTO)
      private Long adminId;

      /**
     * 管理员登陆名称
     */
      private String adminName;

      /**
     * 管理员登陆密码
     */
      private String adminPassword;

      /**
     * 管理员显示昵称
     */
      private String nickName;

      /**
     * 是否锁定 0未锁定 1已锁定无法登陆
     */
      private Integer locked;


}
