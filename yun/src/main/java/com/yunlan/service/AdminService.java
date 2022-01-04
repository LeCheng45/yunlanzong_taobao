package com.yunlan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunlan.controller.form.*;
import com.yunlan.model.Admin;
import com.yunlan.result.R;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
public interface AdminService extends IService<Admin> {

    R login(AdminLoginForm adminLoginForm);

    R getAllUserInfo();

    R getAllStoreInfo();

    R getAllGoodsInEachStore(Long storeId);

    R getAdminInfo(Long adminId);

    R updateUserInfo(UserForm userForm);

    R removeUser(Long userId);

    R addUser(UserForm userForm);

    R updateStore(StoreForm storeForm);

    R removeStore(Long storeId);

    R addStore(StoreForm storeForm);

    R updateGood(GoodForm goodForm);

    R removeGood(Long goodsId);

    R addGood(GoodForm goodForm);

    R getAllOrderInfo();

    R updateOrder(OrderForm orderForm);

    R addOrder(OrderForm orderForm);

    R removeOrder(Long orderItemId);
}
