public class Coffee {
    private int waterNeeded;
    private int milkNeeded;
    private int beansNeeded;
    private int cost;

    public Coffee(int waterNeeded, int milkNeeded, int beansNeeded, int cost) {
        this.waterNeeded = waterNeeded;
        this.milkNeeded = milkNeeded;
        this.beansNeeded = beansNeeded;
        this.cost = cost;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public int getBeansNeeded() {
        return beansNeeded;
    }

    public int getCost() {
        return cost;
    }
}

