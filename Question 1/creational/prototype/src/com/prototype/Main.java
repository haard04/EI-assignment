package com.prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        shop s1= new shop();
        s1.setShopName("ShopHere");
        s1.loadData();


        shop s2= (shop) s1.clone();
        s1.getProductList().remove(2);
        s2.setShopName("Shop2");
        System.out.println(s1);
        System.out.println(s2);
    }
}