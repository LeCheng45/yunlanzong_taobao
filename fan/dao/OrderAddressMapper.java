package com.yunlan.dao;

import com.yunlan.model.OrderAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单收货地址关联表 Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Mapper
public interface OrderAddressMapper extends BaseMapper<OrderAddress> {

}
