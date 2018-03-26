package com.lessionTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserService {

//    得到dao对象
    //1.定义dao类型属性
    //在dao属性上使用注解完成对象注入
//    @Autowired
    @Resource(name = "userDao")
    private UserDao userDao;
    //使用注解时，不需要set方法


    public void add() {
        System.out.println("service ...");
        userDao.add();
    }
}
