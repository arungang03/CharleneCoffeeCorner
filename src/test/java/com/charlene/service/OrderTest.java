package com.charlene.service;

import com.charlene.enums.BeverageType;
import com.charlene.enums.ExtraType;
import com.charlene.enums.SnackType;
import com.charlene.model.Beverage;
import com.charlene.model.Extra;
import com.charlene.model.Order;
import com.charlene.model.Snack;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderTest {
    private Order order;
    private Beverage smallCoffee;
    private Beverage largeCoffee;
    private Snack baconRoll;
    private Extra extraMilk;
    private Extra foamedMilk;

    @Before
    public void setUp() {
        order = new Order();

        smallCoffee = new Beverage(BeverageType.SMALL_COFFEE);
        largeCoffee = new Beverage(BeverageType.LARGE_COFFEE);
        baconRoll = new Snack(SnackType.BACON_ROLL);

        extraMilk = new Extra(ExtraType.EXTRA_MILK);
        foamedMilk = new Extra(ExtraType.FOAMED_MILK);

        // Add extras to beverages
        smallCoffee.addExtra(extraMilk);
        largeCoffee.addExtra(foamedMilk);
    }

    @Test
    public void testAddItem() {
        order.addItem(smallCoffee);
        order.addItem(baconRoll);

        assertEquals(order.getItems().size(), 2, "The number of items in the order should be 2.");
    }

    @Test
    public void testGetBeverages() {
        order.addItem(smallCoffee);
        order.addItem(baconRoll);
        order.addItem(largeCoffee);

        List<Beverage> beverages = order.getBeverages();

        assertEquals(beverages.size(), 2, "The number of beverages in the order should be 2.");
        assertTrue(beverages.contains(smallCoffee), "Order should contain Small Coffee.");
        assertTrue(beverages.contains(largeCoffee), "Order should contain Large Coffee.");
    }

    @Test
    public void testGetBeverageCount() {
        order.addItem(smallCoffee);
        order.addItem(largeCoffee);

        assertEquals(order.getBeverageCount(), 2, "The beverage count should be 2.");
    }


    @Test
    public void testGetAllExtras() {
        order.addItem(smallCoffee);
        order.addItem(largeCoffee);
        order.addItem(baconRoll);

        List<Extra> extras = order.getAllExtras();

        assertEquals(extras.size(), 2, "The total number of extras in the order should be 2.");
        assertTrue(extras.contains(extraMilk), "Order should contain Extra Milk.");
        assertTrue(extras.contains(foamedMilk), "Order should contain Foamed Milk.");
    }

    @Test
    public void testGetAllExtrasEmpty() {
        order.addItem(baconRoll); // No extras added to the snack

        List<Extra> extras = order.getAllExtras();
        assertTrue(extras.isEmpty(), "The extras list should be empty when no extras are added.");
    }

    @Test
    public void testEmptyOrderTotalPrice() {
        BigDecimal expectedTotal = BigDecimal.ZERO;
        assertEquals(order.getTotalPrice(), expectedTotal, "The total price for an empty order should be 0.00 CHF.");
    }
}
