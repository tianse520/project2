package com.java;

import org.junit.Test;
import sun.util.resources.LocaleData;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

/**
 * jdk8中日期时间api的测试
 * @author tianse
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date1 = new Date(2020 - 1990,9 - 1,8);
        System.out.println(date1);
    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用
     */
    @Test
    public void test1(){
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localDateTime);
        System.out.println(localTime);

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMinute());

        //提现不可变性
        //withXXX():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate1);
        System.out.println(localDate);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //不可变性
        LocalDateTime localDateTime3  = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);


    }

    /*
    Instant的使用
        类似于java.util.Date类
     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的表示准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2020-10-27T09:42:14.917Z时区不同

        //添加时间变量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-10-27T17:42:14.917

        //获取从1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例Date（long milli）--->Date类的gettime（）方法
        Instant instant1 = Instant.ofEpochMilli(1550475314878L);
        System.out.println(instant1);
    }

        /*
        DateTimeformatter:格式化或解析日期、时间
        类似于SimpleDateFormat
         */
        @Test
    public void test3(){

        // 预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
       //格式化：日期----》字符串
            LocalDateTime localDateTime = LocalDateTime.now();
            String str1 = formatter.format(localDateTime);
            System.out.println(localDateTime);
            System.out.println(str1);
            //解析：字符串---》日期
            TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
            System.out.println(parse);
       // 本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)


       // 自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            //格式化
            String str2 = formatter1.format(LocalDateTime.now());
            System.out.println(str2);

            //解析：
            TemporalAccessor parse1 = formatter1.parse("2019-02-18 03:52:09");
            System.out.println(parse1);


        }
}

