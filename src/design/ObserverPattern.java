package design;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *
 * @author jkq
 * @descrition 当一个对象的行为发生改变可能会导致一个或者多个其他对象的行为也发生改变。所有这些，如果用观察者模式来实现
 * @url http://c.biancheng.net/view/1390.html
 * @createdate 2021.7.6
 * @updatedate 2021.7.6
 */
public class ObserverPattern {
    /**
     * 抽象目标
     */
    abstract class Subject{
        List<Observer> observers=new ArrayList<>();
        void add(Observer observer){
            observers.add(observer);
        }
        void remove(Observer observer){
            observers.remove(observer);
        }
        void notifyObserver(){}
    }

    /**
     * 抽象观察者
     */
    abstract class Observer{
        void response(){}
    }

    /**
     * 具体目标
     */
    class ConcreteSubject extends Subject{
        @Override
        void notifyObserver() {
            System.out.println("具体目标发生改变...");
            System.out.println("------------------");
            for (Observer observer:observers) {
                observer.response();
            }
        }
    }

    /**
     * 具体观察者1
     */
    class ConcreteObserver1 extends Observer{
        @Override
        void response() {
            System.out.println("ConcreteObserver1 response");
        }
    }

    /**
     * 具体观察者2
     */
    class ConcreteObserver2 extends Observer{
        @Override
        void response() {
            System.out.println("ConcreteObserver2 response");
        }
    }

    @Test
    public void test(){
        Subject subject=new ConcreteSubject();
        Observer observer1=new ConcreteObserver1();
        Observer observer2=new ConcreteObserver2();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObserver();
    }
}
