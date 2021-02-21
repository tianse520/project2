package com.atguigu.java1;

/**
 * @author tianse
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

  private String name;
  int age;
  public int id;

  public Person(){}
    @MyAnnotation(value = "abc")
  private Person(String name){
      this.name = name;
  }

   Person(String name, int age){
      this.name = name;
      this.age = age;
   }
    @MyAnnotation
   private String show(String nation){
       System.out.println("我的国际是：" + nation );
       return nation;
   }

   public String display(String interests){
      return interests;
   }



    @Override
    public void info() {
        System.out.println("我说一个人");
    }

    private static  void showdDest() {
        System.out.println("我说一个人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
