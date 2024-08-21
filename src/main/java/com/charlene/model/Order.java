package com.charlene.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items;
    private List<Extra> extras;

    public Order() {
        items = new ArrayList<>();
        extras = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Beverage> getBeverages() {
        List<Beverage> beverages = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Beverage) {
                beverages.add((Beverage) item);
            }
        }
        return beverages;
    }

    public int getBeverageCount() {
        return getBeverages().size();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : items) {
            total = total.add(item.getPrice());
            if (item instanceof Beverage) {
                Beverage beverage = (Beverage) item;
                BigDecimal extraCost = beverage.getExtras().stream()
                        .map(Extra::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                total = total.add(extraCost);
            } else if (item instanceof Snack) {
                Snack snack = (Snack) item;
                BigDecimal extraCost = snack.getExtras().stream()
                        .map(Extra::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                total = total.add(extraCost);
            }
        }
        return total;
    }

    public List<Extra> getAllExtras() {
        List<Extra> allExtras = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Beverage) {
                Beverage beverage = (Beverage) item;
                allExtras.addAll(beverage.getExtras());
            } else if (item instanceof Snack) {
                Snack snack = (Snack) item;
                allExtras.addAll(snack.getExtras());
            }
        }
        return allExtras;
    }
}