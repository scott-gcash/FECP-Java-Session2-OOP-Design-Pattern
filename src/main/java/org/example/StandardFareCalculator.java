package org.example;

public class StandardFareCalculator implements FareCalculator {
    @Override
    public double calculateFare(double distance, double time, boolean hasSurcharge){
        double baseFare = 45;
        double fare = baseFare + distance * 10 + time * 2;
        if (hasSurcharge){
            fare = (fare * 1.35);
        }

        return fare;
    }
}
