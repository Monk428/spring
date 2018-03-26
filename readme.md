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
    
###Spring的bean管理
- Bean实例化方式
   1 在spring里通过配置文件创建对象
   
   2 bean实例化三种方式实现
   <!--lessionOne.User-->
   第一种 使用类的**无参构造**创建（重点，主要使用这种），通过xml配置的会调用类的无参构造器
   第二种 使用静态工厂创建 如：test/java/Bean2Factory
      （1） 创建静态的方法，返回类对象（static）
   第三种 使用实例工厂创建  
    
###Bean标签常用属性    
  （1）id属性：名称任意命名，根据id值得到配置对象，不能包含特殊符号
  （2）class属性： 创建对象所在类的全路径
  （3）name属性： 功能与id属性一样，可以包含特殊符号
  （4）scope属性：
      - singleton: 默认值，单例（常用）
      - prototype： 多实例（常用）
      - request： 创建对象，把对象放到request域里面
      - session： 创建对象，把对象放到session域里面 
      - globalSession  创建对象，把对象放到globalSession域里面（单点登录）
    
###有参注入方式 
    <!--lessionOne.property-->
    第一种 有参构造器注入
    第二种 set方法注入 （使用这种）   
    
###注入对象类型属性（重点）
1. 在service里面把dao作为类型属性
2. 生成dao类型属性的set方法   
3. 配置service和dao对象
    通过ref指定bean对象（与上例区别）    
    
###P名称空间注入    
1. xmlns:p="http://www.springframework.org/schema/p"
2. <bean id="person" class="xx" p:pname="lucy">

- 复杂类型注入
1. 数组
2. list集合
3. map集合
4. properties类型
    
###IOC和DI区别
1. IOC： 控制反转，把对象创建交给spring进行配置
2. DI：依赖注入，向类里面的属性中设置值。
3. 关系：依赖注入不能单独存在，需要在ioc基础上完成。    
    
###Spring整合web项目原理    

1. 加载spring核心配置文件
```txt
   ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
```    
  (1) new对象，功能可以实现，效率很低
  
2. 实现思想，把加载配置文件和创建对象过程，在服务器启动时完成。

3. 实现原理：
   （1）ServletContext对象
   （2）监听器
   （3）具体使用
        - 在服务器启动时，为每个项目创建一个ServletContext对象   
        - 在ServletContext对象创建的时候，使用监听器可以监听到ServletContext对象在什么时候创建
        - 使用监听器监听到ServletContext对象创建时
        - 加载spring配置文件，把配置文件配置对象创建
        - 把创建出来的对象放到ServletContext域对象里面（setAttribute方法）
        - 获得对象时，到ServletContext域得到（getAttribute方法）
    
    
    
##Session Two    
bean2.xml

###Spring的bean管理（注解）
- 注解 （如@Test)
    1. 代码里特殊标记，使用注解可以完成功能
    2. 注解写法@注解名称（属性名称=属性值）
    3. 注解使用在类上面，方法上面和属性上面    
    
- Spring注解准备工作
    导入jar包
    
- xml
```txt
    <!--开启注解扫描-->
    <!--扫描类、方法、属性上面是否有注解-->
    <context:component-scan base-package="com.lessionTwo"/>
    <!--扫描属性上面的注解-->
    <!--<context:annotation-config></context:annotation-config>-->
```        

- 创建对象注解
 （1）@Component(value="user") //等同<bean id="user" class=""/>
 （2）@Controller： WEB层
  (3) @Service： 业务层
  (4) @Repository： 持久层
  **这四个注解功能相同，都创建对象，Component衍生出下面3种**
   
  @Scope(value="singleton"): 单实例还是多实例 
   
###注解注入属性
1. 使用component创建dao及service对象
2. @Autowired： 注入对象，对应上文中的《###注入对象类型属性（重点）》对应。  
3. @Resource(name="userDao"): 与autowired相同，name与对象的component中的value对应


##AOP面向切面编程

###AOP概念
    1. 扩展功能不修改源代码实现
    2. 采用**横向抽取机制**（动态代理），取代纵向继承体系（继承）

###AOP原理
    1. 创建平级的代理对象
    2. 使用Interface的实现类： 创建于Impl实现类平级的对象，不是真正对象，与实现类相同的功能。使用的是jdk动态代理
    3. 没使用Interface的实现类： 创建子类的代理对象，在子类里调用父类的方法完成增强。使用cglib动态代理。

###AOP操作术语
    1. Joinpoint：连接点；类里面哪些方法可以被增强，这些方法称为连接点。
    2. Pointcut: 切入点;被增强的方法称为切入点。
    3. Advice: 增强;增强的功能逻辑。
    4. Aspect: 切面;把增强功能应用到方法时（用到切入点的过程），这个过程称为切面

###Spring的AOP操作
     
    1. 使用aspectj实现
    2. Spring2.0以后新增对AspectJ支持
    3. 实现AOP两种方式
        - 基于Aspectj的xml配置
        - 基于Aspectj的注解方式
        
- AOP准备工作
    1. 导入jar包
    2. 导入AOP约束 ---bean3.xml   
 
- 使用表达式配置切入点
    1. 切入点： 实际被增强的方法
    2. 常用表达式
        execution(<访问修饰符>?<返回类型><方法名>(<参数>)<异常>)      
        （1）execution(* com.lessionTwo.aop.Book.add(..))
            *为public、private、static
            后面是路径: 类中的add方法。 (..)为包含参数
            
         (2) execution(* com.lessionTwo.aop.Book.*(..))   
            类中所有的方法
            
         (3) execution(* *.*(..))
            所有类的所有方法   
            
         (4) execution(* save*(..))
            匹配所有save开头的方法    
            
            
            