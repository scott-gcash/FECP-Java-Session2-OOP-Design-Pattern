package org.example;

public class FareCalculatorFactory {
    public static FareCalculator createCalculator(String vehicleType){
        if (vehicleType.equalsIgnoreCase("standard"))
            return new StandardFareCalculator();
        else if (vehicleType.equalsIgnoreCase("premium"))
            return new PremiumFareCalculator();
        else
            return null;
    }
}
