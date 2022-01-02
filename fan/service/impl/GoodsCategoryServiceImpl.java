package com.yunlan.service.impl;

import com.yunlan.controller.vo.GoodsCategoryVO;
import com.yunlan.model.GoodsCategory;
import com.yunlan.dao.GoodsCategoryMapper;
import com.yunlan.result.R;
import com.yunlan.service.GoodsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Service
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory> implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public R getCategory() {
        List<GoodsCategory> goodsCategories = goodsCategoryMapper.selectList(null);
        List<GoodsCategoryVO> goodsCategoryVOS = new ArrayList<>();
        for (GoodsCategory category : goodsCategories) {
            GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO();
            BeanUtils.copyProperties(category, goodsCategoryVO);
            goodsCategoryVOS.add(goodsCategoryVO);
        }

        return new R(true, "查询成功", goodsCategoryVOS);

    }
}
