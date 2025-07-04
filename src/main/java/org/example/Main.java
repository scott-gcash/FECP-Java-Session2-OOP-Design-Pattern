package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        String vehicleType = "Standard";
        double distance = 0.0;
        int timeMinutes = 0;
        Ride bookRide = new Ride(vehicleType, distance, timeMinutes);

        System.out.println("=== Ride Booking System ===");
        System.out.println("1. Book a Ride");
        System.out.println("2. Calculate Fare");
        System.out.println("3. View Receipt");
        System.out.println("4. Exit");

        while(choice != 4) {
            System.out.print("Enter choice (1-4): ");
            choice = scanner.nextInt();

            if (choice == 1) {
                //bookRideFunction
                System.out.print("Enter Ride Type (Standard/Premium): ");
                vehicleType = scanner.next();
                System.out.print("Enter Distance (km): ");
                distance = scanner.nextDouble();
                System.out.print("Enter Duration (mins): ");
                timeMinutes = scanner.nextInt();
                bookRide = new Ride(vehicleType, distance, timeMinutes);
            } else if (choice == 2) {
                //calculateFareFunction
                System.out.print("Fare Type (normal/night): ");
                String fareType = scanner.next();
                if (fareType.equalsIgnoreCase("normal")){
                    //StandardCalculate
                } else if (fareType.equalsIgnoreCase("night")){
                    //SurchargeCalculate
                }
            } else if (choice == 3) {
                //displayFunction
                System.out.println("--- Receipt ---");
                System.out.println("Ride Type: ".concat(bookRide.getVehicleType()));
                System.out.println("Distance: ".concat(Double.toString(bookRide.getDistance())).concat(" km"));
                System.out.println("Duration: ".concat(Integer.toString(bookRide.getTimeMinutes())).concat(" mins"));
                //System.out.println("Total Fare: ".concat(Double.toString(fare)));
            } else if (choice == 4) {
                System.out.println("Thank you for using our service!");
                break;
            }
        }


    }
}