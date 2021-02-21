package com;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * 涉及到String类与其他结构之间的转换
 * @author tianse
 */
public class StringTest1 {

    /*
    string 与基本数据类型，包装类之间的转换

    string-->基本数据类型、包装类；调用包装类的静态方法;parseXxx(str)
    基本数据类型。包装类-->String:调用String茶农在的valuof（xxx）


     */

    @Test
    public void test(){
        String str1 = "123";
//        int num = (int)str1;  错误
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);//"123"
        String str3 = num + "";

        System.out.println(str1 == str3);//false

    }
    /*
    String 与char[]之间的转换

    String --->char[]:调用String的toCharArray（）
    char[] --> String:调用String的构造器
     */
    @Test
    public void test1(){

        String str1 = "abc123";    //题目： a21cb3

        char[] charArray = str1.toCharArray();

        for(int i = 0;i < charArray.length;i++){
            System.out.println(charArray[i]);
        }
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);

    }

    /*
    String 与byte[]之间的装换
    编码：String -->byte[]:调用string的getBytes()
    解码：byte[] -->String:调用string的构造器

    注意：解码时使用的字符集必须与编码时使用的字符集一致，否则出现乱码
    */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        String str2 = new String(bytes);//使用默认的字符集，进行解码
        System.out.println(str2);

    }

}
