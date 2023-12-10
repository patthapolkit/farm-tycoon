package entity.building;

import entity.seed.Seed;

public class Plot {
    private Seed seed;

    public Plot() {
        this.seed = null;
    }

    public void plantSeed(Seed seed) {
        this.seed = seed;
    }

    public void waterPlot(int amount) {
        seed.increaseHumidity(amount);
    }

    @Override
    public String toString() {
        if (seed == null) {
            return "Empty plot";
        } else {
            return seed.toString();
        }
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }
}

