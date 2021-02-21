package ecer1;

/**
 *  定义一个 Employee 类。
 * 该类包含：private 成员变量 name,age,birthday，其中 birthday 为
 * MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 * @author tianse
 */
public class Employee implements Comparable{

    private String name;
    private int age;
    private MyDate birthay;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthay) {
        this.name = name;
        this.age = age;
        this.birthay = birthay;
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

    public MyDate getBirthay() {
        return birthay;
    }

    public void setBirthay(MyDate birthay) {
        this.birthay = birthay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthay=" + birthay +
                '}';
    }
//按照姓名顺序排
    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee)o;
            return this.name.compareTo(e.name);
        }
        throw new RuntimeException("传入的数据不一致");
    }
}
