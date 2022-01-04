package com.yunlan.controller;


import com.yunlan.result.R;
import com.yunlan.service.ShoppingCartItemService;
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
@RequestMapping("/shoppingCart")
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService shoppingCartItemService;

    @GetMapping
    public R getCartGoods(@RequestParam("userId") long id){
        return shoppingCartItemService.getShoppingCartById(id);
    }

    @PostMapping("/addGood")
    public R addGood(@RequestParam("userId")long userid,@RequestParam("GoodsId")long goodId){
        return shoppingCartItemService.addGoodToCart(userid,goodId);
    }

    @PostMapping("/delGood")
    public R delGood(@RequestParam("cartItemId")long id){
        return shoppingCartItemService.delGood(id);
    }

    @PostMapping("/updateGood")
    public R updateGood(@RequestParam("cartItemId")long id,@RequestParam("count")Integer count){
        return shoppingCartItemService.updateGood(id,count);
    }
}