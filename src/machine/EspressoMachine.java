package machine;

import common.BrewingUnit;
import common.CoffeeDrink;
import common.CoffeeSelection;
import common.GroundCoffee;
import configuration.CoffeeException;
import configuration.MachineConfiguration;

import java.util.EnumMap;

public class EspressoMachine implements CoffeeMachine {
    private EnumMap<CoffeeSelection, MachineConfiguration> configMap;
    private GroundCoffee groundCoffee;
    private BrewingUnit brewingUnit;

    public EspressoMachine(GroundCoffee coffee) {
        this.groundCoffee = coffee;
        this.brewingUnit = new BrewingUnit();

        this.configMap = new EnumMap<>(CoffeeSelection.class);
        this.configMap.put(CoffeeSelection.ESPRESSO, new MachineConfiguration(8, 28));
    }

    @Override
    public void addGroundCoffee(GroundCoffee newCoffee) throws CoffeeException {
        if (this.groundCoffee != null) {
            if (this.groundCoffee.getName().equals(newCoffee.getName())) {
                this.groundCoffee.setQuantity(this.groundCoffee.getQuantity() + newCoffee.getQuantity());
            } else {
                throw new CoffeeException(
                        "Only one kind of coffee supported for each CoffeeSelection.");
            }
        } else {
            this.groundCoffee = newCoffee;
        }
    }

    @Override
    public CoffeeDrink brewFilterCoffee() throws CoffeeException {
        throw new CoffeeException("This machine only brew espresso.");
    }

    @Override
    public CoffeeDrink brewEspresso() {
        MachineConfiguration config = configMap.get(CoffeeSelection.ESPRESSO);

        // brew a filter coffee
        return this.brewingUnit.brew(CoffeeSelection.ESPRESSO,
                this.groundCoffee, config.getQuantityWater());
    }
}
