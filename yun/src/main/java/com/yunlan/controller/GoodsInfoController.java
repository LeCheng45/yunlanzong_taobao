package com.yunlan.controller;


import com.yunlan.dao.GoodsInfoMapper;
import com.yunlan.result.R;
import com.yunlan.service.GoodsInfoService;
import com.yunlan.service.impl.GoodsInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping
public class GoodsInfoController {

    @Autowired
    private GoodsInfoService goodsInfoService;
    @GetMapping("/goods")
    public R  getAllGoods(){
        return goodsInfoService.getAllGoods();
    }
    @GetMapping("/goodsByCategoryId")
    public R  getGoodsById(@RequestParam("goodsCategoryId") Long Id){
        return goodsInfoService.getGoodsById(Id);
    }
    @GetMapping("/goodById")
    public R  getGoodById(@RequestParam("goodsId") Long Id){
        return goodsInfoService.getGoodById(Id);
    }

    @GetMapping("/goodsByName")
    public R getGoodByname(@RequestParam("goods_name") String name){
        return goodsInfoService.searchGoodsByName(name);
    }

    @GetMapping("/comment")
    public R getCommentById(@RequestParam("goodsId") Long Id){
        return goodsInfoService.getCommentById(Id);
    }

    @PostMapping("/addComment")
    public R addComment( @RequestParam("orderItemId") Integer id, @RequestParam("comment") String comment){
        return goodsInfoService.addComment(id, comment);
    }
}
