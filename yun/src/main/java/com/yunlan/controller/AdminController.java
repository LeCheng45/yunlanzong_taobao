package com.yunlan.controller;


import com.yunlan.controller.form.*;
import com.yunlan.result.R;
import com.yunlan.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public R login(AdminLoginForm adminLoginForm) { return adminService.login(adminLoginForm); }

    @GetMapping("/usersInfo")
    public R UserInfo() { return adminService.getAllUserInfo(); }

    @GetMapping("/storesInfo")
    public R StoreInfo() { return adminService.getAllStoreInfo(); }

    @PostMapping("/storesInfo/update")
    public R modifyStore(StoreForm storeForm) { return adminService.updateStore(storeForm); }

    @PostMapping("/storesInfo/delete")
    public R deleteStore(@RequestParam("storeId") Long storeId) { return adminService.removeStore(storeId); }

    @PostMapping("/storesInfo/insert")
    public R insertStore(StoreForm storeForm) { return adminService.addStore(storeForm); }

    @GetMapping("/storesInfo/goods")
    public R GoodsInStore(@RequestParam("storeId") Long storeId) { return adminService.getAllGoodsInEachStore(storeId);}

    @PostMapping("/storesInfo/goods/update")
    public R modifyGood(GoodForm goodForm) { return adminService.updateGood(goodForm); }

    @PostMapping("storesInfo/goods/delete")
    public R deleteGood(@RequestParam("goodsId") Long goodsId) { return adminService.removeGood(goodsId); }

    @PostMapping("storesInfo/goods/insert")
    public R insertGood(GoodForm goodForm) { return adminService.addGood(goodForm); }

    @GetMapping("/info")
    public R AdminInfo(@RequestParam("adminId") Long adminId) { return adminService.getAdminInfo(adminId); }

    @PostMapping("/usersInfo/update")
    public R modifyUserInfo(UserForm userForm) { return adminService.updateUserInfo(userForm); }

    @PostMapping("/usersInfo/delete")
    public R deleteUser(@RequestParam("userId") Long userId) { return adminService.removeUser(userId); }

    @PostMapping("/usersInfo/insert")
    public R insertUser(UserForm userForm) { return adminService.addUser(userForm); }

    @GetMapping("/ordersInfo")
    public R getAllOrders() { return adminService.getAllOrderInfo(); }

    @PostMapping("/ordersInfo/update")
    public R modifyOrder(OrderForm orderForm) { return adminService.updateOrder(orderForm); }

    @PostMapping("/ordersInfo/delete")
    public R deleteOrder(@RequestParam("orderItemId") Long orderItemId) { return adminService.removeOrder(orderItemId); }

    @PostMapping("/ordersInfo/insert")
    public R insertOrder(OrderForm orderForm) { return adminService.addOrder(orderForm); }
}