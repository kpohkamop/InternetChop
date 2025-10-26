package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Добавлен продукт: " + product.getName() + " (" + product.getCost() + " руб.)");
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            total += product.getCost();
        }
        return total;
    }

    public void printCartContents() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        for (Product product : products) {
            System.out.println(product.getName() + ": " + product.getCost());
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена");
    }

    // Новый метод для удаления продуктов по имени
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }
}