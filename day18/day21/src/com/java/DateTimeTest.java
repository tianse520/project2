package com.java;

import org.junit.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk8之前的日期时间api测试
 * 1.system类中currentTimeMillis（）；
 * 2.java.util.Date和子类的java.sql.Date
 * 3.SimpleDateFormat
 * 4.calendar
 * @author tianse
 */
public class DateTimeTest {
    /*
    SimpleDateFormat使用方法：对日期Date类的格式化和解析
    1.两个操作
    1.1格式化：日期--->字符串
    1.2解析：格式化的逆过程：字符串---》日期

    2.SimpleFormat的实例化
     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormt:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期--->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程：字符串---》日期
        String str = "20-10-27 下午3:29";
        Date date1 = sdf.parse(str);
        System.out.println(date1);


        //*********************按照指定方式格式化和解析：调用带参的构造器***********************
       // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.mmmmm.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);//2020-02-18 11:48:27

        //解析:要求字符串必须是符合SimpleDateFormat的识别格式
        //否则抛异常
        Date date2 = sdf1.parse("2020-02-18 11:48:27");
        System.out.println(date2);


    }

    /*
    练习一：字符串：2020-09-08转换为java.sql.Date
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MMMM-dd");
        Date date = sdf1.parse(birth);
//        System.out.println(date);
        java.sql.Date birthday = new java.sql.Date(date.getTime());
        System.out.println(birthday);
    }

    /*
    Calendar日历类（抽象类—）的使用
     */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式1.创建其子类（GregorianCalendar)的对象
        //方式2.调用其静态方法getInstance
        Calendar calendar = Calendar.getInstance();

        //常用方法
        //get():获取常用的属性信息
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set():
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类—————>Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date---->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

}
