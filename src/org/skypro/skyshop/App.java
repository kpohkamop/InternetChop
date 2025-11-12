package org.skypro.skyshop;

import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.article.Article;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        SimpleProduct banana = new SimpleProduct("Банан", 20);
        SimpleProduct pear = new SimpleProduct("Груша", 30);
        DiscountedProduct apple = new DiscountedProduct("Яблоко", 50, 20);
        FixPriceProduct melon = new FixPriceProduct("Дыня");
        DiscountedProduct watermelon = new DiscountedProduct("Арбуз", 100, 30);
        SimpleProduct pumpkin = new SimpleProduct("Тыква", 40);
        SimpleProduct appleJuice = new SimpleProduct("Яблочный сок", 80);
        SimpleProduct bananaMilkShake = new SimpleProduct("Банановый молочный коктейль", 120);


        Article article1 = new Article(
                "Польза бананов для здоровья человека",
                "Бананы богаты калием и другими полезными микроэлементами..."
        );

        Article article2 = new Article(
                "Как выбрать спелый арбуз",
                "При выборе арбуза обратите внимание на цвет корки..."
        );

        Article article3 = new Article(
                "Рецепты из яблок",
                "Яблоки можно использовать для приготовления пирогов..."
        );

        Article article4 = new Article(
                "Фрукты",
                "В нашем магазине появились новые экзотические фрукты..."
        );

        Article article5 = new Article(
                "Сезонные овощи осенью и их польза",
                "Осенью особенно полезны тыква, кабачки..."
        );


        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(banana);
        searchEngine.add(pear);
        searchEngine.add(apple);
        searchEngine.add(melon);
        searchEngine.add(watermelon);
        searchEngine.add(pumpkin);
        searchEngine.add(appleJuice);
        searchEngine.add(bananaMilkShake);

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);

        System.out.println("=== ДЕМОНСТРАЦИЯ ОБНОВЛЁННОГО ПОИСКОВОГО ДВИЖКА ===\n");
        System.out.println("В поисковом движке: " + searchEngine.getSize() + " объектов\n");

        System.out.println("=== ТЕСТИРОВАНИЕ equals и hashCode ===");
        SimpleProduct banana2 = new SimpleProduct("Банан", 25);
        System.out.println("banana.equals(banana2): " + banana.equals(banana2)); // true - одинаковые имена
        System.out.println("banana.hashCode() == banana2.hashCode(): " + (banana.hashCode() == banana2.hashCode()));
        System.out.println();

        System.out.println("1. Поиск по запросу 'банан' (проверка сортировки по длине):");
        Set<Searchable> bananaResults = searchEngine.search("банан");
        printSearchResults(bananaResults);

        System.out.println("2. Поиск по запросу 'фрукт' (разная длина названий):");
        Set<Searchable> fruitResults = searchEngine.search("фрукт");
        printSearchResults(fruitResults);

        System.out.println("3. Поиск по запросу 'яблок':");
        Set<Searchable> appleResults = searchEngine.search("яблок");
        printSearchResults(appleResults);

        System.out.println("4. Поиск по запросу 'овощ':");
        Set<Searchable> vegetableResults = searchEngine.search("овощ");
        printSearchResults(vegetableResults);

        System.out.println("5. Поиск с пустым запросом (все элементы, отсортированные):");
        Set<Searchable> allResults = searchEngine.search("");
        printSearchResults(allResults);

        System.out.println("6. Тестирование компаратора (одинаковая длина):");
        SimpleProduct cat = new SimpleProduct("Кот", 10);
        SimpleProduct dog = new SimpleProduct("Пёс", 15);
        searchEngine.add(cat);
        searchEngine.add(dog);
        Set<Searchable> sameLengthResults = searchEngine.search("Кот");
        printSearchResults(sameLengthResults);
    }

    private static void printSearchResults(Set<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Найдено " + results.size() + " результатов:");
            for (Searchable result : results) {
                System.out.println("  - " + result.getName() + " [" + result.getContentType() +
                        ", длина: " + result.getName().length() + "]");
            }
        }
        System.out.println();
    }
}