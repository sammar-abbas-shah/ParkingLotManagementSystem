package myPackage;

import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot lot = new ParkingLot(5);

        while (true) {
            System.out.println("\n=== PARKING SYSTEM ===");
            System.out.println("1. Park a vehicle");
            System.out.println("2. Remove vehicle & collect fee");
            System.out.println("3. View all spots");
            System.out.println("4. View earnings");
            System.out.println("5. Search vehicle");
            System.out.println("6. View vehicle stats");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter license plate: ");
                    String plate = scanner.nextLine().toUpperCase();

                    if (!Vehicle.isValidPlate(plate)) {
                        System.out.println("Invalid plate! Must be 6-10 characters with letters and numbers only.");
                        break;
                    }

                   
                    if (lot.isPlateAlreadyParked(plate)) {
                        System.out.println("Vehicle already parked! Duplicate plate not allowed.");
                        break;
                    }

                    System.out.print("Enter vehicle type (Car/Bike/Truck): ");
                    String type = scanner.nextLine();

                   
                    if (!Vehicle.isValidType(type)) {
                        System.out.println("Invalid type! Only Car, Bike, or Truck allowed.");
                        break;
                    }

                    Vehicle v = new Vehicle(plate, type);
                    lot.parkVehicle(v);
                    break;

                case 2:
                    System.out.print("Enter spot number to remove: ");
                    int spot = scanner.nextInt();
                    lot.removeVehicle(spot);
                    break;

                case 3:
                    lot.displayAllSpots();
                    break;

                case 4:
                    System.out.println("Total Earnings: Rs." + lot.getTotalEarnings());
                    break;

                case 5:
                    System.out.print("Enter license plate to search: ");
                    String searchPlate = scanner.nextLine().toUpperCase();
                    lot.searchVehicle(searchPlate);
                    break;

                case 6:
                    lot.showVehicleStats();
                    break;

                case 7:
                    System.out.println("Total Earnings: Rs." + lot.getTotalEarnings());
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}