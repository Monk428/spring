package SessionTwo;

import com.lessionTwo.User;
import com.lessionTwo.UserService;
import com.lessionTwo.aop.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {
    @Test
    public void testUser() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
//        User user = (User)context.getBean("user");
//        user.add();
//
//        UserService userService = (UserService)context.getBean("userService");
//        userService.add();

        ApplicationContext aopContext = new ClassPathXmlApplicationContext("bean3.xml");
        Book book = (Book)aopContext.getBean("book");
        book.add();
    }
}
