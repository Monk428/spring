package SessionOne;

import com.lessionOne.User;
import com.lessionOne.ioc.UserService;
import com.lessionOne.nameSpace.Person;
import com.lessionOne.property.PropertyDemo1;
import com.lessionOne.property.PropertySet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class SessionOne {

    @Test
    public void testUser() {
//        1加载spring配置文件，根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
//        2得到配置创建的对象
        User user = (User)context.getBean("user");
        System.out.println(user);
        user.add();
//        scope默认为单实例，所以此时user == user2
        User user2 = (User)context.getBean("user");
        System.out.println(user2);

//      有参构造
        PropertyDemo1 demo1 = (PropertyDemo1)context.getBean("demo");
        demo1.test1();

//      set属性
        PropertySet set1 = (PropertySet)context.getBean("propertySet");
        set1.demobook();

//        配置创建对象
        UserService userService = (UserService)context.getBean("userService");
        userService.add();

//        命名空间
        Person person = (Person)context.getBean("person");
        person.test1();

    }
}
