package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        String productName = product.getName();

        productsMap.computeIfAbsent(productName, k -> new ArrayList<>());

        productsMap.get(productName).add(product);
        System.out.println("Добавлен продукт: " + product.getName() + " (" + product.getCost() + " руб.)");
    }

    public int getTotalPrice() {
        int total = 0;

        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                total += product.getCost();
            }
        }
        return total;
    }

    public void printCartContents() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }


        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                System.out.println(product.getName() + ": " + product.getCost());
            }
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProduct(String productName) {
        return productsMap.containsKey(productName) && !productsMap.get(productName).isEmpty();
    }

    public void clearBasket() {
        productsMap.clear();
        System.out.println("Корзина очищена");
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();

        List<Product> products = productsMap.remove(name);
        if (products != null) {
            removedProducts.addAll(products);
        }

        return removedProducts;
    }
}