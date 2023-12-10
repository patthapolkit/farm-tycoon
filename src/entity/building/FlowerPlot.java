package entity.building;

import entity.seed.FlowerSeed;

public class FlowerPlot {
    private FlowerSeed seed;

    public FlowerPlot() {
        this.seed = null;
    }

    public void plantFlower(FlowerSeed seed) {
        this.seed = seed;
    }

    public boolean isReadyForHarvest() {
        return seed != null && seed.isReadyForHarvest();
    }

    @Override
    public String toString() {
        if (seed == null) {
            return "Empty flower plot";
        } else {
            return seed.toString();
        }
    }

    public FlowerSeed getSeed() {
        return seed;
    }

    public void setSeed(FlowerSeed seed) {
        this.seed = seed;
    }
}
