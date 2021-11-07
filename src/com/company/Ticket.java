package com.company;

import java.io.Serializable;

public class Ticket implements Serializable {
    public static int lastTicketNumber = 0;
    public int ticketNumber = 0;
    private Vehicle vehicle;

    Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.ticketNumber = lastTicketNumber;
        lastTicketNumber++;
    }

    /**
     * @return the ticketNumber
     */
    public int getTicketNumber() {
        return ticketNumber;
    }

    /**
     * @param ticketNumber the ticketNumber to set
     */
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {

        /*         return ConsoleColors.WHITE_BACKGROUND + "Vehicle (" + vehicle.getPlate() + "):\n"
        + ConsoleColors.BLACK_UNDERLINED + "VehicleType :" + ConsoleColors.YELLOW_UNDERLINED + vehicle.getClass().getSimpleName()+"\n"
        + ConsoleColors.BLACK_UNDERLINED + "Plate id :" + ConsoleColors.YELLOW_UNDERLINED + vehicle.getPlate()+"\n"
        + ConsoleColors.BLACK_UNDERLINED + "Spaces Needed :" + ConsoleColors.YELLOW_UNDERLINED + vehicle.getSpacesNeeded()+"\n"
        + ConsoleColors.BLACK_UNDERLINED + "Cost Factor :" + ConsoleColors.YELLOW_UNDERLINED + vehicle.getCostFactor()+"\n"
        + ConsoleColors.BLACK_UNDERLINED + "Ticket number :" + ConsoleColors.YELLOW_UNDERLINED + getTicketNumber()+"\n"
        + ConsoleColors.BLACK_UNDERLINED + "Duration :" + ConsoleColors.YELLOW_UNDERLINED
        +vehicle.calculateParkingDuration()+" minutes\n" + ConsoleColors.BLACK_UNDERLINED + "Total Cost :"
        + ConsoleColors.YELLOW_UNDERLINED + " Rs. "+vehicle.getCost(vehicle.calculateParkingDuration(), vehicle.getCostFactor()) + ConsoleColors.RESET;
         */
        return String.format(
                ConsoleColors.WHITE_BACKGROUND_BRIGHT + "Vehicle (" + vehicle.getPlate() + "):" + ConsoleColors.RESET
                        + "\n" + ConsoleColors.WHITE_BRIGHT + "VehicleType :" + ConsoleColors.YELLOW_UNDERLINED
                        + " %s\n" + ConsoleColors.WHITE_BRIGHT + "Plate id :" + ConsoleColors.YELLOW_UNDERLINED
                        + " %d\n" + ConsoleColors.WHITE_BRIGHT + "Spaces Needed :" + ConsoleColors.YELLOW_UNDERLINED
                        + " %d\n" + ConsoleColors.WHITE_BRIGHT + "Cost Factor :" + ConsoleColors.YELLOW_UNDERLINED
                        + " %.2f\n" + ConsoleColors.WHITE_BRIGHT + "Ticket number :" + ConsoleColors.YELLOW_UNDERLINED
                        + " %d\n" + ConsoleColors.WHITE_BRIGHT + "Duration :" + ConsoleColors.YELLOW_UNDERLINED
                        + " %d minutes\n" + ConsoleColors.WHITE_BRIGHT + "Total Cost :"
                        + ConsoleColors.YELLOW_UNDERLINED + " Rs. %.2f" + ConsoleColors.RESET,
                vehicle.getClass().getSimpleName(), vehicle.getPlate(), vehicle.getSpacesNeeded(),
                vehicle.getCostFactor(), getTicketNumber(), vehicle.calculateParkingDuration(),
                vehicle.getCost(vehicle.calculateParkingDuration(), vehicle.getCostFactor()));
    }
}
