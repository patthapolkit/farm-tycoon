package entity.builing;

import entity.seed.Seed;

public class FlowerPlot {
    private Seed seed;

    public FlowerPlot(Seed seed) {
        this.seed = seed;
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }
}
