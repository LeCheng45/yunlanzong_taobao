package com.yunlan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yunlan.controller.vo.OrderVO;
import com.yunlan.dao.GoodsInfoMapper;
import com.yunlan.dao.OrderItemMapper;
import com.yunlan.dao.ShoppingCartItemMapper;
import com.yunlan.model.*;
import com.yunlan.dao.GoodsOrderMapper;
import com.yunlan.result.R;
import com.yunlan.service.GoodsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
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
public class GoodsOrderServiceImpl extends ServiceImpl<GoodsOrderMapper, GoodsOrder> implements GoodsOrderService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Autowired
    private ShoppingCartItemMapper shoppingCartItemMapper;
    @Override
    public R getAllOrders(Integer userId) {

        List<OrderItem> orderItemList = orderItemMapper.selectList(new QueryWrapper<OrderItem>()
                .eq("user_id",userId));
        List<OrderVO> orderItemVOList=new ArrayList<>();
        for (OrderItem orderItem:orderItemList){
            OrderVO orderVO = new OrderVO();
            BeanUtils.copyProperties(orderItem, orderVO);
            orderVO.setGoodsCoverImg(goodsInfoMapper.selectUrlById(orderItem.getGoodsId()));
            orderVO.setCategoryId(orderItemMapper.selectCategoryIdByGoodId(orderItem.getGoodsId()));
            orderItemVOList.add(orderVO);
        }
        return new R(true,"获取订单信息成功",orderItemVOList);
    }
    @Override
    public R addOrders(Integer userId, Integer cartId){
        try {
            ShoppingCartItem cart= shoppingCartItemMapper.selectById(cartId);
            OrderItem orderItem=new OrderItem();
            BeanUtils.copyProperties(cart,orderItem,"createTime");
            GoodsInfo good=goodsInfoMapper.selectById(cart.getGoodsId());
            BeanUtils.copyProperties(good,orderItem,"createTime");
            orderItem.setTotalPrice(orderItem.getSellingPrice()*orderItem.getGoodsCount());

            orderItemMapper.insert(orderItem);

            shoppingCartItemMapper.deleteById(cartId);
            return new R(true,"添加订单成功");
        } catch (BeansException e) {
            e.printStackTrace();
            return new R(false,"添加订单失败");
        }


    }

    @Override
    public R delOrder(Integer userId, Integer orderId){
        try {
            orderItemMapper.deleteById(orderId);
            return new R(true,"删除成功");
        } catch (BeansException e) {
            e.printStackTrace();
            return new R(false,"删除失败");
        }

    }

    @Override
    public R updateOrder(Integer orderId, Integer status){
        try {
            orderItemMapper.update(null,
                    new UpdateWrapper<OrderItem>()
                            .eq("order_item_id",orderId)
                            .set("order_status",status));
        }
        catch (BeansException e){
            e.printStackTrace();
            return new R(false,"更新订单成功");
        }
        return new R(true,"更新订单成功");
    }
}