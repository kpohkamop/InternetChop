package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private static final int BASKET_SIZE = 5;
    private final Product[] products;
    private int productCount;

    public ProductBasket() {
        this.products = new Product[BASKET_SIZE];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < BASKET_SIZE) {
            products[productCount] = product;
            productCount++;
            System.out.println("Добавлен продукт: " + product.getName() + " (" + product.getCost() + " руб.)");
        } else {
            System.out.println("Невозможно добавить продукт \"" + product.getName() + "\" - корзина заполнена");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getCost();
        }
        return total;
    }

    public void printCartContents() {
        if (productCount == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        for (int i = 0; i < productCount; i++) {
            Product product = products[i];
            System.out.println(product.getName() + ": " + product.getCost());
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < BASKET_SIZE; i++) {
            products[i] = null;
        }
        productCount = 0;
        System.out.println("Корзина очищена");
    }
}
