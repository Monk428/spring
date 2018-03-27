package com.lessionTwoPro;

public class UserService {

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;

    public void add() {
        System.out.println("Service....");
        userDao.add();
    }
}
