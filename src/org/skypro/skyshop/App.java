package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

public class App {
    public static void main(String[] args) {

        // Создаем товары разных типов
        SimpleProduct banana = new SimpleProduct("Банан", 20);
        SimpleProduct pear = new SimpleProduct("Груша", 30);
        DiscountedProduct apple = new DiscountedProduct("Яблоко", 50, 20); // 20% скидка
        FixPriceProduct melon = new FixPriceProduct("Дыня");
        DiscountedProduct watermelon = new DiscountedProduct("Арбуз", 100, 30); // 30% скидка
        SimpleProduct pumpkin = new SimpleProduct("Тыква", 40);

        ProductBasket basket = new ProductBasket();

        System.out.println("1. Добавление продукта в корзину");
        basket.addProduct(banana);
        basket.addProduct(pear);
        basket.addProduct(apple);
        System.out.println();

        System.out.println("2. Добавление продукта в заполненную корзину");
        basket.addProduct(melon);
        basket.addProduct(watermelon);
        basket.addProduct(pumpkin);
        System.out.println();

        System.out.println("3. Печать содержимого корзины с несколькими товарами");
        basket.printCartContents();
        System.out.println();

        System.out.println("4. Получение стоимости корзины с несколькими товарами");
        System.out.println("Цена корзины: " + basket.getTotalPrice());
        System.out.println();

        System.out.println("5. Поиск товара, который есть в корзине");
        System.out.println("Есть ли Яблоко в корзине: " + basket.containsProduct("Яблоко"));
        System.out.println("Есть ли Груша в корзине: " + basket.containsProduct("Груша"));
        System.out.println();

        System.out.println("6. Поиск товара, которого нет в корзине");
        System.out.println("Есть ли Тыква в корзине: " + basket.containsProduct("Тыква"));
        System.out.println("Есть ли Персик в корзине: " + basket.containsProduct("Персик"));
        System.out.println();

        System.out.println("7. Очистка корзины");
        basket.clearBasket();
        System.out.println();

        System.out.println("8. Печать содержимого пустой корзины");
        basket.printCartContents();
        System.out.println();

        System.out.println("9. Получение стоимости пустой корзины");
        System.out.println("Цена пустой корзины: " + basket.getTotalPrice());
        System.out.println();

        System.out.println("10. Поиск товара по имени в пустой корзине");
        System.out.println("Есть ли Банан в пустой корзине: " + basket.containsProduct("Банан"));
        System.out.println("Есть ли Груша в пустой корзине: " + basket.containsProduct("Груша"));
        System.out.println();
    }
}