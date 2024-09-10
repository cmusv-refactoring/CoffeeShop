package configuration;

public class MachineConfiguration {
    private int time;
    private int waterQuantity;

    public MachineConfiguration(int time, int waterQuantity) {
        this.time = time;
        this.waterQuantity = waterQuantity;
    }

    public int getQuantityWater() {
        return waterQuantity;
    }
}
