package common;

public class CoffeeDrink {
    public final String TYPE = "I'm coffee drink";
    private GroundCoffee coffee;
    private int quantity;
    private String label;

    public CoffeeDrink(CoffeeSelection filterCoffee, GroundCoffee groundCoffee, int quantityWater) {
        setCoffee(groundCoffee);
        setQuantity(quantityWater);
        label = filterCoffee.label;
    }

    public GroundCoffee getCoffee() {
        return coffee;
    }

    public void setCoffee(GroundCoffee coffee) {
        this.coffee = coffee;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return ""+ TYPE + " prepared with " + coffee.getName() + " using a " + label;
    }
}
