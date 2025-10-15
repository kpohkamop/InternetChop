package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int cost;

    public SimpleProduct(String name, int cost) {
        super(name);
        if (cost <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0. Передано: " + cost);
        }
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }
}