package com.yunlan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunlan.controller.form.GoodForm;
import com.yunlan.controller.vo.ShoppingCartVO;
import com.yunlan.dao.GoodsInfoMapper;
import com.yunlan.model.GoodsInfo;
import com.yunlan.model.ShoppingCartItem;
import com.yunlan.dao.ShoppingCartItemMapper;
import com.yunlan.result.R;
import com.yunlan.service.ShoppingCartItemService;
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
public class ShoppingCartItemServiceImpl extends ServiceImpl<ShoppingCartItemMapper, ShoppingCartItem> implements ShoppingCartItemService {
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private ShoppingCartItemMapper shoppingCartItemMapper;

    @Override
    public R getShoppingCartById(long id){


        List<ShoppingCartItem> shoppingCartItemList=shoppingCartItemMapper
                .selectList(new QueryWrapper<ShoppingCartItem>()
                        .eq("user_id",id));

        List<ShoppingCartVO> shoppingCartVOList=new ArrayList<>();

        for (ShoppingCartItem s: shoppingCartItemList){
            ShoppingCartVO sVO=new ShoppingCartVO();

            GoodsInfo g =goodsInfoMapper.selectById(s.getGoodsId());
            if(g!=null) BeanUtils.copyProperties(g,sVO);
            BeanUtils.copyProperties(s,sVO);

            shoppingCartVOList.add(sVO);

        }
        return new R(true,"获取购物车信息成功",shoppingCartVOList);
    }


    @Override
    public R addGoodToCart(long userId, long GoodsId){
        ShoppingCartItem shoppingCartItem=new ShoppingCartItem();
        shoppingCartItem.setUserId(userId);
        shoppingCartItem.setGoodsId(GoodsId);
        shoppingCartItem.setGoodsCount(1);

        if (shoppingCartItemMapper.selectOne(new QueryWrapper<ShoppingCartItem>()
                .eq("user_id",userId)
                .eq("goods_id",GoodsId))!=null){
            return new R(true,"该商品已经在购物车");
        }
        shoppingCartItemMapper.insert(shoppingCartItem);
        return new R(true,"添加成功");
    }

    @Override
    public R delGood(long id){
        shoppingCartItemMapper.deleteById(id);
        return new R(true,"删除成功");
    }



    @Override
    public R updateGood(long id,Integer count){
        shoppingCartItemMapper.updateById(new ShoppingCartItem(id,count));
        return new R(true,"更新成功");
    }
}
