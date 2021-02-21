package com.at.java;

/**
 * @author tianse
 * 多线程的创建，方式一：继承thread类
 * 1.创建一个继承于thread类的子类
 * 2.重写thread类的run（）--->将此线程执行的操作声明在run中
 * 3创建thread类子类的对象
 * 4通过此对象调用start（）
 *
 * 例子：遍历100一类的偶数
 */

//1.创建一个继承于thread类的子类

    class MyThread extends Thread{

        //2.重写thread类的run()
    @Override
    public void run() {

        for (int i = 0;i<100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}

public class thread {

    public static void main(String[] args) {
        //3.创建thread类子类的对象
        MyThread t1 = new MyThread();

        //4通过此对象调用start（）:①启动当前线程②调用当前线程的run()
                t1.start();//多线程
        //问题一：我们不能通过直接调用run（）的方式调用线程
               // t1.run();//不会报错，只是调用方法，不是多线程

         //问题二：在启动一个线程，遍历100以内的偶数,不可以还让已经start（）的线程去执行。会报IllegalThread
//                t1.start();
        //我们需要重新创建一个线程对象
        MyThread t2 = new MyThread();

        t2.start();

        //如下操作仍然是在main线程中执行的
        for (int i = 0;i<100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "***********");
            }
        }
    }
}
