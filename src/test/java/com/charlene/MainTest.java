package com.charlene;

import com.charlene.enums.BeverageType;
import com.charlene.enums.ExtraType;
import com.charlene.enums.SnackType;
import com.charlene.model.Beverage;
import com.charlene.model.Extra;
import com.charlene.model.Order;
import com.charlene.model.Snack;
import com.charlene.service.BonusProgram;
import com.charlene.service.ReceiptGenerator;
import com.charlene.utils.BonusEligibilityChecker;
import com.charlene.utils.Formatter;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MainTest {

    private Order order;
    private Beverage smallCoffee;
    private Beverage largeCoffee;
    private Snack baconRoll;
    private Beverage orangeJuice;
    private Extra extraMilk;
    private Extra specialRoastCoffee;

    @Before
    public void setUp() {
        // Create extras
        extraMilk = new Extra(ExtraType.EXTRA_MILK);
        specialRoastCoffee = new Extra(ExtraType.SPECIAL_ROAST_COFFEE);

        // Create beverages and snacks
        smallCoffee = new Beverage(BeverageType.SMALL_COFFEE);
        smallCoffee.addExtra(specialRoastCoffee);
        largeCoffee = new Beverage(BeverageType.LARGE_COFFEE);
        largeCoffee.addExtra(extraMilk);
        baconRoll = new Snack(SnackType.BACON_ROLL);
        orangeJuice = new Beverage(BeverageType.ORANGE_JUICE);

        // Create order and add items
        order = new Order();
        order.addItem(smallCoffee);
        order.addItem(largeCoffee);
        order.addItem(baconRoll);
        order.addItem(orangeJuice);
    }

    @Test
    public void testOrderAndBonusEligibility() {
        // Check beverage and snack bonus eligibility
        boolean eligibleForSnackBonus = BonusEligibilityChecker.BEVERAGE_AND_SNACK.isEligible(order);
        boolean eligibleForBeverageBonus = BonusEligibilityChecker.FIVE_BEVERAGES.isEligible(order);

        assertTrue("Order should be eligible for snack bonus.", eligibleForSnackBonus);
        assertTrue("Order should not be eligible for beverage bonus.", !eligibleForBeverageBonus);

        // Apply bonuses if eligible
        BonusProgram bonusProgram = new BonusProgram();
        if (eligibleForBeverageBonus) {
            bonusProgram.applyBeverageDiscount(order);
        } else if (eligibleForSnackBonus) {
            bonusProgram.applySnackExtraDiscount(order);
        }

        // Verify if the snack extra discount is applied
        assertEquals( BigDecimal.ZERO, order.getAllExtras().get(0).getPrice());
    }

    @Test
    public void testReceiptGeneration() {
        // Generate and verify the receipt
        ReceiptGenerator generator = new ReceiptGenerator();
        String receipt = generator.generate(order);

        assertTrue("Receipt should contain the correct total price.",
                receipt.contains("Total: " +Formatter.formatPrice(new BigDecimal(15.65))));
    }
}
