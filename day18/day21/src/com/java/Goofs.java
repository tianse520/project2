package com.java;

/**
 * 商品类
 * @author tianse
 */
public class Goofs implements Comparable{

    private String name;
    private double price;

    public Goofs() {
    }

    public Goofs(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goofs{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式:按照价格从低到高
    @Override
    public int compareTo(Object o) {
       if(o instanceof Goofs){
           Goofs goofs = (Goofs)o;
           //方式1
           if(this.price > goofs.price){
               return 1;
           }else if(this.price < goofs.price){
               return -1;
           }else{
               return 0;
           }

           //方式2：
//           Double.compare(this.price,goofs.price);
       }
       throw new RuntimeException("传入的数据类型不一致");
    }
}
