package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int baseCost;
    private final int discountPercent;

    public DiscountedProduct(String name, int baseCost, int discountPercent) {
        super(name);

        if (baseCost <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0. Передано: " + baseCost);
        }

        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно. Передано: " + discountPercent);
        }

        this.baseCost = baseCost;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getCost() {
        return baseCost - (baseCost * discountPercent / 100);
    }

    public int getBaseCost() {
        return baseCost;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}