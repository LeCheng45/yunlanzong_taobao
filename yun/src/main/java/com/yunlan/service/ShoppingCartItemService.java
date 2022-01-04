package com.yunlan.service;

import com.yunlan.model.ShoppingCartItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunlan.result.R;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
public interface ShoppingCartItemService extends IService<ShoppingCartItem> {

    R getShoppingCartById(long id);

    R addGoodToCart(long userId, long GoodsId);

    R delGood(long id);


    R updateGood(long id, Integer count);
}
