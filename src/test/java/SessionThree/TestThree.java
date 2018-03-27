package SessionThree;

import com.lessionThree.Ebook;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestThree {

    @Test
    public void Test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanSeesionThree.xml");
        Ebook ebook = (Ebook) context.getBean("ebook");
        ebook.add();
        ebook.del();
    }
}
