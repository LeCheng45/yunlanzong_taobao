package com.yunlan.dao;

import com.yunlan.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

//@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test(){
        User user=new User();
        user.setLoginName("13711113333");
        user.setPasswordMd5("e10adc3949ba59abbe56e057f20f883e");
        userMapper.insert(user);
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}