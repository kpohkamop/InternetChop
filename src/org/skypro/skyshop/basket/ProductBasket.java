package org.skypro.skyshop.basket;

import org.skypro.skyshop.Product;

public class ProductBasket {
    private Product[] products; // массив для хранения продуктов
    private int count;          // счетчик товаров в корзине

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }


    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }


    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }


    public void printCartContents() {
        if (count == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        for (int i = 0; i < count; i++) {
            Product product = products[i];
            System.out.println(product.getName() + ": " + product.getPrice());
        }
        System.out.println("Итого: " + getTotalPrice());
    }


    public boolean containsProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
    }
}