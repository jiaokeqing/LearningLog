package design;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 中介者模式
 *
 * @author jkq
 * @descrition 中介者模式用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/mediator.html
 * @createdate 2021.6.30
 * @updatedate 2021.6.30
 */
public class MediatorPattern {
    /**
     * 抽象中介类
     */
    abstract class Mediator{

        void operation(String colleagueName,String msg){}
        void register(String colleagueName,Colleague colleague){}
    }

    /**
     * 具体中介类
     */
    class ConcreteMediator extends Mediator{
        private Map<String,Colleague> colleagueMap=new HashMap<>();
        @Override
        void operation(String colleagueName,String msg) {
            Colleague colleague=colleagueMap.get(colleagueName);
            if (colleague!=null){
                System.out.println("by Mediator");
                colleague.receiveMsg(msg);
            }
        }

        @Override
        void register(String colleagueName, Colleague colleague) {
            colleagueMap.put(colleagueName,colleague);
        }
    }

    /**
     * 抽象同事类
     */
    abstract class Colleague{
        void receiveMsg(String msg){}
        void sendMsg(String colleagueName,String msg){}
        void setMediator(Mediator mediator){}
    }

    /**
     * 具体同事类
     */
    class ConcreteColleagueA extends Colleague{
        private Mediator mediator;
        @Override
        void sendMsg(String colleagueName,String msg) {
            System.out.println("ColleagueA will send msg："+msg+"  to  "+colleagueName);
            mediator.operation(colleagueName,msg);
        }

        @Override
        void setMediator(Mediator mediator) {
            this.mediator=mediator;
        }

        @Override
        void receiveMsg(String msg) {
            System.out.println("ColleagueA receiver: "+msg);
        }
    }

    /**
     * 具体同事类
     */
    class ConcreteColleagueB extends Colleague{
        private Mediator mediator;
        @Override
        void sendMsg(String colleagueName,String msg) {
            System.out.println("ColleagueB will send msg："+msg+"  to  "+colleagueName);
            mediator.operation(colleagueName,msg);
        }

        @Override
        void setMediator(Mediator mediator) {
            this.mediator=mediator;
        }

        @Override
        void receiveMsg(String msg) {
            System.out.println("ColleagueB receiver: "+msg);
        }
    }

    /**
     * 测试
     */
    @Test
    public void test(){
        Mediator mediator=new ConcreteMediator();
        Colleague colleagueA=new ConcreteColleagueA();
        Colleague colleagueB=new ConcreteColleagueB();
        mediator.register("colleagueA",colleagueA);
        mediator.register("colleagueB",colleagueB);
        colleagueA.setMediator(mediator);
        colleagueB.setMediator(mediator);
        colleagueA.sendMsg("colleagueB","Hello A, I am B");
    }
}
