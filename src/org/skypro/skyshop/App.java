package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.article.Article;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        // Создаем товары
        SimpleProduct banana = new SimpleProduct("Банан", 20);
        SimpleProduct pear = new SimpleProduct("Груша", 30);
        DiscountedProduct apple = new DiscountedProduct("Яблоко", 50, 20);
        FixPriceProduct melon = new FixPriceProduct("Дыня");

        Article article1 = new Article(
                "Польза бананов для здоровья",
                "Бананы богаты калием..."
        );

        Article article2 = new Article(
                "Рецепты из яблок",
                "Яблоки можно использовать для приготовления..."
        );

        System.out.println("=== ТЕСТИРОВАНИЕ STREAM API В SEARCH ENGINE ===");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(banana);
        searchEngine.add(pear);
        searchEngine.add(apple);
        searchEngine.add(melon);
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println("\n1. Поиск 'банан':");
        Set<Searchable> results = searchEngine.search("банан");
        printSearchResults(results);

        System.out.println("2. Поиск 'яблок':");
        Set<Searchable> appleResults = searchEngine.search("яблок");
        printSearchResults(appleResults);

        System.out.println("=== ТЕСТИРОВАНИЕ STREAM API В PRODUCT BASKET ===");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(banana);
        basket.addProduct(pear);
        basket.addProduct(apple);
        basket.addProduct(melon);

        System.out.println("\nСодержимое корзины:");
        basket.printCartContents();

        System.out.println("\nОбщая стоимость (Stream API): " + basket.getTotalPrice() + " руб.");
        System.out.println("Есть ли 'Банан' в корзине: " + basket.containsProduct("Банан"));
        System.out.println("Есть ли 'Ананас' в корзине: " + basket.containsProduct("Ананас"));

        System.out.println("\n=== ДЕМОНСТРАЦИЯ FLATMAP ===");
        basket.demonstrateFlatMap();
    }

    private static void printSearchResults(Set<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Найдено " + results.size() + " результатов:");
            results.forEach(result ->
                    System.out.println("  - " + result.getStringRepresentation()));
        }
    }
}