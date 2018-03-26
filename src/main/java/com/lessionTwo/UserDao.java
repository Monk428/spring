package com.lessionTwo;

import org.springframework.stereotype.Component;

@Component(value = "userDao")
public class UserDao {

    public void add() {
        System.out.println("dao....");
    }
}
