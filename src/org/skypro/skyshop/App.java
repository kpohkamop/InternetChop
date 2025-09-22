package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        // Создаем продукты
        Product banana = new Product("Банан", 20);
        Product pear = new Product("Груша", 30);
        Product apple = new Product("Яблоко", 10);
        Product melon = new Product("Дыня", 60);
        Product watermelon = new Product("Арбуз", 50);
        Product pumpkin = new Product("Тыква", 40);

        // Создаем корзину
        ProductBasket basket = new ProductBasket();


        System.out.println("1. Добавление продукта в корзину");
        basket.addProduct(banana);
        basket.addProduct(pear);
        basket.addProduct(apple);
        System.out.println("Добавлено 3 продукта\n");

        System.out.println("2. Добавление продукта в заполненную корзину");
        basket.addProduct(melon);
        basket.addProduct(watermelon);
        System.out.println("Добавлено еще 2 продукта (всего 5)");


        System.out.print("Попытка добавить 6-й продукт: ");
        basket.addProduct(pumpkin);
        System.out.println();


        System.out.println("3. Печать содержимого корзины с несколькими товарами");
        basket.printCartContents();
        System.out.println();


        System.out.println("4. Получение стоимости корзины с несколькими товарами");
        int totalPrice = basket.getTotalPrice();
        System.out.println("Стоимость корзины: " + totalPrice + " руб.");
        System.out.println();


        System.out.println("5. Поиск товара, который есть в корзине");
        boolean hasApple = basket.containsProduct("Яблоко");
        boolean hasPear = basket.containsProduct("Груша");
        System.out.println("Есть ли Яблоко в корзине: " + hasApple);
        System.out.println("Есть ли Груша в корзине: " + hasPear);
        System.out.println();


        System.out.println("6. Поиск товара, которого нет в корзине");
        boolean hasPumpkin = basket.containsProduct("Тыква");
        boolean hasPeach = basket.containsProduct("Персик");
        System.out.println("Есть ли Тыква в корзине: " + hasPumpkin);
        System.out.println("Есть ли Персик в корзине: " + hasPeach);
        System.out.println();


        System.out.println("7. Очистка корзины");
        basket.clearBasket();
        System.out.println("Корзина очищена\n");


        System.out.println("8. Печать содержимого пустой корзины");
        basket.printCartContents();
        System.out.println();


        System.out.println("9. Получение стоимости пустой корзины");
        int emptyBasketPrice = basket.getTotalPrice();
        System.out.println("Стоимость пустой корзины: " + emptyBasketPrice + " руб.");
        System.out.println();


        System.out.println("10. Поиск товара по имени в пустой корзине");
        boolean hasBananaInEmpty = basket.containsProduct("Банан");
        boolean hasPearInEmpty = basket.containsProduct("Груша");
        System.out.println("Есть ли Банан в пустой корзине: " + hasBananaInEmpty);
        System.out.println("Есть ли Груша в пустой корзине: " + hasPearInEmpty);
        System.out.println();


    }
}