package com.charlene.model;

import com.charlene.enums.BeverageType;
import com.charlene.enums.ExtraType;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class BeverageTest {
    private Beverage smallCoffee;
    private Extra extraMilk;
    private Extra foamedMilk;

    @Before
    public void setUp() {
        // Create extras
        extraMilk = new Extra(ExtraType.EXTRA_MILK);
        foamedMilk = new Extra(ExtraType.FOAMED_MILK);

        // Create a beverage
        smallCoffee = new Beverage(BeverageType.SMALL_COFFEE);
    }

    @Test
    public void testAddExtra() {
        // Add extras to the beverage
        smallCoffee.addExtra(extraMilk);
        smallCoffee.addExtra(foamedMilk);

        List<Extra> extras = smallCoffee.getExtras();

        // Assert that extras are added correctly
        assertEquals(extras.size(), 2);
        assertTrue(extras.contains(extraMilk), "The beverage should contain Extra Milk.");
        assertTrue(extras.contains(foamedMilk), "The beverage should contain Foamed Milk.");
    }

    @Test
    public void testGetItemType() {
        // Ensure smallCoffee is not null
        assertNotNull(smallCoffee, "The smallCoffee object should be initialized.");

        // Check the item type of the beverage
        String itemType = smallCoffee.getItemType();
        assertEquals(itemType, "Beverage", "Beverage");
    }

    @Test
    public void testGetExtrasInitiallyEmpty() {
        // Ensure that the list of extras is initially empty
        assertTrue(smallCoffee.getExtras().isEmpty(), "The extras list should be initially empty.");
    }

    @Test
    public void testGetPrice() {
        // Check the price of the beverage
        BigDecimal expectedPrice = new BigDecimal("2.5");
        assertEquals(smallCoffee.getPrice(), expectedPrice);
    }
}
