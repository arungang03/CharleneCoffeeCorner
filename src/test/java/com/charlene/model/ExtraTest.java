package com.charlene.model;


import com.charlene.enums.ExtraType;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ExtraTest {
    private Extra extraMilk;
    private Extra specialRoastCoffee;

    @Before
    public void setUp() {
        // Create extras using enum
        extraMilk = new Extra(ExtraType.EXTRA_MILK);
        specialRoastCoffee = new Extra(ExtraType.SPECIAL_ROAST_COFFEE);
    }

    @Test
    public void testGetName() {
        // Verify that the name of the extra is correctly retrieved
        assertEquals(extraMilk.getName(), "Extra Milk", extraMilk.getName());
        assertEquals(specialRoastCoffee.getName(), "Special Roast Coffee", specialRoastCoffee.getName());
    }

    @Test
    public void testSetPrice() {
        // Set a new price and verify it
        extraMilk.setPrice(new BigDecimal("0.40"));
        assertEquals(extraMilk.getPrice(), new BigDecimal("0.40"));
    }

    @Test
    public void testConstructorPriceInitialization() {
        // Verify that the price is initialized correctly by the constructor
        Extra extraMilk = new Extra(ExtraType.EXTRA_MILK);
        assertEquals(extraMilk.getPrice(), ExtraType.EXTRA_MILK.getPrice());

        Extra specialRoastCoffee = new Extra(ExtraType.SPECIAL_ROAST_COFFEE);
        assertEquals(specialRoastCoffee.getPrice(), ExtraType.SPECIAL_ROAST_COFFEE.getPrice());
    }
}
