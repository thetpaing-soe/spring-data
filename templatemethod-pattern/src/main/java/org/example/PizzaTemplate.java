package com.example;

public abstract class PizzaTemplate {

    public final void makePizza() {
        prepared();
        bake();
        serve();
    }
    public abstract void prepared();
    public abstract void bake();
    public abstract void serve();
}
