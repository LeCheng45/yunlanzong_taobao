package com.yunlan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunlan.controller.form.UserLoginForm;
import com.yunlan.controller.form.UserRegisterForm;
import com.yunlan.model.User;
import com.yunlan.dao.UserMapper;
import com.yunlan.result.R;
import com.yunlan.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunlan.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public R register(UserRegisterForm userRegisterForm) {
        if (userMapper.selectByLoginName(userRegisterForm.getLoginName())!=null){
            return new R(false,"该用户名已注册");
        }
        User user=new User();
        user.setLoginName(userRegisterForm.getLoginName());
        user.setNickName(userRegisterForm.getNickName());
        String passwordMD5 = MD5Util.MD5Encode(userRegisterForm.getLoginName(), "UTF-8");
        user.setPasswordMd5(passwordMD5);
        int flag=userMapper.insert(user);
        log.info("flag为"+flag);
        return new R(true,"注册成功");
    }

    @Override
    public R login(UserLoginForm userLoginForm){
       String passwordMD5 = MD5Util.MD5Encode(userLoginForm.getPassword(), "UTF-8");
        User user=userMapper.selectOne(new QueryWrapper<User>()
                .eq("login_name",userLoginForm.getLoginName())
                .eq("password_md5",passwordMD5)
        );

        if ( user==null){
            return new R(false,"账号或密码错误");
        }


        return new R(true,"登录成功");
    }

}
