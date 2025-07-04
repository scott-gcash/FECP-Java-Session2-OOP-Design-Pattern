package org.example;

public class Ride {
    private String vehicleType;
    private double distance;
    private int timeMinutes;
    private double fare;
    private boolean hasSurcharge;

    public Ride(String vehicleType, double distance, int timeMinutes) {
        this.vehicleType = vehicleType;
        this.distance = distance;
        this.timeMinutes = timeMinutes;
    }

    public Ride(String vehicleType, double distance, int timeMinutes, boolean hasSurcharge) {
        this.vehicleType = vehicleType;
        this.distance = distance;
        this.timeMinutes = timeMinutes;
        this.hasSurcharge = hasSurcharge;
    }

    public String getVehicleType() {return vehicleType;}

    public void setVehicleType(String vehicleType) {this.vehicleType = vehicleType;}

    public double getDistance() {return distance;}

    public void setDistance(double distance) {this.distance = distance;}

    public int getTimeMinutes() {return timeMinutes;}

    public void setTimeMinutes(int timeMinutes) {this.timeMinutes = timeMinutes;}

    public double getFare() {return fare;}

    public void setFare(double fare) {this.fare = fare;}


}
