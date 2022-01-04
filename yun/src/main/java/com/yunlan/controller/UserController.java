package com.yunlan.controller;


import com.yunlan.controller.form.UserLoginForm;
import com.yunlan.controller.form.UserRegisterForm;
import com.yunlan.result.R;
import com.yunlan.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public R register(UserRegisterForm userRegisterForm){
        return userService.register(userRegisterForm);
    }

    @PostMapping("/login")
    public R login(UserLoginForm userLoginForm){
        return  userService.login(userLoginForm);
    }
}