package design;

import org.junit.Test;

/**
 * 工厂方法模式
 *
 * @author jkq
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html
 * @createdate 2021.6.22
 * @updatedate 2021.6.22
 */
public class FactoryMethodPattern {
    /**
     * 抽象产品
     */
    abstract class Product {
        void use() {

        }
    }

    /**
     * 抽象工厂
     */
    abstract class Factory {
        Product factoryMethod() {
            return null;
        }
    }

    /**
     * 具体产品A
     */
    class ConcreteProductA extends Product {
        @Override
        void use() {
            System.out.println("I am ConcreteProductA");
        }
    }

    /**
     * 具体产品B
     */
    class ConcreteProductB extends Product {
        @Override
        void use() {
            System.out.println("I am ConcreteProductB");
        }
    }

    /**
     * 具体工厂A
     */
    class ConcreteFactoryA extends Factory {
        @Override
        Product factoryMethod() {
            return new ConcreteProductA();
        }
    }

    /**
     * 具体工厂B
     */
    class ConcreteFactoryB extends Factory {
        @Override
        Product factoryMethod() {
            return new ConcreteProductB();
        }
    }

    /**
     * 使用方法
     */
    @Test
    public void test() {
        Factory factoryA = new ConcreteFactoryA();
        Product productA = factoryA.factoryMethod();
        productA.use();
        Factory factoryB = new ConcreteFactoryB();
        Product productB = factoryB.factoryMethod();
        productB.use();
    }

}
