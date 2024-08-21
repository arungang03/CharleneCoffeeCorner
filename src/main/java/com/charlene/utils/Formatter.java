package com.charlene.utils;

import com.charlene.model.Extra;
import com.charlene.model.Item;

import java.math.BigDecimal;

public class Formatter {

    public String formatItem(Item item) {
        return item.getName() + " - " + formatPrice(item.getPrice());
    }

    public String formatExtra(Extra extra) {
        return "  + " + extra.getName() + " - " + formatPrice(extra.getPrice());
    }

    public static String formatPrice(BigDecimal price) {
        return String.format("%.2f"+ " CHF", price);
    }
}
