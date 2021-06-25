package design;

import org.junit.Test;

/**
 * 装饰模式
 *
 * @author jkq
 * @descrition 动态地给一个对象增加一些额外的职责(Responsibility)，就增加对象功能来说，装饰模式比生成子类实现更为灵活。
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/decorator.html
 * @createdate 2021.6.25
 * @updatedate 2021.6.25
 */
public class DecoratorPattern {


    /**
     * 抽象构件
     */
    interface Component {
        /**
         * 被包装的操作
         */
        void operation();
    }

    /**
     * 具体构件
     */
    class ConcreteComponent implements Component {

        @Override
        public void operation() {
            System.out.println("This is concreteComponent");
        }
    }

    /**
     * 抽象装饰类
     */
    abstract class Decorator implements Component {
        Component component;

        public Decorator(Component component) {
            this.component = component;
        }


        @Override
        public void operation() {
            //委派给构建
            component.operation();
        }
    }

    /**
     * 具体装饰类
     */
    class ConcreteDecoratorA extends Decorator {

        public ConcreteDecoratorA(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            addBehavior();
            super.operation();

        }

        private void addBehavior() {
            System.out.println("This is A addBehavior");
        }
    }

    /**
     * 具体装饰类
     */
    class ConcreteDecoratorB extends Decorator {

        public ConcreteDecoratorB(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            addBehavior();
            super.operation();
        }

        private void addBehavior() {
            System.out.println("This is B addBehavior");
        }
    }

    /**
     * 使用方法
     */
    @Test
    public void test() {
        Component concreteComponent = new ConcreteComponent();

        Decorator decoratorA = new ConcreteDecoratorA(concreteComponent);
        decoratorA.operation();

        Decorator decoratorB = new ConcreteDecoratorB(concreteComponent);
        decoratorB.operation();

    }
}
