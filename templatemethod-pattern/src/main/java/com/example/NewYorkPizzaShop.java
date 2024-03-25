package com.example;

public class NewYorkPizzaShop extends PizzaTemplate {
    @Override
    public void prepared() {
        System.out.println(this.getClass().getSimpleName() + "::prepared.");
    }

    @Override
    public void bake() {
        System.out.println(this.getClass().getSimpleName() + "::baked.");
    }

    @Override
    public void serve() {
        System.out.println(this.getClass().getSimpleName() + "::served.");
    }
}
