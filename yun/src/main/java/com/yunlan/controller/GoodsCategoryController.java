package com.yunlan.controller;


import com.yunlan.result.R;
import com.yunlan.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/categories")
public class GoodsCategoryController {
    @Autowired
    GoodsCategoryService goodsCategoryService;
    @GetMapping
    public R getCategory(){
       return goodsCategoryService.getCategory();
    }
}

