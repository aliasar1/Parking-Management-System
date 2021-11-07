package com.company;

public class Truck extends Vehicle {

    private long startTime;

    public Truck(int id) {
        super(id, 2);
        startTime = System.currentTimeMillis();
    }

    @Override
    public double getCostFactor() {
        return 20;
    }

    @Override
    public long calculateParkingDuration() {
        return ((System.currentTimeMillis() - startTime) / 1000) / 60;
    }

    @Override
    public double getCost(long duration, double costFactor) {
        return costFactor * duration;
    }

}