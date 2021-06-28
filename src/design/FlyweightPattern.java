package design;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 *
 * @author jkq
 * @descrition 通过共享技术实现相同或相似对象的重用
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/flyweight.html
 * @createdate 2021.6.28
 * @updatedate 2021.6.28
 */
public class FlyweightPattern {


    @Test
    public void test() {
        int exterinsic = 22;
        Flyweight flyweightX = FlyweightFactory.getFlyweight("X");
        flyweightX.operation(++exterinsic);

        Flyweight flyweightY = FlyweightFactory.getFlyweight("Y");
        flyweightY.operation(++exterinsic);

        Flyweight flyweightZ = FlyweightFactory.getFlyweight("Z");
        flyweightZ.operation(++exterinsic);

        Flyweight flyweightReX = FlyweightFactory.getFlyweight("X");
        flyweightReX.operation(++exterinsic);

        Flyweight unsharedFlyweight = new UnsharedConcreteFlyweight("X");
        unsharedFlyweight.operation(++exterinsic);
    }
}

/**
 * 享元工厂类
 */
class FlyweightFactory {
    //pool需要静态修饰
    private static Map<String, Flyweight> pool = new HashMap<>();

    static Flyweight getFlyweight(String key) {
        Flyweight flyweight = null;
        if (pool.containsKey(key)) {
            flyweight = pool.get(key);
            System.out.print("已有 " + key + " 直接从池中取---->");
        } else {
            flyweight = new ConcreteFlyweight(key);
            pool.put(key, flyweight);
            System.out.print("创建 " + key + " 并从池中取出---->");
        }
        return flyweight;
    }

    ;
}

/**
 * 抽象享元类
 */
abstract class Flyweight {
    /**
     * 内部状态
     */
    private String intrinsic;
    /**
     * 外部状态
     */
    protected final String extrinsic;

    protected Flyweight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    void operation(int extrinsic) {
    }

    ;

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}

/**
 * 具体享元类
 */
class ConcreteFlyweight extends Flyweight {

    /**
     * 接收外部状态
     */
    protected ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    /**
     * 根据外部状态就行逻辑处理
     *
     * @param extrinsic
     */
    @Override
    void operation(int extrinsic) {
        System.out.println("具体Flyweight:" + extrinsic);
    }
}

/**
 * 非共享具体享元类
 */
class UnsharedConcreteFlyweight extends Flyweight {
    protected UnsharedConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    void operation(int extrinsic) {
        System.out.println("不共享的具体extrinsic：" + extrinsic);
    }
}
