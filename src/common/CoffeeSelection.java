package common;

public enum CoffeeSelection {
    FILTER_COFFEE("Normal Filter for a filter coffee machine."),
    ESPRESSO("Special Filter for espresso machine.");

    public final String label;

    CoffeeSelection(String label) {
        this.label = label;
    }
}
