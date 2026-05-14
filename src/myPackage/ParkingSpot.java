package myPackage;

public class ParkingSpot {
    private int spotNumber;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.occupied = false;
        this.vehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle v) {
        this.vehicle = v;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }

    public void display() {
        if (occupied) {
            System.out.println("Spot " + spotNumber + " - OCCUPIED");
            vehicle.display();
        } else {
            System.out.println("Spot " + spotNumber + " - EMPTY");
        }
    }
}