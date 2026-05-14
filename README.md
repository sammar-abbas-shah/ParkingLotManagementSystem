# 🅿️ Parking Lot Management System

A **Java-based** console application that simulates real-world parking lot operations — including vehicle entry/exit tracking, slot management, fee collection, and vehicle statistics.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Fee Structure](#fee-structure)
- [How It Works](#how-it-works)
- [Sample Output](#sample-output)
- [Author](#author)

---

## 📌 Overview

The Parking Lot Management System allows a parking attendant to manage a lot with a fixed number of spots (default: 5). Vehicles can be parked, searched, and removed — with fees automatically collected on exit. The system prevents duplicate entries and validates both license plates and vehicle types before parking.

---

## ✨ Features

| Feature | Description |
|---|---|
| 🚗 Park a Vehicle | Assigns the first available spot; records entry time automatically |
| 🚙 Remove a Vehicle | Frees the spot and calculates the parking fee |
| 🔍 Search by Plate | Locate any parked vehicle by its license plate number |
| 📋 View All Spots | Displays real-time status of every spot (occupied/empty) |
| 📊 Vehicle Stats | Breakdown of parked vehicles by type (Car / Bike / Truck) |
| 💰 Earnings Tracker | Tracks total revenue collected across all exits |
| 🚫 Duplicate Prevention | Blocks re-entry of an already-parked license plate |
| ✅ Input Validation | Validates plate format and vehicle type |

---

## 🛠️ Technologies Used

- **Java** (Core language)
- **OOP** — Encapsulation across 4 classes
- **Java Collections** — `ArrayList` for spot management
- **`java.time`** — `LocalDateTime` for entry/exit timestamps
- **`java.util.Scanner`** — Console-based user input

---

## 📁 Project Structure

```
ParkingLotManagementSystem/
│
├── src/
│   └── myPackage/
│       ├── ParkingSystem.java    # Main entry point — menu loop & user input
│       ├── ParkingLot.java       # Core lot logic — park, remove, search, stats
│       ├── ParkingSpot.java      # Individual spot model (number, occupancy, vehicle)
│       └── Vehicle.java          # Vehicle model — plate, type, times, fee calc
│
└── .gitignore
```

---

## 🚀 Getting Started

### Prerequisites

- **Java JDK 8** or higher

### Run Locally

1. **Clone the repository:**
   ```bash
   git clone https://github.com/sammar-abbas-shah/ParkingLotManagementSystem.git
   cd ParkingLotManagementSystem
   ```

2. **Compile:**
   ```bash
   javac -d out src/myPackage/*.java
   ```

3. **Run:**
   ```bash
   java -cp out myPackage.ParkingSystem
   ```

---

## 💰 Fee Structure

Fees are flat-rate per vehicle type, collected on exit:

| Vehicle Type | Fee |
|---|---|
| 🚗 Car | Rs. 50 |
| 🏍️ Bike | Rs. 20 |
| 🚛 Truck | Rs. 100 |

---

## ⚙️ How It Works

1. The lot is initialized with **5 parking spots** on startup.
2. On vehicle entry, the system:
   - Validates the license plate (6–10 alphanumeric characters, must contain both letters and digits)
   - Validates the vehicle type (`Car`, `Bike`, or `Truck`)
   - Checks for duplicate plates already in the lot
   - Records the **entry timestamp** (`LocalDateTime.now()`)
   - Assigns the **first available spot**
3. On vehicle exit, the system:
   - Records the **exit timestamp**
   - Displays vehicle info (plate, type, entry/exit times, fee)
   - Adds the fee to total earnings and frees the spot

---

## 🖥️ Sample Output

```
=== PARKING SYSTEM ===
1. Park a vehicle
2. Remove vehicle & collect fee
3. View all spots
4. View earnings
5. Search vehicle
6. View vehicle stats
7. Exit
Choose option: 1

Enter license plate: ABC123
Enter vehicle type (Car/Bike/Truck): Car
Vehicle parked at Spot 1

Choose option: 2
Enter spot number to remove: 1
Vehicle removed from Spot 1
Vehicle Info:
License Plate: ABC123
Vehicle Type: Car
Entry Time: 2025-01-15 10:30:00
Exit Time:   2025-01-15 11:45:00
Parking Fee: Rs.50.0
Fee Collected: Rs.50.0
```

---

## 👩‍💻 Author
**Sammar Abbas Shah**
- GitHub: [@sammar-abbas-shah](https://github.com/sammar-abbas-shah)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
