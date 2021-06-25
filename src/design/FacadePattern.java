package design;

import org.junit.Test;

/**
 * 外观模式
 *
 * @author jkq
 * @descrition 外部与一个子系统的通信必须通过一个统一的外观对象进行，为子系统中的一组接口提供一个一致的界面，外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/facade.html
 * @createdate 2021.6.25
 * @updatedate 2021.6.25
 */
public class FacadePattern {

    /**
     * 外观角色
     */
    class Facade {
        private SystemA systemA;
        private SystemB systemB;
        private SystemC systemC;

        public Facade() {
            this.systemA = new SystemA();
            this.systemB = new SystemB();
            this.systemC = new SystemC();
        }

        public void wrapOperation() {
            systemA.operationA();
            systemB.operationB();
            systemC.operationC();
        }
    }

    /**
     * 子系统角色
     */
    class SystemA {
        void operationA() {
            System.out.println("This is operationA");
        }
    }

    /**
     * 子系统角色
     */
    class SystemB {
        void operationB() {
            System.out.println("This is operationB");
        }
    }

    /**
     * 子系统角色
     */
    class SystemC {
        void operationC() {
            System.out.println("This is operationC");
        }
    }

    /**
     * 使用方法
     */
    @Test
    public void test() {
        Facade facade = new Facade();
        facade.wrapOperation();
    }
}
