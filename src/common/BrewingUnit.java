package common;

import java.util.logging.Logger;

public class BrewingUnit {
    private static Logger logger = Logger.getLogger(BrewingUnit.class.getName());

    public CoffeeDrink brew(CoffeeSelection filterCoffee, GroundCoffee groundCoffee, int quantityWater) {
        CoffeeDrink drink = new CoffeeDrink(filterCoffee, groundCoffee, quantityWater);

        logger.info(drink.toString());

        return drink;
    }
}
