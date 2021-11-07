package com.company;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        final String PASSWORD = "admin321";

        ParkingLot parkingLot = new ParkingLot();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int option;
        try {
            while (flag) {
                System.out.println("");
                System.out.println("");
                System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT
                        + "Enter Your Selection:" + ConsoleColors.RESET);
                System.out.println("1. Slots Available\n" + "2. Get Parking\n" + "3. Print Ticket\n"
                        + "4. Leave Parking\n" + "5. Print all Tickets (Admin only)\n" + "6. Exit");
                option = scanner.nextInt();
                scanner.nextLine();
                if (option == 1) {
                    System.out.println("Slots Available: " + parkingLot.getFreeSlotCount());
                } else if (option == 2) {
                    System.out.println("Enter Plate ID:");
                    int plate = scanner.nextInt();
                    scanner.nextLine();
                    if (parkingLot.findVehicle(plate) == null) {
                        System.out.println("Enter Type\n1. Car\n2. Truck ");
                        int selected = scanner.nextInt();
                        scanner.nextLine();

                        Vehicle vehicle;
                        switch (selected) {
                            case 1:
                                vehicle = new Car(plate);
                                break;
                            case 2:
                                vehicle = new Truck(plate);
                                break;
                            default:
                                throw new Exception("Incorrect Input");
                        }
                        Ticket ticket = new Ticket(vehicle);
                        parkingLot.allocateSlot(vehicle, 0, ticket);
                        System.out.println(ticket.toString());
                    } else {
                        System.out.println("Vehicle plates should be unique");
                    }
                } else if (option == 3) {
                    System.out.println("Enter Plate: ");
                    Ticket vehTicket = parkingLot.findTicket(scanner.nextInt());
                    if (vehTicket != null) {
                        System.out.println(vehTicket);
                    } else {
                        System.out.println("\nNot Found");
                    }
                } else if (option == 4) {
                    System.out.println("Enter Plate: ");
                    Ticket vehTicket = parkingLot.findTicket(scanner.nextInt());
                    if (vehTicket != null) {
                        parkingLot.deAllocateSlot(vehTicket);
                        System.out.println("Leaving Slot...");
                        System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT
                                + "Here is your Final Ticket..." + ConsoleColors.RESET);
                        System.out.println(vehTicket);
                        System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT
                                + "GoodBye" + ConsoleColors.RESET);
                    } else {
                        System.out.println("\nNot Found");
                    }
                } else if (option == 5) {
                    System.out.println("Enter Admin Password:");
                    if (PASSWORD.equals(scanner.next())) {
                        System.out.println("Parking lot Map:");
                        parkingLot.printAllSlots();
                        System.out.println("Occupied Tickets:");
                        parkingLot.printOccupiedSlots();
                    } else {
                        throw new Exception("Incorrect Password, Exiting");
                    }
                } else if (option == 6) {
                    System.out.println("Exiting");
                    flag = false;
                }
            }
        } catch (Exception e) {
            System.out.println("Error Occured");
            System.out.println(e.getMessage());
        }
        scanner.close();
        System.out.println("Saving File...");
        parkingLot.saveFile();
    }

}
