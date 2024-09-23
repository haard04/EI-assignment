package com.observer;
public class Buyer {
    private String name;
    private Product product= new Product();
    public Buyer(String name) {
        this.name= name;
    }
    public void update() {
        System.out.println("Hey "+ name+ " Product arrived");
    }
    public void BecomeBuyer(Product pr) {
        product= pr; }
}
