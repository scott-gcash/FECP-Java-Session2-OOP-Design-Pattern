package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        String vehicleType = "";
        double distance = 0.0;
        int timeMinutes = 0;
        boolean hasSurcharge;
        String fareType = "";

        FareCalculator calculator;

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

                //Error Checking
                boolean isValidRideType = vehicleType.equalsIgnoreCase("standard")
                        || vehicleType.equalsIgnoreCase("premium");
                boolean isValidDistance = distance > 0;
                boolean isValidDuration = timeMinutes > 0;

                if ((isValidRideType) && (isValidDistance) && (isValidDuration)){
                    bookRide = new Ride(vehicleType,distance,timeMinutes);
                } else {
                    System.out.println("One of the inputs are invalid. Enter valid input.");
                }

            } else if (choice == 2) {
                //CalculateFareFunction
                if(bookRide.getVehicleType().equalsIgnoreCase("")){ //Error Checker
                    System.out.println("No ride booked. Please book a ride first.");
                } else {
                    System.out.print("Fare Type (normal/night): ");
                    fareType = scanner.next();

                    hasSurcharge = fareType.equalsIgnoreCase("night");
                    bookRide.setHasSurcharge(hasSurcharge);

                    System.out.print("Base fare: ");
                    System.out.print("Distance cost: ");
                    System.out.println("Surcharge: ".concat("(").concat(fareType).concat(") : "));

                    calculator = FareCalculatorFactory.createCalculator(bookRide.getVehicleType());
                    double totalFare = calculator.calculateFare(bookRide.getDistance(), bookRide.getTimeMinutes(), bookRide.isHasSurcharge());

                    System.out.println("Total Fare: ".concat(Double.toString(totalFare)));
                }

            } else if (choice == 3) {
                //displayFunction
                if(fareType.equalsIgnoreCase("")){ //Error Checker
                    System.out.println("No ride booked. Please book a ride first.");
                } else {
                    System.out.println("--- Receipt ---");
                    System.out.println("Ride Type: ".concat(bookRide.getVehicleType()));
                    System.out.println("Distance: ".concat(Double.toString(bookRide.getDistance())).concat(" km"));
                    System.out.println("Duration: ".concat(Integer.toString(bookRide.getTimeMinutes())).concat(" mins"));
                    calculator = FareCalculatorFactory.createCalculator(bookRide.getVehicleType());
                    double totalFare = calculator.calculateFare(bookRide.getDistance(), bookRide.getTimeMinutes(), bookRide.isHasSurcharge());

                    System.out.println("Total Fare: ".concat(Double.toString(totalFare)));
                }

            } else if (choice == 4) {
                System.out.println("Thank you for using our service!");
                break;
            }
        }
    }
}