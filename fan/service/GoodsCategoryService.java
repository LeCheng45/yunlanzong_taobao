package com.yunlan.service;

import com.yunlan.controller.form.UserRegisterForm;
import com.yunlan.model.GoodsCategory;
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
public interface GoodsCategoryService extends IService<GoodsCategory> {



    R getCategory();

}
