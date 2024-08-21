package com.charlene.utils;
import com.charlene.enums.BeverageType;
import com.charlene.model.Beverage;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
public class FormatterTest {
    @Test
    public void testFormatItem() {
        Formatter formatter = new Formatter();
        Beverage coffee = new Beverage(BeverageType.LARGE_COFFEE);
        String formattedItem = formatter.formatItem(coffee);
        assertEquals("Large Coffee - 3.50 CHF", formattedItem);
    }

    @Test
    public void testFormatPrice() {
        Formatter formatter = new Formatter();
        String formattedPrice = formatter.formatPrice(new BigDecimal(4.50));
        assertEquals("4.50 CHF", formattedPrice);
    }
}
