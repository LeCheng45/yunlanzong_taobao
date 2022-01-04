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
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;
      /**
     * 用户主键id
     */
        @TableId(value = "user_id", type = IdType.AUTO)
      private Long userId;

      /**
     * 用户昵称
     */
      private String nickName;

      /**
     * 登陆名称(默认为手机号)
     */
      private String loginName;

      /**
     * MD5加密后的密码
     */
      private String passwordMd5;

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
     * 注册时间
     */
      private LocalDateTime createTime;


}
