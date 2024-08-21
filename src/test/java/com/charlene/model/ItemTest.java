package com.charlene.model;
import com.charlene.enums.BeverageType;
import com.charlene.enums.SnackType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testItemName() {
        Item beverage = new Beverage(BeverageType.MEDIUM_COFFEE);
        assertEquals("Medium Coffee", beverage.getName());
    }

    @Test
    public void testItemPrice() {
        Item snack = new Snack(SnackType.BACON_ROLL);
        assertEquals(new BigDecimal(4.50), snack.getPrice());
    }

    @Test
    public void testItemTypeForBeverage() {
        Item beverage = new Beverage(BeverageType.SMALL_COFFEE);
        assertEquals("Beverage", beverage.getItemType());
    }

    @Test
    public void testItemTypeForSnack() {
        Item snack = new Snack(SnackType.BACON_ROLL);
        assertEquals("Snack", snack.getItemType());
    }
}
