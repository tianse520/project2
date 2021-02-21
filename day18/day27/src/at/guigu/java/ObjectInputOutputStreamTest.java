package at.guigu.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 对象流的使用
 *
 * 1.ObjectInputStream 和 ObjectOutputStream(字节流)
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来
 *
 * 3.要想一个java对象时刻序列化的，需要满足相应的要求。键Person.java
 *
 *
 * @author tianse
 */
public class ObjectInputOutputStreamTest {

    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObejctOutputStream(){
        ObjectOutputStream oos = null;

        try {
            //造文件
            oos = new ObjectOutputStream(new FileOutputStream("objct.dat"));
            //2.造流
            oos.writeObject(new String("我爱北京"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("王铭",23));
            oos.flush();//刷新操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
/*
反序列化：将磁盘文件中额对象还原为内存中的一个java对象
使用ObjectInputStream实现
 */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("objct.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

           Person p = (Person) ois.readObject();
            System.out.println(str);
            System.out.println(p);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
