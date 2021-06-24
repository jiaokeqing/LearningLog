package design;

import org.junit.Test;

/**
 * 桥接模式模式
 *
 * @author jkq
 * @descrition 将抽象部分和实现部分分离，使他们可以独立变化
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/bridge.html
 * @createdate 2021.6.24
 * @updatedate 2021.6.24
 */
public class BridgePattern {


    /////////////////////////////////////////////////////////
    //  以下面为例，
    //  如果需要加一辆车，只需添加一个扩充抽象类，便能应用所有颜色
    //  如果需要加一种颜色，只需添加一个具体实现类，便能应用到所有车
    //  因为使用桥接模式，将抽象部分和实现部分分离，使他们可以独立变化
    //  这样大大降低了类与类之间的耦合，减少了代码编写量
    ////////////////////////////////////////////////////////

    /**
     * 抽象类
     *
     * @Example 车
     */
    abstract class Abstraction {
        Implementor implementor;

        void operation() {
        }

        Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }
    }

    /**
     * 实现类接口
     *
     * @Example 颜色
     */
    interface Implementor {
        void operationImpl();
    }

    /**
     * 扩充抽象类
     *
     * @Example 大众车
     */
    class RefinedAbstraction extends Abstraction {
        RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }

        @Override
        void operation() {
            System.out.println("This is RefinedAbstraction");
            this.implementor.operationImpl();
        }
    }

    /**
     * 扩充抽象类
     *
     * @Example 红旗车
     */
    class RefinedAbstraction2 extends Abstraction {
        RefinedAbstraction2(Implementor implementor) {
            super(implementor);
        }

        @Override
        void operation() {
            System.out.println("This is RefinedAbstraction2");
            this.implementor.operationImpl();
        }
    }

    /**
     * 具体实现类
     *
     * @Example 红色
     */
    class ConcreteImplementA implements Implementor {

        @Override
        public void operationImpl() {
            System.out.println("This is ConcreteImplementA");
        }
    }

    /**
     * 具体实现类
     *
     * @Example 黑色
     */
    class ConcreteImplementB implements Implementor {

        @Override
        public void operationImpl() {
            System.out.println("This is ConcreteImplementB");
        }
    }

    /**
     * 使用方法
     */
    @Test
    public void test() {
        Implementor implementA = new ConcreteImplementA();
        Abstraction abstraction1 = new RefinedAbstraction(implementA);
        abstraction1.operation();

        Implementor implementorB = new ConcreteImplementB();
        Abstraction abstraction2 = new RefinedAbstraction(implementorB);
        abstraction2.operation();

        Abstraction abstraction3 = new RefinedAbstraction2(implementA);
        abstraction3.operation();
        Abstraction abstraction4 = new RefinedAbstraction2(implementorB);
        abstraction3.operation();


    }


}
