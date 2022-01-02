package com.yunlan.dao;

import com.yunlan.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where `login_name`= #{loginName}")
    User selectByLoginName(@Param("loginName") String loginName);

}
