package myPackage;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<ParkingSpot> spots;
    private int totalSpots;
    private double totalEarnings;

    public ParkingLot(int totalSpots) {
        this.totalSpots = totalSpots;
        this.totalEarnings = 0;
        this.spots = new ArrayList<>();

        for (int i = 1; i <= totalSpots; i++) {
            spots.add(new ParkingSpot(i));
        }
    }
    public boolean isPlateAlreadyParked(String plate) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getLicensePlate().equals(plate)) {
                return true;
            }
        }
        return false;
    }

    public void parkVehicle(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                spot.parkVehicle(v);
                System.out.println("Vehicle parked at Spot " + spot.getSpotNumber());
                return;
            }
        }
        System.out.println("Parking lot is full!");
    }

    public double removeVehicle(int spotNumber) {
        double fee = 0;
        if (spotNumber > 0 && spotNumber <= spots.size()) {
            ParkingSpot spot = spots.get(spotNumber - 1);
            if (spot.isOccupied()) {
                Vehicle v = spot.getVehicle();
                v.setExitTime();  // Set exit time
                fee = v.calculateFee();
                spot.removeVehicle();
                totalEarnings += fee;
                System.out.println("Vehicle removed from Spot " + spotNumber);
                System.out.println("Vehicle Info:");
                v.display();
                System.out.println("Fee Collected: Rs." + fee);
            } else {
                System.out.println("Spot is already empty!");
            }
        } else {
            System.out.println("Invalid spot number!");
        }
        return fee;
    }

    
    public void searchVehicle(String plate) {
        System.out.println("\n=== SEARCH RESULT ===");
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getLicensePlate().equals(plate)) {
                System.out.println("Found at Spot " + spot.getSpotNumber());
                spot.getVehicle().display();
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    
    public void showVehicleStats() {
        int carCount = 0;
        int bikeCount = 0;
        int truckCount = 0;
        int total = 0;

        for (ParkingSpot spot : spots) {
            if (spot.isOccupied()) {
                total++;
                String type = spot.getVehicle().getVehicleType().toLowerCase();
                if (type.equals("car")) carCount++;
                else if (type.equals("bike")) bikeCount++;
                else if (type.equals("truck")) truckCount++;
            }
        }

        System.out.println("\n=== VEHICLE STATS ===");
        System.out.println("Total Parked: " + total);
        System.out.println("Cars: " + carCount);
        System.out.println("Bikes: " + bikeCount);
        System.out.println("Trucks: " + truckCount);
    }

    public void displayAllSpots() {
        System.out.println("\n=== PARKING LOT STATUS ===");
        System.out.println("Available Spots: " + getAvailableSpots());
        System.out.println("Total Earnings: Rs." + totalEarnings);
        System.out.println("----------------------------");
        for (ParkingSpot spot : spots) {
            spot.display();
            System.out.println("--------------------");
        }
    }

    public int getAvailableSpots() {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                count++;
            }
        }
        return count;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }
}