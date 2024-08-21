package com.charlene.model;

import com.charlene.enums.ExtraType;

import java.math.BigDecimal;

public class Extra {
    private final ExtraType type;
    private BigDecimal price;

    public Extra(ExtraType type) {
        this.type = type;
        this.price = type.getPrice(); // Initialize with enum's price
    }

    public String getName() {
        return type.getName();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price; // Allow price to be updated
    }
}