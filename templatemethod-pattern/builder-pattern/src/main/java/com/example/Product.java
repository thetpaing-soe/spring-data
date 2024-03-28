package com.example;

public class Product {

    private String name;
    private String vitaminB;
    private String vitaminA;
    private String vitaminC;
    private String vitaminE;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String name, String vitaminB, String vitaminA, String vitaminC, String vitaminE, int quantity, double price) {
        this.name = name;
        this.vitaminB = vitaminB;
        this.vitaminA = vitaminA;
        this.vitaminC = vitaminC;
        this.vitaminE = vitaminE;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVitaminB() {
        return vitaminB;
    }

    public void setVitaminB(String vitaminB) {
        this.vitaminB = vitaminB;
    }

    public String getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(String vitaminA) {
        this.vitaminA = vitaminA;
    }

    public String getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(String vitaminC) {
        this.vitaminC = vitaminC;
    }

    public String getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(String vitaminE) {
        this.vitaminE = vitaminE;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", vitaminB='" + vitaminB + '\'' +
                ", vitaminA='" + vitaminA + '\'' +
                ", vitaminC='" + vitaminC + '\'' +
                ", vitaminE='" + vitaminE + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
