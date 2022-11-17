package de.tum.in.ase;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StockIngredient cheese = new StockIngredient("cheese", 5, 10);
        StockIngredient lettuce = new StockIngredient("lettuce", 3, 6);
        StockIngredient bun = new StockIngredient("bun", 2, 15);
        StockIngredient beefPatty = new StockIngredient("beefPatty", 7, 13);
        Stock stock = new Stock();
        List<StockIngredient> stockIngredients = Arrays.asList(cheese, lettuce, bun, beefPatty);
        stock.setStockIngredients(stockIngredients);
        Burger cheeseBurger = new Burger("cheeseBurger", Arrays.asList("cheese", "lettuce", "bun", "beefPatty"));
        Burger chickenBurger = new Burger("chickenBurger", Arrays.asList("cheese", "lettuce", "bun", "chickenPatty"));
        Burger veggieBurger = new Burger("veggieBurger", Arrays.asList("cheese", "lettuce", "bun"));
        BurgerShop burgerShop = new BurgerShop();
        burgerShop.setStock(stock);
        burgerShop.acceptSupplyDelivery("cheese", 4, 3);
//        burgerShop.acceptSupplyDelivery("cheese", 4, 3);
//        burgerShop.acceptSupplyDelivery("cheese", 4, 3);
//        burgerShop.acceptSupplyDelivery("cheese", 4, 3);
        burgerShop.orderBurger(cheeseBurger);
        burgerShop.orderBurger(chickenBurger);
        burgerShop.orderBurger(veggieBurger);
    }

}
