package com.yunlan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunlan.controller.form.*;
import com.yunlan.controller.vo.GoodsVO;
import com.yunlan.controller.vo.OrderVO;
import com.yunlan.dao.*;
import com.yunlan.model.*;
import com.yunlan.result.R;
import com.yunlan.service.AdminService;
import com.yunlan.util.MD5Util;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    StoreMapper storeMapper;

    @Autowired
    GoodsInfoMapper goodsInfoMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public R login(AdminLoginForm adminLoginForm) {
        String passwordMD5 = MD5Util.MD5Encode(adminLoginForm.getPassword(), "UTF-8");
        Admin admin=adminMapper.selectOne(new QueryWrapper<Admin>()
                .eq("admin_name",adminLoginForm.getLoginName())
                .eq("admin_password",passwordMD5)
        );

        if ( admin==null){
            return new R(false,"账号或密码错误");
        }


        return new R(true,"登录成功");
    }

    @Override
    public R getAllUserInfo() {
        List<User> userList =userMapper.selectList(null);
        if(userList.isEmpty()) {
            return new R(false, "获取用户信息失败", null);
        }
        return new R(true,"获取用户信息成功",userList);
    }

    @Override
    public R getAllStoreInfo() {
        List<Store> storeList =storeMapper.selectList(null);
        if(storeList.isEmpty()) {
            return new R(false, "获取商店信息失败", null);
        }
        return new R(true,"获取商店信息成功",storeList);
    }

    @Override
    public R getAllGoodsInEachStore(Long storeId) {
        List<GoodsInfo> goodsInfoList =goodsInfoMapper.selectList(new QueryWrapper<GoodsInfo>().eq("store_id",storeId));
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
    public R getAdminInfo(Long adminId) {
        Admin admin = adminMapper.selectById(adminId);

        return new R(true, "查询管理员信息成功", admin);
    }

    @Override
    public R updateUserInfo(UserForm userForm) {
        List<User> userList = userMapper.selectList(null);
        int flag = 0;
        for (User user : userList) {
            if(flag == 1) { break; }
            if(user.getUserId() == userForm.getUserId()) { flag = 1; }
        }
        if(flag == 0) { return new R(false, "用户不存在", null); }
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        user.setPasswordMd5(MD5Util.MD5Encode(user.getPasswordMd5(), "UTF-8"));

        int i = userMapper.updateById(user);
        if(i != 1) {
            return new R(false, "修改用户信息失败", null);
        }
        return new R(true, "修改用户信息成功", null);
    }

    @Override
    public R removeUser(Long userId) {


        User user=userMapper.selectById(userId);
        if (user==null){
            return new R(false, "没有此用户", null);
        }
        userMapper.deleteById(userId);
        return new R(true, "删除用户成功", null);
    }

    @Override
    public R addUser(UserForm userForm) {
        List<User> userList = userMapper.selectList(null);
        int flag = 0;
        for (User user : userList) {
            if(user.getUserId() == userForm.getUserId()) { flag = 1; }
        }
        if(flag == 1) { return new R(false, "用户已存在", null); }
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        int insert = userMapper.insert(user);
        if(insert != 1) {
            return new R(false, "添加用户信息失败", null);
        }

        return new R(true, "添加用户信息成功", null);
    }

    @Override
    public R updateStore(StoreForm storeForm) {
        List<Store> storeList = storeMapper.selectList(null);
        int flag = 0;
        for (Store store : storeList) {
            if(flag == 1) { break; }
            if(store.getStoreId() == storeForm.getStoreId()) { flag = 1; }
        }
        if(flag == 0) { return new R(false, "店铺不存在", null); }
        Store store = new Store();
        BeanUtils.copyProperties(storeForm, store);
        int i = storeMapper.updateById(store);
        if(i != 1) {
            return new R(false, "修改店铺信息失败", null);
        }
        return new R(true, "修改店铺信息成功", null);
    }

    @Override
    public R removeStore(Long storeId) {
        List<Store> storeList = storeMapper.selectList(null);
        int flag = 0;
        for (Store store : storeList) {
            if(flag == 1) { break; }
            if(store.getStoreId() == storeId) { flag = 1; }
        }
        if(flag == 0) { return new R(false, "店铺不存在", null); }
        Store store = new Store();
        store = storeMapper.selectById(storeId);
        store.setIsDeleted(1);
        int i = storeMapper.updateById(store);
        if(i != 1) {
            return new R(false, "删除店铺失败", null);
        }

        return new R(true, "删除店铺成功", null);
    }

    @Override
    public R addStore(StoreForm storeForm) {
        List<Store> storeList = storeMapper.selectList(null);
        int flag = 0;
        for (Store store : storeList) {
            if(store.getStoreId() == storeForm.getStoreId()) { flag = 1; }
        }
        if(flag == 1) { return new R(false, "店铺已存在", null); }
        Store store = new Store();
        BeanUtils.copyProperties(storeForm, store);
        int insert = storeMapper.insert(store);
        if(insert != 1) {
            return new R(false, "添加店铺信息失败", null);
        }

        return new R(true, "添加店铺信息成功", null);
    }

    @Override
    public R updateGood(GoodForm goodForm) {
        List<GoodsInfo> goodsInfoList = goodsInfoMapper.selectList(null);
        int flag = 0;
        for (GoodsInfo goodsInfo : goodsInfoList) {
            if(flag == 1) { break; }
            if(goodsInfo.getGoodsId() == goodForm.getGoodsId()) { flag = 1; }
        }
        if(flag == 0) { return new R(false, "商品不存在", null); }
        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(goodForm, goodsInfo);
        int i = goodsInfoMapper.updateById(goodsInfo);
        if(i != 1) {
            return new R(false, "修改商品信息失败", null);
        }
        return new R(true, "修改商品信息成功", null);
    }

    @Override
    public R removeGood(Long goodsId) {

        goodsInfoMapper.deleteById(goodsId);

        return new R(true, "删除商品成功", null);
    }

    @Override
    public R addGood(GoodForm goodForm) {
        List<GoodsInfo> goodsInfoList = goodsInfoMapper.selectList(null);
        int flag = 0;
        for (GoodsInfo goodsInfo : goodsInfoList) {
            if(goodsInfo.getGoodsId() == goodForm.getGoodsId()) { flag = 1; }
        }
        if(flag == 1) { return new R(false, "商品已存在", null); }
        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(goodForm, goodsInfo);
        goodsInfo.setStoreId(goodsInfoMapper.selectStoreIdByName(goodForm.getStoreName()));
        int insert = goodsInfoMapper.insert(goodsInfo);
        if(insert != 1) {
            return new R(false, "添加商品信息失败", null);
        }

        return new R(true, "添加商品信息成功", null);
    }

    @Override
    public R getAllOrderInfo() {
        List<OrderItem> orderItemList = orderItemMapper.selectList(null);
        List<OrderVO> orderVOList=new ArrayList<>();
        for (OrderItem orderItem:orderItemList){
            OrderVO orderVO=new OrderVO();
            BeanUtils.copyProperties(orderItem,orderVO);
            orderVOList.add(orderVO);
        }

        return new R(true,"获取订单信息成功",orderVOList);
    }

    @Override
    public R updateOrder(OrderForm orderForm) {
        List<OrderItem> orderItemList = orderItemMapper.selectList(null);
        int flag = 0;
        for (OrderItem orderItem : orderItemList) {
            if(flag == 1) { break; }
            if(orderItem.getOrderItemId() == orderForm.getOrderItemId()) { flag = 1; }
        }
        if(flag == 0) { return new R(false, "订单不存在", null); }
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(orderForm, orderItem);
        int i = orderItemMapper.updateById(orderItem);
        if(i != 1) {
            return new R(false, "修改订单信息失败", null);
        }
        return new R(true, "修改订单信息成功", null);
    }

    @Override
    public R addOrder(OrderForm orderForm) {
        List<OrderItem> orderItemList = orderItemMapper.selectList(null);
        int flag = 0;
        for (OrderItem orderItem : orderItemList) {
            if(orderItem.getOrderItemId() == orderForm.getOrderItemId()) { flag = 1; }
        }
        if(flag == 1) { return new R(false, "订单已存在", null); }
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(orderForm, orderItem);
        int insert = orderItemMapper.insert(orderItem);
        if(insert != 1) {
            return new R(false, "添加订单信息失败", null);
        }

        return new R(true, "添加订单信息成功", null);
    }

    @Override
    public R removeOrder(Long orderItemId) {
        orderItemMapper.deleteById(orderItemId);
        return new R(true, "删除订单成功", null);
    }



}
