package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[10];
    private int productCount = 0;

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    // НОВЫЕ МЕТОДЫ:
    public int countSpecialProducts() {
        int count = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i].isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public void printCartContents() {
        System.out.println("Содержимое корзины:");
        for (int i = 0; i < productCount; i++) {
            System.out.println("  " + products[i].toString());
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + countSpecialProducts());
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
        productCount = 0;
        System.out.println("Корзина очищена");
    }
}