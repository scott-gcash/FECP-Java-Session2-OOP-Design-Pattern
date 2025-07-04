package org.example;

public class StandardFareCalculator implements FareCalculator, FareBreakdown {
    private final double baseFare = 45;
    private double distanceCost;
    private double durationCost;
    private double surcharge;

    @Override
    public double calculateFare(double distance, double time, boolean hasSurcharge){
        distanceCost = distance * 10;
        durationCost = time * 2;
        double fare = baseFare + distanceCost + durationCost;

        surcharge = hasSurcharge ?  (fare * .35) : 0;

        return fare + surcharge;
    }


    @Override
    public double getBaseFare() {
        return this.baseFare;
    }

    @Override
    public double getDistanceCost() {
        return this.distanceCost;
    }

    @Override
    public double getDurationCost() {
        return this.durationCost;
    }

    @Override
    public double getSurcharge() {
        return this.surcharge;
    }
}
