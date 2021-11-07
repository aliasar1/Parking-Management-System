package com.company;

import java.io.Serializable;

public class ParkingFloor implements Serializable {
    final int MAXSLOTS = 10;

    private ParkingSlot[] slots = new ParkingSlot[MAXSLOTS];
    private int floorNumber;

    ParkingFloor(int floorNumber) {
        createSlots();
        this.floorNumber = floorNumber;
    }

    private void createSlots() {
        for (int i = 0; i < MAXSLOTS; i++) {
            this.slots[i] = new ParkingSlot(false);
        }
    }

    /* Getters and Setters */
    public ParkingSlot getSlot(int i) {
        return slots[i];
    }

    public ParkingSlot[] getSlots() {
        return slots;
    }

    public void setSlots(ParkingSlot[] slots) {
        this.slots = slots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
