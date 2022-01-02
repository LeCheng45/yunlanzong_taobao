package com.yunlan.dao;

import com.yunlan.model.GoodsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunlan.model.User;
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
public interface GoodsInfoMapper extends BaseMapper<GoodsInfo> {


    @Select("select `store_name` from store where `store_id`= #{store_id}")
    String selectStoreNameById(@Param("store_id") Long store_id);

    @Select("select `store_id` from store where `store_name`= #{store_name}")
    Long selectStoreIdByName(@Param("store_name") String store_name);
}
