package design;

import org.junit.Test;

/**
 * 策略模式
 *
 * @author jkq
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/strategy.html
 * @descrition 定义一系列算法，将每一个算法封装起来，并让它们可以相互替换。策略模式让算法独立于使用它的客户而变化，也称为政策模式(Policy)。
 * @createdate 2021.7.12
 * @updatedate 2021.7.12
 */
public class StrategyPattern {
    /**
     * 环境类
     */
    class Context {
        private Strategy strategy;

        void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        void algorithm() {
            strategy.algorithm();
        }
    }

    /**
     * 抽象策略类
     */
    abstract class Strategy {
        void algorithm() {

        }
    }

    /**
     * 具体策略类A
     */
    class ConcreteStrategyA extends Strategy {
        @Override
        void algorithm() {
            System.out.println("算法A");
        }
    }

    /**
     * 具体策略类B
     */
    class ConcreteStrategyB extends Strategy {
        @Override
        void algorithm() {
            System.out.println("算法B");
        }
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        Context context = new Context();
        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();
        context.setStrategy(strategyA);
        context.algorithm();
        context.setStrategy(strategyB);
        context.algorithm();
    }
}