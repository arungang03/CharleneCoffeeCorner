package com.charlene;

import com.charlene.enums.BeverageType;
import com.charlene.enums.ExtraType;
import com.charlene.enums.SnackType;
import com.charlene.model.Beverage;
import com.charlene.model.Extra;
import com.charlene.model.Snack;
import com.charlene.service.BonusProgram;
import com.charlene.model.Order;
import com.charlene.service.ReceiptGenerator;
import com.charlene.utils.BonusEligibilityChecker;

public class CharleneCoffeeCornerMain {

    public static void main(String args[]){

            // Create extras
            Extra extraMilk = new Extra(ExtraType.EXTRA_MILK);
            Extra specialRoastCoffee = new Extra(ExtraType.SPECIAL_ROAST_COFFEE);

            // Create beverages and snacks
            Beverage smallCoffee = new Beverage(BeverageType.SMALL_COFFEE);
            smallCoffee.addExtra(specialRoastCoffee);
            Beverage largeCoffee = new Beverage(BeverageType.LARGE_COFFEE);
            largeCoffee.addExtra(extraMilk);
            Snack baconRoll = new Snack(SnackType.BACON_ROLL);
            Beverage orangeJuice = new Beverage(BeverageType.ORANGE_JUICE);

            // Create order and add items
            Order order = new Order();
            order.addItem(smallCoffee);
            order.addItem(largeCoffee);
            order.addItem(baconRoll);
            order.addItem(orangeJuice);

            boolean eligibleForSnackBonus = BonusEligibilityChecker.BEVERAGE_AND_SNACK.isEligible(order);
            boolean eligibleForBeverageBonus = BonusEligibilityChecker.FIVE_BEVERAGES.isEligible(order);

            BonusProgram bonusProgram = new BonusProgram();
            // Apply bonuses if eligible
            if(eligibleForBeverageBonus){
                    bonusProgram.applyBeverageDiscount(order);
            }else if (eligibleForSnackBonus) {
                    bonusProgram.applySnackExtraDiscount(order);
            }
            ReceiptGenerator generator = new ReceiptGenerator();
            String receipt = generator.generate(order);
            System.out.println(receipt);

    }
}
