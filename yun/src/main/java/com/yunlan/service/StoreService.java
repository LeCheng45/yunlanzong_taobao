package com.yunlan.service;

import com.yunlan.controller.form.StoreRegisterForm;
import com.yunlan.controller.form.UploadGoodForm;
import com.yunlan.model.Store;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunlan.result.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
public interface StoreService extends IService<Store> {

    R getAllGoodsByStoreId(Integer storeId);

    R isStore(Integer userId);

    R registerStore(StoreRegisterForm storeRegisterForm);

    R getAllOrdersByStoreId(Integer storeId);

    R uploadGood(MultipartFile file, UploadGoodForm uploadGoodForm);
}
