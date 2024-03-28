package com.example;

public class ProductBuilder {

    private Product product;

    public ProductBuilder create() {
        product = new Product();
        return this;
    }

    public ProductBuilder addVitaminA(String vitaminA) {
        product.setVitaminA(vitaminA);
        return this;
    }

    public ProductBuilder addVitaminB(String vitaminB) {
        product.setVitaminB(vitaminB);
        return this;
    }

    public ProductBuilder addVitaminC(String vitaminC) {
        product.setVitaminC(vitaminC);
        return this;
    }

    public ProductBuilder addVitaminE(String vitaminE) {
        product.setVitaminE(vitaminE);
        return this;
    }

    public ProductBuilder addName(String name) {
        product.setName(name);
        return this;
    }

    public ProductBuilder addQuantity(int quantity) {
        product.setQuantity(quantity);
        return this;
    }

    public ProductBuilder addPrice(double price) {
        product.setPrice(price);
        return this;
    }

    public Product build() {
        return product;
    }
}
