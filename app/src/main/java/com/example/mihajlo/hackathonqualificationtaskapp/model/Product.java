package com.example.mihajlo.hackathonqualificationtaskapp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mihajlo on 23-May-17.
 */

public class Product extends BaseModel implements Serializable {

    private String title;

    private String description;

    private double price;

    private Date timestamp;

    public Product(){

    }

    public Product(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.timestamp = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}
