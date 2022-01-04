package com.yunlan.controller;


import com.yunlan.result.R;
import com.yunlan.service.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class GoodsOrderController {

    @Autowired
    private GoodsOrderService goodsOrderService;

    @GetMapping("/orders")
    public R getOrdersByid(@RequestParam("userId") Integer id) {
        return goodsOrderService.getAllOrders(id);
    }

    @PostMapping("/addOrders")
    public R addOrdersByid(@RequestParam("userId") Integer userId, @RequestParam("cartItemId") Integer id) {
        return goodsOrderService.addOrders(userId,id);
    }
    @GetMapping("/delOrder")
    public R delOrderById(@RequestParam("userId") Integer userId, @RequestParam("orderItemId") Integer id){
        return goodsOrderService.delOrder(userId, id);
    }

    @PostMapping("/updateOrder")
    public R updateById(@RequestParam("orderItemId") Integer orderid, @RequestParam("status") Integer status){
        return goodsOrderService.updateOrder(orderid,status);
    }
}