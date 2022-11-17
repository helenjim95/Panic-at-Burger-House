package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<StockIngredient> stockIngredients;

    public Stock() {
        this.stockIngredients = new ArrayList<>();
    }
    public List<StockIngredient> getStockIngredients() {
        return stockIngredients;
    }

    public void setStockIngredients(List<StockIngredient> stockIngredientList) {
        this.stockIngredients = stockIngredientList;
    }

    public void addStockIngredient(StockIngredient stockIngredient) {
        stockIngredients.add(stockIngredient);
    }
    public int add(String stock) {
        if (!stockIngredients.contains(stock)) {
            return -1;
        } else {
            StockIngredient stockIngredient = findStockIngredient(stock);
            stockIngredient.setQuantity(stockIngredient.getQuantity() + 1);
            return stockIngredient.getQuantity();
        }
    }
    public int take(String stock) {
        if (!stockIngredients.contains(stock)) {
            return -1;
        } else {
            StockIngredient stockIngredient = findStockIngredient(stock);
            if (stockIngredient.getQuantity() == 0) {
                return -1;
            } else {
                stockIngredient.setQuantity(stockIngredient.getQuantity() - 1);
            }
            return stockIngredient.getQuantity();
        }
    }
    public StockIngredient findStockIngredient(String stock) {
        for (StockIngredient stockIngredient : stockIngredients) {
            if (stock.equals(stockIngredient.getName())) {
                return stockIngredient;
            }
        }
        return null;
    }
}
