package machine;

import common.BrewingUnit;
import common.CoffeeDrink;
import common.CoffeeSelection;
import common.GroundCoffee;
import configuration.CoffeeException;
import configuration.MachineConfiguration;

import java.util.EnumMap;

public class BasicCoffeeMachine implements CoffeeMachine {
    private EnumMap<CoffeeSelection, MachineConfiguration> configMap;
    private GroundCoffee groundCoffee;
    private BrewingUnit brewingUnit;

    public BasicCoffeeMachine(GroundCoffee coffee) {
        this.groundCoffee = coffee;
        this.brewingUnit = new BrewingUnit();

        this.configMap = new EnumMap<>(CoffeeSelection.class);
        this.configMap.put(CoffeeSelection.FILTER_COFFEE, new MachineConfiguration(30, 480));
    }

    @Override
    public void addGroundCoffee(GroundCoffee newCoffee) throws CoffeeException {
        if (this.groundCoffee != null) {
            if (this.groundCoffee.getName().equals(newCoffee.getName())) {
                this.groundCoffee.setQuantity(this.groundCoffee.getQuantity() + newCoffee.getQuantity());
            } else {
                throw new CoffeeException("Only one kind of coffee supported for each CoffeeSelection.");
            }
        } else {
            this.groundCoffee = newCoffee;
        }
    }

    @Override
    public CoffeeDrink brewFilterCoffee() {
        MachineConfiguration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

        // brew a filter coffee
        return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, this.groundCoffee, config.getQuantityWater());
    }

    @Override
    public CoffeeDrink brewEspresso() throws CoffeeException {
        throw new CoffeeException("This machine only brews filter coffee.");
    }
}
