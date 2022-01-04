package com.yunlan.dao;
import org.springframework.beans.BeanUtils;
import com.yunlan.controller.vo.GoodsCategoryVO;
import com.yunlan.model.GoodsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsCategoryMapperTest {

    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    @Test
    void test(){
        List<GoodsCategory> goodsCategories=goodsCategoryMapper.selectList(null);
        List<GoodsCategoryVO> goodsCategoryVOS= new ArrayList<>();
        for (GoodsCategory category :goodsCategories){
            GoodsCategoryVO goodsCategoryVO=new GoodsCategoryVO();
            BeanUtils.copyProperties(category,goodsCategoryVO);
        }
    }
}