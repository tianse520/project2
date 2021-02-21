package com.atguigu.java;

/**
 * 静态代理举例
 *
 * 特点：代理类和被代理类在编译期间就确定下来了
 * @author tianse
 */
interface ClothFactory{

    void produceCloth();

}
//代理类
class ProxyClothFactory implements ClothFactory{

   private ClothFactory factory;//就拿被代理类对象进行实例化

   public ProxyClothFactory(ClothFactory factory){
       this.factory = factory;
   }//先造一个代理类的对象，在提供构造器


    @Override
    public void produceCloth() {

        System.out.println("代理动车做准备工作");

        factory.produceCloth();

        System.out.println("代理动车做收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产衣服");
    }
}
public class StaticProxyTest {

    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();

    }
}
