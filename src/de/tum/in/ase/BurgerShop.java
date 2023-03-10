package de.tum.in.ase;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BurgerShop {
    private Stock stock;
    private List<Burger> orders;
    public BurgerShop() {
        this.stock = new Stock();
        this.orders = new LinkedList<>();
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<Burger> getOrders() {
        return orders;
    }

    public void setOrders(List<Burger> orders) {
        this.orders = orders;
    }

    public int calculateTotalPrice(Burger burger) {
        List<String> ingredients = burger.getIngredients();
        int totalPrice = 0;
        for (String ingredient : ingredients) {
            StockIngredient stockIngredient = stock.findStockIngredient(ingredient);
            totalPrice += stockIngredient.getPrice();
        }
        return totalPrice;
    }

    public void acceptSupplyDelivery(String ingredientName, int ingredientPrice, int deliverdQuantity) {
        if (stock.findStockIngredient(ingredientName) == null) {
            StockIngredient newStockIngredient = new StockIngredient(ingredientName, ingredientPrice, deliverdQuantity);
            stock.addtoStockIngredients(newStockIngredient);
        } else {
            for (int i = 0; i < deliverdQuantity; i++) {
                stock.add(ingredientName);
            }
        }
    }

    public void orderBurger(Burger burger) {
    // each order can consist of only one burger.
    // FIFO (First In, First Out)
//        The orderBurger method should add the burger to the list of orders and then make a call to the checkOrderReady()
        orders.add(burger);
        checkOrderReady();
    }

    public void checkOrderReady() {
//        If all necessary Ingredients are in Stock -> isReady = true -> notify (print)
//        checkOrderReady() serves as many burgers as possible until either:
            //the order queue is empty or
            //one order cannot be served due to missing ingredients.
        while (!orders.isEmpty()) {
            boolean isReady = true;
            Burger burger = orders.get(0);
            List<String> ingredients = burger.getIngredients();
            for (String ingredient : ingredients) {
                if (stock.findStockIngredient(ingredient) == null) {
                    isReady = false;
                    break;
                } else {
                    StockIngredient stockIngredient = stock.findStockIngredient(ingredient);
                    if (stockIngredient.getQuantity() < 0) {
                        isReady = false;
                        break;
                    } else {
                        stock.take(stockIngredient.getName());
                    }
                }
            }
            if (isReady) {
                System.out.printf("The order is ready: %s%n", burger.getName());
                orders.remove(burger);
            } else {
                break;
            }
        }
    }
}
