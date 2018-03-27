package com.lessionThree;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EenhanceBook {

    @Before(value = "execution(* com.lessionThree.Ebook.add(..))")
    public void before1() {
        System.out.println("前置增强");
    }
    @After(value = "execution(* com.lessionThree.Ebook.add(..))")


    public void after1() {
        System.out.println("后置增强");
    }

    @Around(value = "execution(* com.lessionThree.Ebook.del(..))")
    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法之前
        System.out.println("方法之前");

        //执行被增强的方法
        proceedingJoinPoint.proceed();

        //方法之后
        System.out.println("方法之后");
    }
}
