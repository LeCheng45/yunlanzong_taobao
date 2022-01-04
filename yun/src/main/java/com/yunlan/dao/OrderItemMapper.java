package com.yunlan.dao;

import com.yunlan.model.OrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    @Select("select `goods_category_id` from goods_info where `goods_id` = #{goods_id}")
    Long selectCategoryIdByGoodId(@Param("goods_id") Long goods_id);
}
