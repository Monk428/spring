package com.lessionTwoPro;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanLessionTwoPro.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
        return NONE;
    }
}
