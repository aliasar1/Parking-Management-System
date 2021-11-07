package com.company;

import java.io.Serializable;

public class ParkingSlot implements Serializable {
    private Vehicle vehicle;
    private Ticket ticket;
    private boolean occupied;

    ParkingSlot(boolean occupied) {
        this.occupied = occupied;
    }

    /* Getters and Setters */
    
    /**
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
