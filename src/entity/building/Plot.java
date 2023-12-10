package entity.building;

import entity.seed.Seed;

public class Plot {
    private Seed seed;

    public Plot(Seed seed) {
        this.seed = seed;
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }
}
