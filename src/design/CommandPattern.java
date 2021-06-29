package design;

import org.junit.Test;

/**
 * 命令模式
 *
 * @author jkq
 * @descrition 命令模式把一个请求或者操作封装到一个对象中。命令模式允许系统使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/command.html
 * @createdate 2021.6.29
 * @updatedate 2021.6.29
 */
public class CommandPattern {
    /**
     * 接收者
     */
    class Receiver {
        /**
         * 真正执行命令相应的操作
         */
        void action() {
            System.out.println("执行操作");
        }
    }

    /**
     * 抽象命令类
     */
    abstract class Command {
        void execute() {
        }
    }

    /**
     * 具体命令类
     */
    class ConcreteCommand extends Command {
        private Receiver receiver;

        public ConcreteCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        void execute() {
            receiver.action();
        }
    }

    /**
     * 调用者
     */
    class Invoker {
        private Command command = null;

        public Invoker(Command command) {
            this.command = command;
        }

        void action() {
            command.execute();
        }
    }

    /**
     * 客户端测试
     */
    @Test
    public void test() {
        //创建接收对象
        Receiver receiver = new Receiver();
        //创建命令对象，设置它的接收者
        Command command = new ConcreteCommand(receiver);
        //创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(command);
        //执行方法
        invoker.action();
    }
}
