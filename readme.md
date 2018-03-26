##spring

###概念
1. spring是开源的轻量级框架，非侵入式。

2. spring的核心两部分：
    （1）AOP： 面向切片编程，扩展功能不用修改源代码，类似某个功能为某个功能添加监控。
    （2）IOC：控制反转
        - 以前：调用某个类的方法需要手动new对象。
        - 现在：不需要手动new，而是交给spring配置来管理类对象。
        
3. spring是一站式框架
    - spring在javaee三层结构中，每一层都提供了解决技术
        web层：springMVC
        service层： spring的ioc
        dao层：jdbcTemplae
    
4. spring版本
    hibernate5.x
    spring4.x    
    
###spring的ioc操作
1. 把对象的创建交给spring进行管理

2. ioc操作两部分：
    （1）ioc的配置文件方式
    （2）ioc的注解方式

###IOC底层原理  
1. ioc底层原理使用技术
    （1）xml配置文件
    （2）dom4j解析xml
    （3）工厂设计模式
    （4）反射

2. ioc发展历程
    目标：高内聚低耦合（类里面紧密相连。不同的类之间降低关联）

    （1）原始方法
* **耦合度太高。**当people修改时，上层需变动

```txt
public class People {
    public void todo() {}
}
在servlet调用people里面的方法
People people = new People();
people.todo();
```        

   （2）工厂模式解耦操作（过渡方案）
* servlet和Factory耦合了
```txt
public class UserService {
    public void todo() {}
}
public class UserServlet {
    UserService s = Factory.getService();
    s.add();   
}
public class Factory {
    public static UserService getService() {
        return new UserService();
    }
}
```    
   
   (3)IOC       
```txt
public class UserService {

}

public class UserServlet {
    //得到UserService对象
    //原始： new创建
    //中级：factory
    //终极：ioc
    UserFactory.getService();
}

```    
   - (1)创建xml配置文件，配置需要创建的对象类
```xml
<bean id="userService"
      class="com.monk.UserService"></bean>
```    
   - (2)创建工厂类，使用dom4j解析配置文件+反射
```txt
public class UserFactory{
    public static UserSerice getService() {
        //1 使用dom4j解析xml文件
        //根据id值userService，得到id值对应的class属性值
        String classValue = "class属性值"；
        //2 使用反射创建类对象
        Class clazz = Class.forName(classValue);
        //创建类对象
        UserService service = clazz.newInstance()
        return service;
    }
}
```   
    
###IOC入门案例
第一步 导入jar包（咱们可以用spring boot）
```xml
<!--pom文件继承至group为boot，aritifact为parent的pom文件-->
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.2.3.RELEASE</version>
</parent>
<!--引入spring预设的一些web依赖-->
<!--@SpringBootApplication-->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```

第二步 创建类，在类里面创建方法
    参照com.lessionOne.User
    
第三步 创建spring配置文件，配置创建类
    (1)spring核心配置文件名称和位置不是固定的
     - 建议放到src下面，官方建议applicationContext.xml
     - 咱们用bean1.xml
    (2)引入schema约束     
     
第四步 写代码测试对象创建
    (1)测试代码（不可再实际中用）
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            
        