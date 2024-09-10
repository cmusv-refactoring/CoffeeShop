package machine;

import common.CoffeeDrink;
import common.GroundCoffee;
import configuration.CoffeeException;

public interface CoffeeMachine {
    void addGroundCoffee(GroundCoffee newCoffee) throws CoffeeException;

    CoffeeDrink brewFilterCoffee() throws CoffeeException;

    CoffeeDrink brewEspresso() throws CoffeeException;
}
