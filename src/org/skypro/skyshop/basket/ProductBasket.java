package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct; // ✅ Добавляем импорт

import java.util.*;

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
        return Arrays.stream(products, 0, productCount)
                .filter(Objects::nonNull)
                .mapToInt(Product::getCost)
                .sum();
    }

    public void printCartContents() {
        if (productCount == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        Arrays.stream(products, 0, productCount)
                .filter(Objects::nonNull)
                .forEach(product ->
                        System.out.println(product.getName() + ": " + product.getCost()));

        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProduct(String productName) {
        return Arrays.stream(products, 0, productCount)
                .filter(Objects::nonNull)
                .anyMatch(product -> product.getName().equals(productName));
    }

    public void clearBasket() {
        Arrays.fill(products, null);
        productCount = 0;
        System.out.println("Корзина очищена");
    }

    public void demonstrateFlatMap() {
        Map<String, List<Product>> productCategories = new HashMap<>();

        productCategories.put("Фрукты", Arrays.asList(
                new SimpleProduct("Яблоко", 50),  // ✅ Теперь SimpleProduct распознаётся
                new SimpleProduct("Банан", 30)
        ));
        productCategories.put("Овощи", Arrays.asList(
                new SimpleProduct("Морковь", 20),
                new SimpleProduct("Картофель", 40)
        ));

        int totalPrice = productCategories.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getCost)
                .sum();

        System.out.println("Общая стоимость всех категорий: " + totalPrice);
    }
}