package com.charlene.enums;

import java.math.BigDecimal;

public enum ExtraType {
    EXTRA_MILK("Extra Milk", new BigDecimal(0.30)),
    FOAMED_MILK("Foamed Milk", new BigDecimal(0.50)),
    SPECIAL_ROAST_COFFEE("Special Roast Coffee", new BigDecimal(0.90));

    private final String name;
    private final BigDecimal price;

    ExtraType(String name, BigDecimal price) {
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
