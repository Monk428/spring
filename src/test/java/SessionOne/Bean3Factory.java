package SessionOne;

public class Bean3Factory {
    //    spring管理bean的实例工厂创建
    public Bean2 getBean2() {
        return new Bean2();
    }
}
