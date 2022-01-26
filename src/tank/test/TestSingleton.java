package tank.test;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-26-20:32
 * @Description: tank.test
 * @version: 1.0
 */
public class TestSingleton {
    //饿汉式 单例
    //从类加载开始就初始化
    //private static final TestSingleton INSTANCE=null;
    //懒汉式 单例
    //内部类不会在类的加载时初始化
    static class INSTANCEHodler{
        private static final TestSingleton INSTANCE=new TestSingleton();
    }
    //将构造器私有化  让人没办法new出来
    private TestSingleton() {
    }
    //获取实例
    public static TestSingleton getINSTANCE() {
        return INSTANCEHodler.INSTANCE;
    }
}
