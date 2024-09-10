import common.GroundCoffee;
import configuration.CoffeeException;
import machine.BasicCoffeeMachine;
import machine.CoffeeMachine;
import machine.EspressoMachine;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws CoffeeException {
        System.out.println("Please, select the coffee you want:");
        System.out.println("1. Filter Coffee");
        System.out.println("2. Espresso");

        String choice = scanner.nextLine();

        CoffeeMachine machine;
        GroundCoffee coffee = new GroundCoffee();

        switch (choice) {
            case "1" -> {
                machine = new BasicCoffeeMachine(coffee);
                machine.brewFilterCoffee();
            }
            case "2" -> {
                machine = new EspressoMachine(coffee);
                machine.brewEspresso();
            }
            default -> throw new CoffeeException("Invalid option for Coffee Selection.");
        }

    }
}