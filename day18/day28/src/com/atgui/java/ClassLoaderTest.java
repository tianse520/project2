package com.atgui.java;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 * @author tianse
 */
public class ClassLoaderTest {

    @Test
    public void test1(){

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);



    }
/*
Properties:用来读取配置文件
 */
    @Test
    public void test2() throws Exception {

        Properties pros = new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件的方式1
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //方式2:使用classloader
        //此时的文件默认在当前的module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);

    }
}
