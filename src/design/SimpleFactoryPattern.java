package design;

import org.junit.Test;


/**
 * 简单工厂模式
 * @author jkq
 * @url https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/simple_factory.html
 * @createdate 2021.5.22
 * @updatedate 2021.5.22
 */
public class SimpleFactoryPattern {
    /**
     * 工厂角色
     */
    class Factory{
        Product create(String productName){
            if ("A".equals(productName)){
                return new ConcreteProductA();
            }
            else if ("B".equals(productName)){
                return new ConcreteProductB();
            }
            return null;
        }
    }

    /**
     * 抽象产品角色
     */
   abstract class Product{
        void use() {
        }
    }

    /**
     * 具体产品角色A
     */
    class ConcreteProductA extends Product{
        @Override
        void use(){
            System.out.println("I am ConcreteProductA");
        }
    }

    /**
     * 具体产品角色B
     */
    class ConcreteProductB extends Product{
        @Override
        void use(){
            System.out.println("I am ConcreteProductB");
        }

    }



    /**
     * 使用方法
     */
    @Test
    public void test(){
        Factory factory=new Factory();
        Product productA=factory.create("A");
        productA.use();
        Product productB=factory.create("B");
        productB.use();
    }

    /**
     * 模式应用
     */
    public void example(){
        //1.工具类DateFormat:用于格式化一个本地日期或时间
//        DateFormat dateFormat=DateFormat.getDateInstance();
//        DateFormat dateFormat=DateFormat.getDateInstance(int style)
//        DateFormat dateFormat=DateFormat.getDateInstance(int style,Locale locale)

        //2.密钥生成器:创建密码器
//        KeyGenerator keyGen=KeyGenerator.getInstance("DESede");
//        Cipher cp=Cipher.getInstance("DESede");

    }

}
