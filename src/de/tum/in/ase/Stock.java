package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<StockIngredient> stockIngredientList;
//    private StockIngredient stockIngredient;

    public Stock() {
        this.stockIngredientList = new ArrayList<StockIngredient>();
    }
    public List<StockIngredient> getStockIngredientList() {
        return stockIngredientList;
    }

    public void setStockIngredientList(List<StockIngredient> stockIngredientList) {
        this.stockIngredientList = stockIngredientList;
    }

    public void addstockIngredient(StockIngredient stockIngredient) {
        stockIngredientList.add(stockIngredient);
    }
    public int add(String stock) {
        if (!stockIngredientList.contains(stock)) {
            return -1;
        } else {
            StockIngredient stockIngredient = findStockIngredient(stock);
            stockIngredient.setQuantity(stockIngredient.getQuantity() + 1);
            return stockIngredient.getQuantity();
        }
    }
    public int take(String stock) {
        if (!stockIngredientList.contains(stock)) {
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
        for (StockIngredient stockIngredient : stockIngredientList) {
            if (stock.equals(stockIngredient.getName())) {
                return stockIngredient;
            }
        }
        return null;
    }
}
