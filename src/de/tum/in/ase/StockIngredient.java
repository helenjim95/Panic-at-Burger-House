package de.tum.in.ase;

public class StockIngredient {
    private String name;
    private int price;
    private int quantity;

    public StockIngredient(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            this.name = name;
        } catch (Exception e) {
            this.name = "";
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (price < 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }
}
