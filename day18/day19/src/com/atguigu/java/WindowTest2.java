package com.atguigu.java;

import javax.jws.Oneway;

/**
 * @author tianse
 * 例子：创建三个窗口卖票，总票数为100张、使用继承Thread类的方式
 *
 * 存在线程安全问题，待解决
 *
 * 使用同步代码块解决继承Thread类的方式得线程安全问题
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 */

class Window2 extends Thread{

    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {

        while(true){

            synchronized(obj) {
             //   synchronized(this) { 不能用this，对象有多个，错误
//                synchronized(Window2.class) {  可以用当前类来当对象，也正确
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}

public class WindowTest2 {

    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
