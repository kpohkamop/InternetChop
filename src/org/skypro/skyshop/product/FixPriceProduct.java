package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 10;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getCost() {
        return FIXED_PRICE;
    }
}
