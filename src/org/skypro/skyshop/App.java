package org.skypro.skyshop;

import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.article.Article;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Создаем товары
        SimpleProduct banana = new SimpleProduct("Банан", 20);
        SimpleProduct pear = new SimpleProduct("Груша", 30);
        DiscountedProduct apple = new DiscountedProduct("Яблоко", 50, 20);
        FixPriceProduct melon = new FixPriceProduct("Дыня");
        DiscountedProduct watermelon = new DiscountedProduct("Арбуз", 100, 30);
        SimpleProduct pumpkin = new SimpleProduct("Тыква", 40);
        SimpleProduct appleJuice = new SimpleProduct("Яблочный сок", 80);
        SimpleProduct bananaMilkShake = new SimpleProduct("Банановый молочный коктейль", 120);

        // Создаем статьи
        Article article1 = new Article(
                "Польза бананов для здоровья",
                "Бананы богаты калием и другими полезными микроэлементами. " +
                        "Регулярное употребление бананов помогает улучшить пищеварение."
        );

        Article article2 = new Article(
                "Как выбрать спелый арбуз",
                "При выборе арбуза обратите внимание на цвет корки и звук при постукивании. " +
                        "Спелый арбуз должен иметь яркую полосатую окраску."
        );

        Article article3 = new Article(
                "Рецепты из яблок",
                "Яблоки можно использовать для приготовления пирогов, компотов и соков. " +
                        "Яблочный пирог - классический десерт для всей семьи."
        );

        Article article4 = new Article(
                "Экзотические фрукты и овощи",
                "В нашем магазине появились новые экзотические фрукты и овощи. " +
                        "Попробуйте манго, папайю и другие тропические фрукты."
        );

        Article article5 = new Article(
                "Сезонные овощи осенью",
                "Осенью особенно полезны тыква, кабачки и другие сезонные овощи. " +
                        "Из тыквы можно приготовить суп-пюре или запечь в духовке."
        );

        // Создаем поисковый движок с достаточной вместимостью
        SearchEngine searchEngine = new SearchEngine(20);

        // Добавляем все товары в поисковый движок
        searchEngine.add(banana);
        searchEngine.add(pear);
        searchEngine.add(apple);
        searchEngine.add(melon);
        searchEngine.add(watermelon);
        searchEngine.add(pumpkin);
        searchEngine.add(appleJuice);
        searchEngine.add(bananaMilkShake);

        // Добавляем все статьи в поисковый движок
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);

        System.out.println("=== ДЕМОНСТРАЦИЯ ПОИСКОВОГО ДВИЖКА ===\n");
        System.out.println("В поисковом движке: " + searchEngine.getSize() + " объектов\n");

        // Демонстрация поиска с разными строками
        System.out.println("1. Поиск по запросу 'банан':");
        Searchable[] bananaResults = searchEngine.search("банан");
        printSearchResults(bananaResults);

        System.out.println("2. Поиск по запросу 'яблок':");
        Searchable[] appleResults = searchEngine.search("яблок");
        printSearchResults(appleResults);

        System.out.println("3. Поиск по запросу 'арбуз':");
        Searchable[] watermelonResults = searchEngine.search("арбуз");
        printSearchResults(watermelonResults);

        System.out.println("4. Поиск по запросу 'фрукт':");
        Searchable[] fruitResults = searchEngine.search("фрукт");
        printSearchResults(fruitResults);

        System.out.println("5. Поиск по запросу 'овощ':");
        Searchable[] vegetableResults = searchEngine.search("овощ");
        printSearchResults(vegetableResults);

        System.out.println("6. Поиск по запросу 'польза':");
        Searchable[] healthResults = searchEngine.search("польза");
        printSearchResults(healthResults);

        System.out.println("7. Поиск по запросу 'рецепт':");
        Searchable[] recipeResults = searchEngine.search("рецепт");
        printSearchResults(recipeResults);

        System.out.println("8. Поиск по запросу 'экзотич':");
        Searchable[] exoticResults = searchEngine.search("экзотич");
        printSearchResults(exoticResults);

        System.out.println("9. Поиск по запросу 'манго' (не существует):");
        Searchable[] mangoResults = searchEngine.search("манго");
        printSearchResults(mangoResults);

        System.out.println("10. Поиск с пустым запросом:");
        Searchable[] emptyResults = searchEngine.search("");
        printSearchResults(emptyResults);

        // Демонстрация метода getStringRepresentation
        System.out.println("11. Демонстрация getStringRepresentation():");
        System.out.println("Товар: " + banana.getStringRepresentation());
        System.out.println("Статья: " + article1.getStringRepresentation());
    }

    private static void printSearchResults(Searchable[] results) {
        if (results.length == 0) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Найдено " + results.length + " результатов:");
            for (Searchable result : results) {
                System.out.println("  - " + result.getStringRepresentation());
            }
        }
        System.out.println();
    }
}