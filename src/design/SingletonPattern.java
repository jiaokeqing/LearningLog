package design;

/**
 * 单例模式
 *
 * @author jkq
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html
 * @createdate 2021.6.23
 * @updatedate 2021.6.23
 * @descrition 单例类的构造函数为私有；提供一个自身的静态私有成员变量；提供一个公有的静态工厂方法。
 */
public class SingletonPattern {

}

/**
 * 懒汉式单例模式
 *
 * @description 双重验证锁
 */
class Singleton1 {
    /**
     * 由于instance = new Singleton1()并不是原子操作
     * 分为：1.给 instance 分配内存
     * 2.调用 Singleton 的构造函数来初始化成员变量
     * 3.将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
     * 所以需要加volatile关键字，禁止指令重排序
     */
    private volatile static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getSingleton() {
        if (instance == null) {
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}

/**
 * 饿汉式单例模式
 */
class Singleton2 {
    /**
     * 类加载时就初始化
     */
    private static final Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

/**
 * 懒汉式单例模式
 * 内部类方法实现（推荐）
 *
 * @descrition JVM本身机制保证了线程安全问题；读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本；
 */
class Singleton3 {
    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    private Singleton3() {
    }

    public static final Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/**
 * 枚举方式单例模式
 * 通过EasySingleton.INSTANCE来访问实例
 *
 * @descrition 创建枚举默认就是线程安全的;还能防止反序列化导致重新创建新的对象
 */
enum EasySingleton {
    //单例
    INSTANCE;
}