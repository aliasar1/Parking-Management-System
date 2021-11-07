package com.company;

import java.io.Serializable;

public abstract class Vehicle implements Serializable, hasCost {

    private int plate;
    private int spacesNeeded;

    public Vehicle(int plate, int spacesNeeded) {
        this.plate = plate;
        this.spacesNeeded = spacesNeeded;
    }

    public int getPlate() {
        return this.plate;
    }

    public int getSpacesNeeded() {
        return spacesNeeded;
    }

    public void setSpacesNeeded(int spacesNeeded) {
        this.spacesNeeded = spacesNeeded;
    }

    public abstract long calculateParkingDuration();

}
