package com.charlene.enums;

import java.math.BigDecimal;

public enum SnackType {
    BACON_ROLL("Bacon Roll", new BigDecimal(4.50));

    private final String name;
    private final BigDecimal price;

    SnackType(String name, BigDecimal price) {
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
