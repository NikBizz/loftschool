package com.nbarabanov.loftmoney.cell;

public class Item {
    private String price;
    private String title;

    public Item (String title, String prise) {
        this.title = title;
        this.price = prise;
    }
    public String getTitle() {
        return title; }

    public String getPrice() {
        return price;    }
}
