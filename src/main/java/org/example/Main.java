package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        String vehicleType = "Standard";
        double distance = 0.0;
        int timeMinutes = 0;
        boolean hasSurcharge;

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
                bookRide = new Ride(vehicleType, distance, timeMinutes);
            } else if (choice == 2) {
                //calculateFareFunction
                //System.out.print("Fare Type (normal/night): ");

                System.out.print("Fare Type (normal/night): ");
                String fareType = scanner.next();

                hasSurcharge = fareType.equalsIgnoreCase("night");
                bookRide.setHasSurcharge(hasSurcharge);

                calculator = FareCalculatorFactory.createCalculator(bookRide.getVehicleType());
                double totalFare = calculator.calculateFare(bookRide.getDistance(),bookRide.getTimeMinutes(),bookRide.isHasSurcharge());

                FareBreakdown breakdown = (FareBreakdown) calculator;

                System.out.printf("Base fare: %.2f\n", breakdown.getBaseFare());
                System.out.printf("Distance cost: %.2f\n", breakdown.getDistanceCost());
                System.out.printf("Duration cost: %.2f\n", breakdown.getDurationCost());
                System.out.printf("Surcharge: %.2f\n", breakdown.getSurcharge());

                System.out.println("Total Fare: ".concat(Double.toString(totalFare)));

                /*if (fareType.equalsIgnoreCase("normal")){
                    //StandardFareCalculator
                } else if (fareType.equalsIgnoreCase("night")){
                    //SurchargeCalculate
                }*/
            } else if (choice == 3) {
                //displayFunction
                System.out.println("--- Receipt ---");
                System.out.println("Ride Type: ".concat(bookRide.getVehicleType()));
                System.out.println("Distance: ".concat(Double.toString(bookRide.getDistance())).concat(" km"));
                System.out.println("Duration: ".concat(Integer.toString(bookRide.getTimeMinutes())).concat(" mins"));
                calculator = FareCalculatorFactory.createCalculator(bookRide.getVehicleType());
                double totalFare = calculator.calculateFare(bookRide.getDistance(),bookRide.getTimeMinutes(),bookRide.isHasSurcharge());

                System.out.println("Total Fare: ".concat(Double.toString(totalFare)));
            } else if (choice == 4) {
                System.out.println("Thank you for using our service!");
                break;
            }
        }


    }
}