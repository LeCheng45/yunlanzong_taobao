package com.yunlan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 收货地址表
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "address_id", type = IdType.AUTO)
      private Long addressId;

      /**
     * 用户主键id
     */
      private Long userId;

      /**
     * 收货人姓名
     */
      private String userName;

      /**
     * 收货人手机号
     */
      private String userPhone;

      /**
     * 是否为默认 0-非默认 1-是默认
     */
      private Integer defaultFlag;

      /**
     * 省
     */
      private String provinceName;

      /**
     * 城
     */
      private String cityName;

      /**
     * 区
     */
      private String regionName;

      /**
     * 收件详细地址(街道/楼宇/单元)
     */
      private String detailAddress;

      /**
     * 删除标识字段(0-未删除 1-已删除)
     */
      private Integer isDeleted;

      /**
     * 添加时间
     */
      private LocalDateTime createTime;

      /**
     * 修改时间
     */
      private LocalDateTime updateTime;


}
