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

import java.util.Formatter;

import static org.junit.Assert.assertEquals;

public class ReceiptGeneratorTest {

    private ReceiptGenerator receiptGenerator;
    private Order order;
    private Formatter formatter;

    @Before
    public void setUp() {
        receiptGenerator = new ReceiptGenerator();
        formatter = new Formatter();
        order = new Order();

        // Create beverages and snacks
        Beverage smallCoffee = new Beverage(BeverageType.SMALL_COFFEE);
        Beverage largeCoffee = new Beverage(BeverageType.LARGE_COFFEE);
        Snack baconRoll = new Snack(SnackType.BACON_ROLL);

        // Create extras
        Extra extraMilk = new Extra(ExtraType.EXTRA_MILK);
        Extra foamedMilk = new Extra(ExtraType.FOAMED_MILK);

        // Add extras to beverages
        smallCoffee.addExtra(extraMilk);
        largeCoffee.addExtra(foamedMilk);

        // Add items to order
        order.addItem(smallCoffee);
        order.addItem(largeCoffee);
        order.addItem(baconRoll);

        // Add extras directly to the order
        order.getAllExtras().add(extraMilk);
        order.getAllExtras().add(foamedMilk);
    }

    @Test
    public void testGenerateReceipt() {
        String expectedReceipt =
               "Small Coffee - 2.50 CHF\n" +
                       "Large Coffee - 3.50 CHF\n" +
                       "Bacon Roll - 4.50 CHF\n" +
                       "  + Extra Milk - 0.30 CHF\n" +
                       "  + Foamed Milk - 0.50 CHF\n" +
                       "Total: 11.30 CHF";

        String actualReceipt = receiptGenerator.generate(order);

        assertEquals(expectedReceipt, actualReceipt);
    }
}
