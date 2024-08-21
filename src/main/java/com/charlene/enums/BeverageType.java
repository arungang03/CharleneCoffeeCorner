package com.charlene.enums;

import java.math.BigDecimal;

public enum BeverageType {
    SMALL_COFFEE("Small Coffee", new BigDecimal(2.50)),
    MEDIUM_COFFEE("Medium Coffee", new BigDecimal(3.00)),
    LARGE_COFFEE("Large Coffee", new BigDecimal(3.50)),
    ORANGE_JUICE("Freshly Squeezed Orange Juice", new BigDecimal(3.95));

    private final String name;
    private final BigDecimal price;

    BeverageType(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return name + " - " + price + " CHF";
    }
}
