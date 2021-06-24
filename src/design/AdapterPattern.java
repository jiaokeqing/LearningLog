package design;

import org.junit.Test;

/**
 * 适配器模式
 *
 * @author jkq
 * @descrition 分为类适配器和对象适配器（适配器本质上就是对源方法的再一层封装）
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/adapter.html
 * @createdate 2021.6.24
 * @updatedate 2021.6.24
 */
public class AdapterPattern {


    //////////////////////////////////////
    //类适配器模式
    //通过类的继承来实现适配
    /////////////////////////////////////

    /**
     * 目标角色
     *
     * @descrition 期待得到的接口
     */
    interface Target {
        /**
         * 源类adaptee没有的方法
         */
        void request();
    }

    /**
     * 源角色
     *
     * @descrition 需要适配的接口
     */
    class Adaptee {
        void specificRequest() {
            System.out.println("This is specificRequest");
        }
    }

    /**
     * 适配器角色
     *
     * @descrition 将源角色接口转化为目标角色接口
     */
    class Adapter extends Adaptee implements Target {

        @Override
        public void request() {
            specificRequest();
        }
    }


    //////////////////////////////////////
    //对象适配器模式
    //通过对象之间的关联关系组合关系来进行适配
    /////////////////////////////////////

    /**
     * 目标角色
     *
     * @descrition 期待的到的接口
     */
    interface Tagret2 {
        /**
         * 源类adaptee中没有的方法
         */
        void request();
    }

    /**
     * 源角色
     *
     * @descrition 需要适配的接口
     */
    class Adaptee2 {
        void specificRequest() {
            System.out.println("This is specificRequest");
        }
    }

    /**
     * 适配器角色
     *
     * @descrition 将源角色的接口转化为目标角色的接口
     */
    class Adapter2 implements Tagret2 {
        private Adaptee2 adaptee2;

        Adapter2(Adaptee2 adaptee2) {
            this.adaptee2 = adaptee2;
        }

        @Override
        public void request() {
            adaptee2.specificRequest();
        }
    }


    /**
     * 使用方法
     */
    @Test
    public void test() {
        //类适配器测试
        Target mAdapter = new Adapter();
        mAdapter.request();

        //对象适配器测试
        Tagret2 mAdapter2 = new Adapter2(new Adaptee2());
        mAdapter2.request();
    }

}
