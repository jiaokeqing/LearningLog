package design;

import org.junit.Test;

/**
 * 抽象工厂模式
 *
 * @author jkq
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html
 * @createdate 2021.5.22
 * @updatedate 2021.5.22
 */
public class AbstractFactory {
    /**
     * 抽象工厂
     */
    abstract class Factory {
        Product createProductA() {
            return null;
        }

        Product createProductB() {
            return null;
        }
    }

    /**
     * 具体工厂1
     */
    class ConcreteFactory1 extends Factory {
        @Override
        Product createProductA() {
            return new ConcreteProductA1();
        }

        @Override
        Product createProductB() {
            return new ConcreteProductB1();
        }
    }

    /**
     * 具体工厂2
     */
    class ConcreteFactory2 extends Factory {
        @Override
        Product createProductA() {
            return new ConcreteProductA2();
        }

        @Override
        Product createProductB() {
            return new ConcreteProductB2();
        }
    }

    /**
     * 抽象产品
     */
    abstract class Product {
        void use() {

        }
    }

    /**
     * 具体产品A1
     */
    class ConcreteProductA1 extends Product {
        @Override
        void use() {
            System.out.println("I am ConcreteProductA1");
        }
    }

    /**
     * 具体产品A2
     */
    class ConcreteProductA2 extends Product {
        @Override
        void use() {
            System.out.println("I am ConcreteProductA2");
        }
    }

    /**
     * 具体产品B1
     */
    class ConcreteProductB1 extends Product {
        @Override
        void use() {
            System.out.println("I am ConcreteProductB1");
        }
    }

    /**
     * 具体产品B2
     */
    class ConcreteProductB2 extends Product {
        @Override
        void use() {
            System.out.println("I am ConcreteProductB2");
        }
    }

    /**
     * 使用方法
     */
    @Test
    public void test() {
        Factory factory1 = new ConcreteFactory1();
        Product productA1 = factory1.createProductA();
        productA1.use();
        Product productB1 = factory1.createProductB();
        productB1.use();

        Factory factory2 = new ConcreteFactory2();
        Product productA2 = factory2.createProductA();
        productA2.use();
        Product productB2 = factory2.createProductB();
        productB2.use();
    }
}
