package com.observer;

import java.util.ArrayList;
import java.util.List;

public class Product {
    List<Buyer> buyers = new ArrayList<>();
    private String title;
    public void Purchase(Buyer buyer) {
        buyers.add(buyer);
    }
    public void Return(Buyer buyer) {
        buyers.remove(buyer);
    }
    public void notifyBuyer() {
        for(Buyer buyer:buyers){
            buyer.update();
        }
    }
    public void upload(String title){
        this.title = title;
        notifyBuyer();
    }
}
