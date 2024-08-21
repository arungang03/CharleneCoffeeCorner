package com.charlene.utils;

import com.charlene.model.Beverage;
import com.charlene.model.Order;
import com.charlene.model.Snack;

import java.util.Optional;

public class BonusEligibilityChecker {
        // Check if the order has at least 1 beverage and 1 snack
        public static final BonusEligibility BEVERAGE_AND_SNACK = order -> {
            boolean hasBeverage = Optional.ofNullable(order)
                    .map(Order::getItems)
                    .filter(items -> !items.isEmpty())
                    .map(items -> items.stream().anyMatch(item -> item instanceof Beverage))
                    .orElse(false);
            boolean hasSnack = Optional.ofNullable(order)
                    .map(Order::getItems)
                    .filter(items -> !items.isEmpty())
                    .map(items -> items.stream().anyMatch(item -> item instanceof Snack))
                    .orElse(false);
            return hasBeverage && hasSnack;
        };

        // Check if the order has at least 5 beverages
        public static final BonusEligibility FIVE_BEVERAGES = order -> Optional.ofNullable(order)
                .map(Order::getBeverageCount)
                .filter(count -> count >= 5)
                .isPresent();
}
