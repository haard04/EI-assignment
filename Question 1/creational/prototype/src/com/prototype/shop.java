package com.prototype;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class shop implements Cloneable{
    private String shopName;
     List<products> productsList= new ArrayList<>();
    public String getShopName() {
        return shopName;
    }
    public void setShopName(String shopName) {
        this.shopName= shopName;
    }
    public  List<products> getProductList() {
        return productsList;
    }
    public void setProductsList(List<products> productsList) {
        this.productsList= productsList;
    }

    public void loadData(){
        for(int i=1; i<=5; i++){
            products p= new products();
            p.setId(i);
            p.setName("Product "+i);
            getProductList().add(p);
        }
    }
    @Override
    public String toString() {
        return "Shop [shopName="+ shopName+ ", Products="+ productsList+ "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        shop shopx= new shop();
        for(products p: this.getProductList()) {
            shopx.getProductList().add(p);
        }return shopx;
    }
}


