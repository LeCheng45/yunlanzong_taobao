package com.yunlan.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yunlan.controller.form.StoreRegisterForm;
import com.yunlan.controller.form.UploadGoodForm;
import com.yunlan.controller.form.UserRegisterForm;
import com.yunlan.dao.GoodsInfoMapper;
import com.yunlan.model.GoodsInfo;
import com.yunlan.result.R;
import com.yunlan.service.StoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@CrossOrigin
@RestController
@RequestMapping("/store")
public class StoreController {


    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    private StoreService storeService;

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @GetMapping("/isStore")
    public R isStore(@RequestParam("userId")Integer userId){
        return storeService.isStore(userId);
    }

    @PostMapping("/register")
    public R registerStore(StoreRegisterForm storeRegisterForm){
        return storeService.registerStore(storeRegisterForm);
    }

    @GetMapping("/allGoods")
    public R getAllGoods(@RequestParam("StoreId") Integer StoreId){
        return storeService.getAllGoodsByStoreId(StoreId);
    }

    @GetMapping("/allOrders")
    public R getAllOrders(@RequestParam("StoreId") Integer StoreId){
        return storeService.getAllOrdersByStoreId(StoreId);
    }


    @PostMapping("/upload")
    public R singleFileUpload(@RequestParam("file") MultipartFile file, UploadGoodForm uploadGoodForm) {
        return storeService.uploadGood(file, uploadGoodForm);
    }
}

