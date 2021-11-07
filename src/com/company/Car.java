package com.company;

import java.time.Duration;

public class Car extends Vehicle {
    private long startTime;

    public Car(int plate) {
        super(plate, 1);
        startTime = System.currentTimeMillis();
    }

    @Override
    public double getCostFactor() {
        return 10;
    }

    @Override
    public long calculateParkingDuration() {
        Duration d = Duration.ofMillis((System.currentTimeMillis() - startTime));

        return d.toMinutes();
    }

    @Override
    public double getCost(long duration, double costFactor) {
        return costFactor * duration;
    }

}
