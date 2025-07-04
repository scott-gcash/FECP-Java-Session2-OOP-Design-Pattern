package org.example;

public class PremiumFareCalculator implements FareCalculator {
    @Override
    public double calculateFare(double distance, double time, boolean hasSurcharge){
        double baseFare = 60;
        double fare = baseFare + distance * 12.5 + time * 3;
        if (hasSurcharge){
            fare += (fare * 1.35);
        }
        return fare;
    }
}
