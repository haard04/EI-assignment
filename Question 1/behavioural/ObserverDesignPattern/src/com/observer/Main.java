package com.observer;

public class Main {
    public static void main(String[] args) {

        Product product1= new Product();
        Buyer b1= new Buyer("Buyer 1");
        Buyer b2= new Buyer("Buyer 2");
        Buyer b3= new Buyer("Buyer 3");
        Buyer b4= new Buyer("Buyer 4");
        product1.Purchase(b1);
        product1.Purchase(b2);
        product1.Purchase(b3);
        product1.Purchase(b4);
        b1.BecomeBuyer(product1);
        b2.BecomeBuyer(product1);
        b3.BecomeBuyer(product1);
        b4.BecomeBuyer(product1);
        product1.upload("Learn C++");
    }
}