package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.function.Function;

public class ParkingLot {

    private String filename = System.getProperty("user.dir") + "\\src\\parking.data";

    final int MAXFLOORS = 10;

    private ParkingFloor[] floors = new ParkingFloor[MAXFLOORS];

    public ParkingLot() {
        createFloors();
        loadFile();
    }

    public void createFloors() {
        for (int i = 0; i < MAXFLOORS; i++) {
            this.floors[i] = new ParkingFloor(i);
        }
    }

    public int getFreeSlotCount() {
        int freeSlotsCount = 0;
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                if (!floors[j].getSlots()[k].isOccupied()) {
                    freeSlotsCount++;
                }
            }
        }
        return freeSlotsCount;
    }

    public ParkingFloor[] getFloors() {
        return floors;
    }

    public void printOccupiedSlots() {
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                if (floors[j].getSlots()[k].isOccupied()) {
                    System.out.println("Slot:" + k + ", Plate:" + floors[j].getSlots()[k].getVehicle().getPlate());
                }
            }
        }
    }

    public void printAllSlots() {
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                if (floors[j].getSlots()[k].isOccupied()) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" o ");
                }
            }
            System.out.print(" \n");
        }
    }

    public void allocateSlot(Vehicle vehicle, int floorNumber, Ticket ticket) {
        for (int k = 0; k < floors[floorNumber].getSlots().length; k++) {
            if (!floors[floorNumber].getSlots()[k].isOccupied()) {
                floors[floorNumber].getSlots()[k].setOccupied(true);
                addVehicle(k, vehicle, floorNumber, ticket);
                break;
            }
        }
    }

    public void deAllocateSlot(Ticket ticket) {
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                if (floors[j].getSlots()[k].isOccupied()
                        && (floors[j].getSlots()[k].getVehicle().getPlate() == ticket.getVehicle().getPlate())) {
                    floors[j].getSlots()[k].setOccupied(false);
                    removeVehicle(k, j, ticket);
                    // we use return instead of break here because break will only break inner loop. but return will stop exection of function
                    return;
                }
            }
        }
    }

    public Vehicle findVehicle(int plate) {
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                ParkingSlot slot = floors[j].getSlot(k);
                if (slot != null) {
                    Vehicle veh = slot.getVehicle();
                    if (veh != null && veh.getPlate() == plate) {
                        return veh;
                    }
                }
            }
        }
        return null;
    }

    public Ticket findTicket(int plate) {
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                ParkingSlot slot = floors[j].getSlot(k);
                if (slot != null) {
                    Vehicle veh = slot.getVehicle();
                    if (veh != null && veh.getPlate() == plate) {
                        return slot.getTicket();
                    }
                }
            }
        }
        return null;
    }

    public void addVehicle(int slotNumber, Vehicle vehicle, int floorNumber, Ticket ticket) {
        ParkingSlot slot = floors[floorNumber].getSlot(slotNumber);
        slot.setVehicle(vehicle);
        slot.setTicket(ticket);
    }

    public void removeVehicle(int slotNumber, int floorNumber, Ticket ticket) {
        ParkingSlot slot = floors[floorNumber].getSlot(slotNumber);
        slot.setVehicle(null);
        slot.setTicket(null);
    }

    /* File Management */
    void saveFile() {
        try {
            clearFile();
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(floors);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void loadFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            floors = (ParkingFloor[]) objectInputStream.readObject();
            System.out.println(floors);
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void clearFile() {
        File file = new File(filename);
        file.delete();
    }

}
