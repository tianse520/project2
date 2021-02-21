package com;

import org.junit.Test;

/**
 *
 * string的使用
 * @author tianse
 */
public class StringTest {


    /*
    string 实例化方式
    1.通过字面量定义
    2.通过new+构造器
     */
    @Test
    public void test2(){

        //通过字面量定义：此时的s1和s2的数据javaEE声明在方法区的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";

        //通过new+构造器：此时的s3和s4保存地址值吗，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false


    }

    /*
    String:字符串，使用一对""引起来表示。
    1.String声明为final的，不可被继承。
    2.string实现了serializable接口：字符串是支持序列化的
            实现了Compare接口：表示string可以比较大小
    3.string内部定义了final char[] value用于存储字符串数据
    4.string：代表不可变得字符序列。简称不可变性
            体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
                 2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值。不能使用原有的value进行赋值
                 3.当调用string的replace（）方法修改字符或字符串时，也需要重新指定内存区域赋值。不能使用原有的value进行赋值

     5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
     6.字符串常量池中是不会存储相同内容的字符串的

     */
    @Test
    public void test1(){
        String s1 = "abc";//字面量
        String s2 = "abc";
      //  s1 = "hello";

        System.out.println(s1 == s2);//比较s1和s2的地址值

        System.out.println(s1);//hello
        System.out.println(s2);//abc


        System.out.println("******");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);

        System.out.println("******");

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);
        System.out.println(s5);


    }

}
