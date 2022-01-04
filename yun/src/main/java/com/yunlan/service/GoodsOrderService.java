package com.yunlan.service;

import com.yunlan.model.GoodsOrder;
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
public interface GoodsOrderService extends IService<GoodsOrder> {

    R getAllOrders(Integer userId);

    R addOrders(Integer userId, Integer cartId);

    R delOrder(Integer userId, Integer oerderId);

    R updateOrder(Integer orderId, Integer status);
}
