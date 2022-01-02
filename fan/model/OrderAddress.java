package com.yunlan.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单收货地址关联表
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class OrderAddress implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long orderId;

      /**
     * 收货人姓名
     */
      private String userName;

      /**
     * 收货人手机号
     */
      private String userPhone;

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


}
