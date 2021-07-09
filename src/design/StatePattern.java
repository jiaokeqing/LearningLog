package design;

import org.junit.Test;

/**
 * 状态模式
 *
 * @author jkq
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/state.html
 * @descrition 允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。其别名为状态对象(Objects for States)，状态模式是一种对象行为型模式。
 * @createdate 2021.7.9
 * @updatedate 2021.7.9
 */
public class StatePattern {
    /**
     * 环境类
     */
    class Context {
        private State currentState;

        void changeState(State state) {
            currentState = state;
        }

        void request() {
            System.out.println("This is ContextRequest");
            currentState.handle();
        }
    }

    /**
     * 抽象状态类
     */
    abstract class State {
        void handle() {
        }

        ;
    }

    /**
     * 具体状态类A
     */
    class ConcreteStateA extends State {
        @Override
        void handle() {
            System.out.println("ConcreteStateA is doing");
        }
    }

    /**
     * 具体状态类B
     */
    class ConcreteStateB extends State {
        @Override
        void handle() {
            System.out.println("ConcreteStateB is doing");
        }
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        Context context = new Context();
        State stateA = new ConcreteStateA();
        State stateB = new ConcreteStateB();
        context.changeState(stateA);
        context.request();
        context.changeState(stateB);
        context.request();
    }

}
