package com.yunlan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunlan.controller.vo.GoodsVO;
import com.yunlan.model.GoodsInfo;
import com.yunlan.dao.GoodsInfoMapper;
import com.yunlan.result.R;
import com.yunlan.service.GoodsInfoService;
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
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsInfoService {
    @Autowired
    private  GoodsInfoMapper goodsInfoMapper;

    @Override
    public R getAllGoods(){
        List<GoodsInfo> goodsInfoList =goodsInfoMapper.selectList(null);
        List<GoodsVO> goodsVOList=new ArrayList<>();
        for (GoodsInfo goodsInfo:goodsInfoList){
            GoodsVO goodsVO=new GoodsVO();
            BeanUtils.copyProperties(goodsInfo,goodsVO);
            goodsVO.setStoreName(goodsInfoMapper.selectStoreNameById(goodsInfo.getStoreId()));
            goodsVOList.add(goodsVO);
        }

        return new R(true,"获取商品信息成功",goodsVOList);
    }

    @Override
    public R getGoodsById(Long id){
        List<GoodsInfo> goodsInfoList =goodsInfoMapper.selectList(new QueryWrapper<GoodsInfo>().eq("goods_category_id",id));
        List<GoodsVO> goodsVOList=new ArrayList<>();
        for (GoodsInfo goodsInfo:goodsInfoList){
            GoodsVO goodsVO=new GoodsVO();
            BeanUtils.copyProperties(goodsInfo,goodsVO);
            goodsVO.setStoreName(goodsInfoMapper.selectStoreNameById(goodsInfo.getStoreId()));
            goodsVOList.add(goodsVO);
        }

        return new R(true,"获取商品信息成功",goodsVOList);
    }


    @Override
    public R getGoodById(Long id){
        GoodsVO goodsVO=new GoodsVO();
        GoodsInfo goodsInfo=goodsInfoMapper.selectById(id);
        BeanUtils.copyProperties(goodsInfo,goodsVO);
        goodsVO.setStoreName(goodsInfoMapper.selectStoreNameById(goodsInfo.getStoreId()));
        return new R(true,"获取商品信息成功",goodsVO);
    }
}