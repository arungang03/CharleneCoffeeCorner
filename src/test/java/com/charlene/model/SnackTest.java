package com.charlene.model;

import com.charlene.enums.ExtraType;
import com.charlene.enums.SnackType;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SnackTest {
    private Snack baconRoll;
    private Extra extraMilk;
    private Extra foamedMilk;

    @Before
    public void setUp() {
        // Create extras
        extraMilk = new Extra(ExtraType.EXTRA_MILK);
        foamedMilk = new Extra(ExtraType.FOAMED_MILK);

        // Create a snack
        baconRoll = new Snack(SnackType.BACON_ROLL);
    }

    @Test
    public void testGetExtrasInitiallyEmpty() {
        // Ensure that the list of extras is initially empty
        assertTrue(baconRoll.getExtras().isEmpty(), "The extras list should be initially empty.");
    }

    @Test
    public void testAddExtra() {
        // Add extras to the snack
        baconRoll.getExtras().add(extraMilk);
        baconRoll.getExtras().add(foamedMilk);

        List<Extra> extras = baconRoll.getExtras();

        // Assert that extras are added correctly
        assertEquals(extras.size(), 2);
        assertTrue(extras.contains(extraMilk), "The snack should contain Extra Milk.");
        assertTrue(extras.contains(foamedMilk), "The snack should contain Foamed Milk.");
    }

    @Test
    public void testGetItemType() {
        // Check the item type of the snack
        String itemType = baconRoll.getItemType();
        assertEquals(itemType, "Snack", itemType);
    }

    @Test
    public void testToStringWithoutExtras() {
        // Check the toString output without any extras
        String expectedOutput = "Bacon Roll - 4.5 CHF";
        assertEquals(baconRoll.toString(), expectedOutput, baconRoll.toString());
    }

    @Test
    public void testToStringWithExtras() {
        // Add extras to the snack
        baconRoll.getExtras().add(extraMilk);
        baconRoll.getExtras().add(foamedMilk);

        // Expected toString output with extras
        String expectedOutput = "Bacon Roll - 4.5 CHF with extras: Extra Milk, Foamed Milk";
        assertEquals(baconRoll.toString(), expectedOutput, baconRoll.toString());
    }
}
