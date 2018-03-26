package com.lessionTwo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component(value="user") //<bean id="user" class=""/>
@Service(value="user")
@Scope(value="prototype")
public class User {
    public void add() {
        System.out.println("add....");
    }
}
