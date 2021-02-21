package com.atgui.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author tianse
 */
public class ReflectionTest {

    //反射以前对person的操作
    @Test
    public void test1(){
        //1.创建person对象
        Person p1 = new Person("Tom",13);
        //2.通过对象调用内部属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在person'类的外部，不可以通过person类的对象调用其内部私有结构
        //比如：name/showNation()以及私有的构造器
    }
    //反射以后对person的操作
    @Test
    public void test2() throws Exception {

        Class cl = Person.class;
        Constructor cons = cl.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 13);
        Person p = (Person) obj;
        System.out.println(p.toString());
        //2.通过反射：调用对象指定的属性和方法
        //调属性
        Field age = cl.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //调方法
        Method show = cl.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("***********************************");

        //通过反射可以调用Person类的私有结构。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1= cl.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有属性
        Field name = cl.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Hanmeimei");
        System.out.println(p1);

        //调用私有方法
        Method showNation = cl.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");//相当于String nation = p1.showNation("z中国")
        System.out.println(p1);
    }

        /*
        关于java.lang.class类的理解
        1.类的加载过程：
        程序经过java.exe命令以后，会生成一个或多个字节码文件(.class）结尾，接着使用
        java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
        过程称为类的加载，加载到内存中的类，我们就称为运行时类，此运行时类，就作为class的一个实例

        2.换句话说，class的实例对应着一个运行时类
        3.加载到内存中的运行时类，会缓存一定时间，在此时间之内，我们可以通过不同的方式
        来获取此运行时类

             */
        //获取Class的实例方式（前三种需要掌握）
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行类时的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.atgui.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true


    }
}
