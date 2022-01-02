package com.yunlan.model;

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
    public class UserToken implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 用户主键id
     */
        private Long userId;

      /**
     * token值(32位字符串)
     */
      private String token;

      /**
     * 修改时间
     */
      private LocalDateTime updateTime;

      /**
     * token过期时间
     */
      private LocalDateTime expireTime;


}
