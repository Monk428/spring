package com.lessionTwo.aop;

//增强类
public class EnhanceBook {
    public void before1() {
        System.out.println("前置增强");
    }

    public void after1() {
        System.out.println("后置增强");
    }

}
