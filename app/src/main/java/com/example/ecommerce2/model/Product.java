package com.example.ecommerce2.model;

public class Product {
    public String title;
    public String imageName;
    public String price;
    public String description;

    public Product(String title, String imageName, String price, String description) {
        this.title = title;
        this.imageName = imageName;
        this.price = price;
        this.description = description;
    }
}
