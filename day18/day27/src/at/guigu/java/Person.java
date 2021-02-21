package at.guigu.java;

import java.io.Serializable;

/**
 * Person类需要满足如下要求才可序列化：
 *1.需要实现接口：Serializable
 *2.需要当前类提供一个常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口外，还必须保证其内部属性
 * 也是刻序列化的。（默认情况下，你本数据类型可序列化的）
 *
 * 4.序列化机制：
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从
 * 而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传
 * 输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原
 * 来的Java对象
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修
 * 饰的成员变量
 *
 * @author tianse
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 4521346242L;
    private  String name;
    private  int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
