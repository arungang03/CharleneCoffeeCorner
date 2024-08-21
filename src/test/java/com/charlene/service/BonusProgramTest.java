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

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class BonusProgramTest {

    private BonusProgram bonusProgram;
    private Order order;
    private Beverage smallCoffee;
    private Beverage largeCoffee;
    private Beverage mediumCoffee;
    private Snack baconRoll;
    private Extra extraMilk;
    private Extra foamedMilk;

    @Before
    public void setUp() {
        bonusProgram = new BonusProgram();

        // Create extras
        extraMilk = new Extra(ExtraType.EXTRA_MILK);
        foamedMilk = new Extra(ExtraType.FOAMED_MILK);

        // Create beverages
        smallCoffee = new Beverage(BeverageType.SMALL_COFFEE);
        largeCoffee = new Beverage(BeverageType.LARGE_COFFEE);
        mediumCoffee = new Beverage(BeverageType.MEDIUM_COFFEE);

        // Create a snack
        baconRoll = new Snack(SnackType.BACON_ROLL);

        // Create an order
        order = new Order();
    }

    @Test
    public void testApplyBeverageDiscountWithEnoughBeverages() {
        // Add 5 beverages to the order
        order.addItem(smallCoffee);
        order.addItem(largeCoffee);
        order.addItem(mediumCoffee);
        order.addItem(new Beverage(BeverageType.SMALL_COFFEE));
        order.addItem(new Beverage(BeverageType.LARGE_COFFEE));

        // Apply the beverage discount
        bonusProgram.applyBeverageDiscount(order);

        // Verify that the price of the 5th beverage is set to 0
        List<Beverage> beverages = order.getBeverages();
        assertEquals(beverages.get(4).getPrice(), BigDecimal.ZERO);
    }

    @Test
    public void testApplyBeverageDiscountWithNotEnoughBeverages() {
        // Add fewer than 5 beverages to the order
        order.addItem(smallCoffee);
        order.addItem(largeCoffee);
        order.addItem(mediumCoffee);

        // Apply the beverage discount
        bonusProgram.applyBeverageDiscount(order);

        // Verify that no beverage is discounted
        List<Beverage> beverages = order.getBeverages();
        for (Beverage beverage : beverages) {
            assertNotEquals(beverage.getPrice(), BigDecimal.ZERO, "No beverage should be free.");
        }
    }

    @Test
    public void testApplySnackExtraDiscountWithSnackAndExtras() {
        // Add a snack and extras to the order
        order.addItem(baconRoll);
        baconRoll.addExtra(extraMilk);
        baconRoll.addExtra(foamedMilk);

        // Apply the snack extra discount
        bonusProgram.applySnackExtraDiscount(order);

        // Verify that the price of the first extra is set to 0
        assertEquals(extraMilk.getPrice(), BigDecimal.ZERO);
    }

    @Test
    public void testApplySnackExtraDiscountWithoutSnack() {
        // Add only beverages to the order
        order.addItem(smallCoffee);
        order.addItem(largeCoffee);
        order.addItem(mediumCoffee);

        // Apply the snack extra discount
        bonusProgram.applySnackExtraDiscount(order);

        // Verify that no extra is discounted (since there is no snack)
        List<Extra> extras = order.getAllExtras();
        for (Extra extra : extras) {
            assertNotEquals(extra.getPrice(), BigDecimal.ZERO, "No extra should be free when there is no snack.");
        }
    }
}
