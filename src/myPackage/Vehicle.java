package myPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Vehicle {
    private String licensePlate;
    private String vehicleType;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Vehicle(String licensePlate, String vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
    }

  
    public static boolean isValidPlate(String plate) {
        if (plate == null || plate.length() < 6 || plate.length() > 10) {
            return false;
        }
        boolean hasLetter = false;
        boolean hasNumber = false;
        for (char c : plate.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) return false;
        }
        return hasLetter && hasNumber;
    }


    public static boolean isValidType(String type) {
        if (type == null) return false;
        String lower = type.toLowerCase();
        return lower.equals("car") || lower.equals("bike") || lower.equals("truck");
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime() {
        this.exitTime = LocalDateTime.now();
    }

    public String getFormattedEntryTime() {
        return entryTime.format(formatter);
    }

    public String getFormattedExitTime() {
        if (exitTime != null) {
            return exitTime.format(formatter);
        }
        return "Not exited";
    }

    
    public double calculateFee() {
        double rate = 0;
        switch (vehicleType.toLowerCase()) {
            case "car": rate = 50; break;
            case "bike": rate = 20; break;
            case "truck": rate = 100; break;
        }
        return rate;
    }

    public void display() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Entry Time: " + getFormattedEntryTime());
        System.out.println("Exit Time: " + getFormattedExitTime());
        System.out.println("Parking Fee: Rs." + calculateFee());
    }
}