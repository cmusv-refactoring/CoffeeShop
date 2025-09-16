# CoffeeShop
First Example of SOLID principle (ISP) violation


## Refactoring the abstraction to remove the Interface Segregation Principle
1. Use the IDE and select the option Refactor/Extract Interface
    - Select option "Rename original class and use interface where possible"
    - Rename the original class to FilterCoffeeMachine
    - Select "addGroundCoffee" method to form the interface


2. Create a package called contract and move interfaces to there


3. Refactoring operations to segregate the interfaces so that the functionalities of the different coffee machines are independent of each other
    - Select option "Extract interface"
    - Rename the interface to EspressoCoffeeMachine
    - Select "brewEspresso" method to form the interface
    - Select "implements CoffeeMachine"
    - fix the FilterCoffeeMachine to extend the same CoffeMachine interface


4. Fix concrete subcasses of CoffeeMachine
    - Make sure that BasicCoffeeMachine implements FilterCoffeeMachine
    - Remove the CoffeeDrink brewEspresso method

    - Make sure that EspressoMachine implements EspressoCoffeeMachine
    - Remove the CoffeeDrink brewEspresso method


5. After these refactorings, some classes might violate the Liskov Substituion Principle, let's fix it.