package entity.building;

import entity.seed.CropSeed;

public class Plot {
    private CropSeed seed;
    private int humidityLevel;

    public Plot() {
        this.seed = null;
    }

    public void plantSeed(CropSeed seed) {
        this.seed = seed;
        this.humidityLevel = 0;
    }

    public void waterPlot(int amount) {
        seed.increaseHumidity(amount);
        humidityLevel += amount;
    }

    public boolean isReadyForHarvest() {
        return seed != null && seed.isReadyForHarvest();
    }

    @Override
    public String toString() {
        if (seed == null) {
            return "Empty plot";
        } else {
            return seed.toString();
        }
    }

    public CropSeed getSeed() {
        return seed;
    }

    public void setSeed(CropSeed seed) {
        this.seed = seed;
    }

    public int getHumidityLevel() {
        return humidityLevel;
    }

    public void setHumidityLevel(int humidityLevel) {
        this.humidityLevel = humidityLevel;
    }
}

