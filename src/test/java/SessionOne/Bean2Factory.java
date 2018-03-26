package SessionOne;

public class Bean2Factory {

//    spring管理bean的静态工厂创建
    public static Bean2 getBean2() {
        return new Bean2();
    }
}
