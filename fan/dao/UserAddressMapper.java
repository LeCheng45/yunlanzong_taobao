package com.yunlan.dao;

import com.yunlan.model.UserAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 收货地址表 Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress> {

}
