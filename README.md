# CoffeeShop

This example illustrates an **Interface Segregation Principle (ISP)** violation and how to remove it through refactoring.

The initial design defines a single `CoffeeMachine` abstraction that requires different types of coffee machines to support operations they may not actually need. We will refactor this abstraction into smaller, more specialized interfaces.

## Refactoring to Remove the ISP Violation

### Step 1 — Extract the First Interface

Use the IDE to refactor the existing `CoffeeMachine` class:

1. Select **Refactor → Extract Interface**.

2. Select **Rename original class and use interface where possible**.

3. Rename the original class to:

   `FilterCoffeeMachine`

4. Select the `addGroundCoffee` method for the new `CoffeeMachine` interface.

At this point, the original implementation becomes `FilterCoffeeMachine`, while `CoffeeMachine` represents the initial abstraction.

---

### Step 2 — Organize the Interfaces

Create a package called:

`contract`

Move the interfaces into this package.

This separates the system's abstractions from their concrete implementations.

---

### Step 3 — Segregate the Coffee Machine Interfaces

The current `CoffeeMachine` abstraction still contains functionality that is not required by every type of coffee machine.

Extract a second, more specialized interface:

1. Select **Refactor → Extract Interface**.

2. Name the new interface:

   `EspressoCoffeeMachine`

3. Select the `brewEspresso` method.

4. Make `EspressoCoffeeMachine` extend the appropriate common coffee machine abstraction.

After this step, filter-coffee and espresso-specific operations should belong to separate interfaces.

The goal is that clients and implementations depend **only on the operations they actually need**.

---

### Step 4 — Fix the Concrete Coffee Machines

Update the concrete classes so that each class implements only the appropriate interface.

#### `BasicCoffeeMachine`

* Make sure it implements the filter-coffee abstraction.
* Remove any espresso-specific methods that are no longer required.

#### `EspressoMachine`

* Make sure it implements `EspressoCoffeeMachine`.
* Remove any filter-coffee-specific methods that are no longer required.

After this refactoring, a concrete coffee machine should no longer be forced to implement operations that it does not support.

---

## Step 5 — Check the Liskov Substitution Principle

Removing the ISP violation may expose another design problem.

Review the resulting inheritance and interface relationships and ask:

> Can every implementation be safely used wherever its abstraction is expected without changing the expected behavior of the system?

If the answer is **no**, the design may violate the **Liskov Substitution Principle (LSP)**.

Refactor the abstractions so that each implementation can correctly satisfy the contract of the interface it implements.
