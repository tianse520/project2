package com.exer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方法三：实现Callable接口。----jdk5新增
 *
 *
 * 如何理解实现callable接口的方法创建多线程比实现Runnable接口创建多线程方式强大？
 * 1.call（）方法可以有返回值的
 * 2.call（）可以抛出异常，被外面的操作补货，获取异常信息
 * 3.Callable是支持泛型的
 * @author tianse
 */
//1.创建一个实现callable的实现类
class NumThread implements Callable {
    //2.实现call方法，将此线程需要执行的方法声明在call（）z中
    @Override
    public Object call() throws  Exception {
        int sum = 0;
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }

        return sum;

    }
}

public class ThreadNew {

    public static void main(String[] args) {

        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();

        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask(numThread);

        //5.将FutureTask的对象作为参数传递到Thread了哦额构造器中，创建Thread对象并调用start（）
        new Thread(futureTask).start();

        try {
            //6.获取Callable中call方法的返回值
            //get（）返回值即为FutureTask构造器参数Callable实现类重写的call（）的返回值
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
