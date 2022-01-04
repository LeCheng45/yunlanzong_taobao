package com.yunlan.dao;

import com.yunlan.model.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2022-01-03
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
