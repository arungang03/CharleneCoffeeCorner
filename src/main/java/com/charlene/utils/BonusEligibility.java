package com.charlene.utils;

import com.charlene.model.Order;

@FunctionalInterface
public interface BonusEligibility {

    boolean isEligible(Order order);
}
