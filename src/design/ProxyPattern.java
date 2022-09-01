package design;

import org.junit.Test;

/**
 * 代理模式(静态代理)
 *
 * 代理模式和包装模式的不同之处在于：装饰器模式关注于在一个对象上动态的添加方法，然而代理模式关注于控制对对象的访问
 *
 * @author jkq
 * @descrition 代理对象可以在客户端和目标对象之间起到 中介的作用，并且可以通过代理对象去掉客户不能看到 的内容和服务或者添加客户需要的额外服务
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/proxy.html
 * @createdate 2021.6.28
 * @updatedate 2021.6.28
 */
public class ProxyPattern {
    /**
     * 抽象主题角色
     */
    abstract class Subject {
        void request() {
        }
    }

    /**
     * 代理主题角色
     */
    class Proxy extends Subject {
        private RealSubject realSubject;

        public Proxy() {
            realSubject = new RealSubject();
        }

        @Override
        void request() {
            beforeRequest();
            realSubject.request();
            afterRequest();
        }

        private void beforeRequest() {
            System.out.println("This is beforeRequest");
        }

        private void afterRequest() {
            System.out.println("This is afterRequest");
        }
    }

    /**
     * 真实主题角色
     */
    class RealSubject extends Subject {
        @Override
        void request() {
            System.out.println("This is Request");
        }
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        Proxy proxy = new Proxy();
        proxy.request();
    }


}
