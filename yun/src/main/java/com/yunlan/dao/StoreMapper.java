package com.yunlan.dao;

import com.yunlan.model.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Mapper
public interface StoreMapper extends BaseMapper<Store> {

    @Select("select `goods_id` from goods_info where `store_id`=#{store_id}")
    List<String> selectGoodIds(@Param("store_id") Integer store_id);


}
