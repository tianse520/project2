package com.atgui.java1;

/**
 * @author tianse
 *
 * 演示线程死锁问题
 *
 * 1.死锁的理解：不同的线程分被占用对方需要的同步资源不放弃
 *      都在等对方放弃自己需要的同步资源，就形成了死锁
 *
 * 2.说明：
 * ①出现死锁后，不会出现异常，不会出现提示，只是所有的线程度处于阻塞状态，无法继续
 * ②我们使用同步时，要避免出现死锁
 */
public class ThreadTest {

    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {

                synchronized(s1){   //同步监视器
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized(s2){ //同步监视器

                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }

                }
            }
        }.start();

        new Thread(new Runnable() { //接口实现类对象
            @Override
            public void run() {

                synchronized(s2){   //同步监视器
                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized(s1){ //同步监视器

                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }

                }
            }
        }).start();
    }
}
