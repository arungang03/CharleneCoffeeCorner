package com.charlene.service;

import com.charlene.model.Beverage;
import com.charlene.model.Extra;
import com.charlene.model.Order;
import com.charlene.model.Snack;

import java.math.BigDecimal;
import java.util.List;

public class BonusProgram {

    public void applyBeverageDiscount(Order order) {
        int beverageCount = order.getBeverageCount();
        if (beverageCount >= 5) {
            Beverage beverageToDiscount = order.getBeverages().get(4); // Get the 5th beverage
            beverageToDiscount.setPrice(new BigDecimal(0.0)); // Make the 5th beverage free
        }
    }

    public void applySnackExtraDiscount(Order order) {
        boolean hasSnack = order.getItems().stream().anyMatch(item -> item instanceof Snack);
        if (hasSnack) {
            List<Extra> extras = order.getAllExtras();
            if (!extras.isEmpty()) {
                Extra extra = extras.get(0); // Apply discount to the first extra
                extra.setPrice(new BigDecimal(0.0)); // Make the first extra free
            }
        }
    }
}
