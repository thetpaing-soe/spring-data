package com.example;

public class ChicagoPizzaShop extends PizzaTemplate {
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
