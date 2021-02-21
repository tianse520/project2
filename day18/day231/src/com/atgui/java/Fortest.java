package com.atgui.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk5.0新增foreach循环，用于遍历数组、集合
 * @author tianse
 */
public class Fortest {

    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素类型 局部变量 ：集合对象)
        //内部仍然调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test1(){
        int[] arr = new int[]{1,2,3,4,5,6};
     //for(数组元素的类型 局部变量 : 数组对象）
        for(int i : arr){
            System.out.println(arr[i]);
        }
    }

    //练习题：
    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","MM"};

        //方式一：普通for循环
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for(String s : arr){
            s = "GG";
            
        }
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
