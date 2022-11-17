package de.tum.in.ase;

import java.util.List;

public class Burger {
    //TODO: Implement Part 1
    private String name;
    private List<String> ingredients;

    public Burger(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        try {
            this.ingredients = ingredients;
        } catch (Exception e) {
            this.ingredients = null;
        }
    }
}
