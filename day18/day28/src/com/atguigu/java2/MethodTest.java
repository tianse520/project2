package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 * @author tianse
 */
public class MethodTest {

    @Test
    public void test2(){
        Class clazz = Person.class;

        //getMethods():获取当前运行时类及其所有父类声明的所有为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println();

        //getDeclaredMethods()获取当前运行时类中声明的所有方法，不包含父类声明的属性
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
        }
    }
/*
权限修饰符  返回值类型 方法名（参数类型1 形参名1，。。。。）throw XxxException{}
 */
    @Test
    public void test3(){

        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            //1.获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for(Annotation ann : annotations){
                System.out.println(ann);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            System.out.println();

            //3.返回值类型
            System.out.println(m.getReturnType().getName() + "\t");
            System.out.println();
            //4.方法名
            System.out.println(m.getName());
            System.out.println("(");
            //5.形参
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
               for (int i = 0;i<parameterTypes.length;i++){
                   System.out.println(parameterTypes[i].getName() + "args_" + i);
               }

            }
            System.out.println(")");
            System.out.println();
        }




    }
}
