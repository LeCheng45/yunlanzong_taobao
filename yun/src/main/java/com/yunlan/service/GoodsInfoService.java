package com.yunlan.service;

import com.yunlan.model.GoodsInfo;
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
public interface GoodsInfoService extends IService<GoodsInfo> {

    R getAllGoods();

    R getGoodsById(Long id);

    R getGoodById(Long id);

    R searchGoodsByName(String goodName);

    R getCommentById(long goodId);

    R addComment(Integer orderId, String cmt);
}
