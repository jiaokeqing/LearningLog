package design;

import org.junit.Test;

/**
 * 建造者模式
 *
 * @author jkq
 * @descrition 通过设置不同的建造者生产属性不同的产品
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/builder.html
 * @createdate 2021.6.23
 * @updatedate 2021.6.23
 */
public class BuilderPattern {

    /**
     * 指挥者
     */
    class Director {
        Builder builder;

        Procudt construct() {
            builder.init();
            builder.buildAttributeA();
            builder.buildAttributeB();
            builder.buildAttributeC();
            return builder.getResult();
        }

        void setBuilder(Builder builder) {
            this.builder = builder;
        }

    }

    /**
     * 抽象建造者
     */
    abstract class Builder {
        void init() {
        }

        void buildAttributeA() {
        }

        void buildAttributeB() {
        }

        void buildAttributeC() {
        }

        Procudt getResult() {
            return null;
        }
    }

    /**
     * 具体建造者
     */
    class ConcreteBuilder extends Builder {
        Procudt procudt;

        @Override
        void init() {
            procudt = new Procudt();
        }

        @Override
        void buildAttributeA() {
            procudt.setAttributeA("长：15cm");
        }

        @Override
        void buildAttributeB() {
            procudt.setAttributeB("宽：25cm");
        }

        @Override
        void buildAttributeC() {
            procudt.setAttributeC("高：30cm");
        }

        @Override
        Procudt getResult() {
            return procudt;
        }
    }

    /**
     * 产品
     */
    class Procudt {
        String attributeA;
        String attributeB;
        String attributeC;

        public String getAttributeA() {
            return attributeA;
        }

        public void setAttributeA(String attributeA) {
            this.attributeA = attributeA;
        }

        public String getAttributeB() {
            return attributeB;
        }

        public void setAttributeB(String attributeB) {
            this.attributeB = attributeB;
        }

        public String getAttributeC() {
            return attributeC;
        }

        public void setAttributeC(String attributeC) {
            this.attributeC = attributeC;
        }

        public void show() {
            System.out.println("规格为" + attributeA + "," + attributeB + "," + attributeC);
        }
    }

    /**
     * 使用方法
     */
    @Test
    public void test() {
        Director director = new Director();
        director.setBuilder(new ConcreteBuilder());
        Procudt procudt = director.construct();
        procudt.show();
    }
}
