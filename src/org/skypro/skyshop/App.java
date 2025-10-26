package org.skypro.skyshop;

import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import java.util.Map;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Демонстрация проверок данных с обработкой исключений
        System.out.println("=== ДЕМОНСТРАЦИЯ ПРОВЕРОК ДАННЫХ ===\n");

        demonstrateValidationChecks();

        System.out.println("\n=== СОЗДАНИЕ КОРРЕКТНЫХ ПРОДУКТОВ И СТАТЕЙ ===\n");

        // Создаем корректные объекты и демонстрируем поиск
        demonstrateSearchFunctionality();

        System.out.println("\n=== ДЕМОНСТРАЦИЯ РАБОТЫ КОРЗИНЫ ===\n");

        // Демонстрация работы корзины с новым функционалом
        demonstrateBasketFunctionality();
    }

    private static void demonstrateValidationChecks() {
        // Попытка создания продуктов с неправильными данными
        String[] testCases = {
                "Пустое название продукта",
                "Название из пробелов",
                "Цена = 0",
                "Цена отрицательная",
                "Скидка отрицательная",
                "Скидка больше 100",
                "Базовая цена = 0",
                "Пустой заголовок статьи",
                "Пустое содержание статьи"
        };

        int testCaseIndex = 0;

        try {
            SimpleProduct invalidProduct1 = new SimpleProduct("", 10);
        } catch (IllegalArgumentException e) {
            System.out.println((++testCaseIndex) + ". " + testCases[0] + ": " + e.getMessage());
        }

        try {
            SimpleProduct invalidProduct2 = new SimpleProduct("   ", 10);
        } catch (IllegalArgumentException e) {
            System.out.println((++testCaseIndex) + ". " + testCases[1] + ": " + e.getMessage());
        }

        try {
            SimpleProduct invalidProduct3 = new SimpleProduct("Нормальное имя", 0);
        } catch (IllegalArgumentException e) {
            System.out.println((++testCaseIndex) + ". " + testCases[2] + ": " + e.getMessage());
        }

        try {
            SimpleProduct invalidProduct4 = new SimpleProduct("Нормальное имя", -5);
        } catch (IllegalArgumentException e) {
            System.out.println((++testCaseIndex) + ". " + testCases[3] + ": " + e.getMessage());
        }

        try {
            DiscountedProduct invalidProduct5 = new DiscountedProduct("Нормальное имя", 50, -10);
        } catch (IllegalArgumentException e) {
            System.out.println((++testCaseIndex) + ". " + testCases[4] + ": " + e.getMessage());
        }

        try {
            DiscountedProduct invalidProduct6 = new DiscountedProduct("Нормальное имя", 50, 150);
        } catch (IllegalArgumentException e) {
            System.out.println((++testCaseIndex) + ". " + testCases[5] + ": " + e.getMessage());
        }

        try {
            DiscountedProduct invalidProduct7 = new DiscountedProduct("Нормальное имя", 0, 10);
        } catch (IllegalArgumentException e) {
            System.out.println((++testCaseIndex) + ". " + testCases[6] + ": " + e.getMessage());
        }

        try {
            Article invalidArticle1 = new Article("", "Содержание статьи");
        } catch (IllegalArgumentException e) {
            System.out.println((++testCaseIndex) + ". " + testCases[7] + ": " + e.getMessage());
        }

        try {
            Article invalidArticle2 = new Article("Заголовок", "");
        } catch (IllegalArgumentException e) {
            System.out.println((++testCaseIndex) + ". " + testCases[8] + ": " + e.getMessage());
        }
    }

    private static void demonstrateSearchFunctionality() {
        // Создаем корректные товары
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

        // Создаем поисковый движок
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

        System.out.println("В поисковом движке: " + searchEngine.getSize() + " объектов\n");

        System.out.println("=== ДЕМОНСТРАЦИЯ ОБЫЧНОГО ПОИСКА ===");
        demonstrateRegularSearch(searchEngine);

        // Демонстрация нового метода поиска
        System.out.println("=== ДЕМОНСТРАЦИЯ ПОИСКА НАИБОЛЕЕ ПОДХОДЯЩЕГО РЕЗУЛЬТАТА ===");
        demonstrateBestMatchSearch(searchEngine);

        System.out.println("=== ДЕМОНСТРАЦИЯ getStringRepresentation() ===");
        System.out.println("Товар: " + banana.getStringRepresentation());
        System.out.println("Статья: " + article1.getStringRepresentation());
    }

    private static void demonstrateRegularSearch(SearchEngine searchEngine) {
        String[] searchQueries = {"банан", "яблок", "арбуз", "фрукт", "овощ", "польза", "рецепт"};

        for (String query : searchQueries) {
            System.out.println("\nПоиск по запросу '" + query + "':");
            Map<String, Searchable> results = searchEngine.search(query);
            printSearchResults(results);
        }
    }

    private static void demonstrateBestMatchSearch(SearchEngine searchEngine) {
        // Успешные случаи поиска
        String[] successfulQueries = {"банан", "яблок", "арбуз", "польза", "рецепт"};

        for (String query : successfulQueries) {
            System.out.println("\nПоиск наиболее подходящего для '" + query + "':");
            try {
                Searchable bestMatch = searchEngine.findBestMatch(query);
                System.out.println("Найден наиболее подходящий объект: " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println("Ошибка при поиске: " + e.getMessage());
            }
        }

        // Случаи с исключениями
        System.out.println("\n--- Случаи с исключениями ---");

        String[] failingQueries = {"клубника", "помидор", ""};
        String[] errorMessages = {
                "несуществующий запрос",
                "другой несуществующий запрос",
                "пустой запрос"
        };

        for (int i = 0; i < failingQueries.length; i++) {
            System.out.println("\nПоиск наиболее подходящего для '" + failingQueries[i] + "' (" + errorMessages[i] + "):");
            try {
                Searchable bestMatch = searchEngine.findBestMatch(failingQueries[i]);
                System.out.println("Найден наиболее подходящий объект: " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println("Ошибка при поиске: " + e.getMessage());
            }
        }
    }

    private static void demonstrateBasketFunctionality() {

        SimpleProduct banana1 = new SimpleProduct("Банан", 20);
        SimpleProduct banana2 = new SimpleProduct("Банан", 25); // другой банан
        SimpleProduct apple = new SimpleProduct("Яблоко", 30);
        DiscountedProduct watermelon = new DiscountedProduct("Арбуз", 100, 10);
        SimpleProduct pear = new SimpleProduct("Груша", 40);

        ProductBasket basket = new ProductBasket();

        System.out.println("--- Добавление продуктов в корзину ---");
        basket.addProduct(banana1);
        basket.addProduct(banana2); // второй банан
        basket.addProduct(apple);
        basket.addProduct(watermelon);
        basket.addProduct(pear);
        basket.addProduct(new SimpleProduct("Банан", 22)); // третий банан

        System.out.println("\n--- Содержимое корзины после добавления ---");
        basket.printCartContents();

        System.out.println("\n--- Удаление существующего продукта 'Банан' ---");
        List<Product> removedBananas = basket.removeProductsByName("Банан");
        System.out.println("Удаленные продукты:");
        if (removedBananas.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product product : removedBananas) {
                System.out.println("  - " + product.getName() + ": " + product.getCost() + " руб.");
            }
        }

        System.out.println("\n--- Содержимое корзины после удаления бананов ---");
        basket.printCartContents();

        System.out.println("\n--- Удаление несуществующего продукта 'Апельсин' ---");
        List<Product> removedOranges = basket.removeProductsByName("Апельсин");
        System.out.println("Удаленные продукты:");
        if (removedOranges.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product product : removedOranges) {
                System.out.println("  - " + product.getName() + ": " + product.getCost() + " руб.");
            }
        }

        System.out.println("\n--- Содержимое корзины после попытки удаления апельсина ---");
        basket.printCartContents();

        System.out.println("\n--- Очистка корзины ---");
        basket.clearBasket();
        basket.printCartContents();
    }

    private static void printSearchResults(Map<String, Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Найдено " + results.size() + " результатов (отсортировано по имени):");
            for (Map.Entry<String, Searchable> entry : results.entrySet()) {
                Searchable result = entry.getValue();
                System.out.println("  - " + result.getStringRepresentation());
            }
        }
    }
}