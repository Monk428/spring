package com.lessionOne.ioc;

public class UserService {
//    1定义dao属性
    private UserDao userDao;
//    2生成set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add");
        userDao.add();
    }
}
