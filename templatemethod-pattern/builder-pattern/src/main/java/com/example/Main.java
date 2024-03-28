package com.example;

public class Main {
    public static void main(String[] args) {

//        Product product = new Product("", "", "", "", "", 5, 250.5);
        Product product = new ProductBuilder()
                .create()
                .addVitaminB("B")
                .addVitaminC("C")
                .addVitaminA("A")
                .addVitaminE("E")
                .addVitaminA("CalcA")
                .addName("My Capsule")
                .build();

        System.out.println(product);
    }
}