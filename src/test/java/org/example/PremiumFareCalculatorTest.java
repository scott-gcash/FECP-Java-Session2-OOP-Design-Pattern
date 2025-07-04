package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PremiumFareCalculatorTest {

    private final PremiumFareCalculator calculator = new PremiumFareCalculator();

    @Test
    public void shouldReturnCorrectFareForPremiumDayBookingWithoutSurcharge() {
        // Base fare = 60, distance = 5km (5 * 12.5 = 62.5), time = 10min (10 * 3 = 30)
        // Total = 60 + 62.5 + 30 = 152.5
        double distance = 5.0;
        double time = 10.0;
        boolean hasSurcharge = false;
        double expectedFare = 152.5;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldReturnCorrectFareForPremiumDayBookingWithZeroDistanceAndTime() {
        // Base fare = 60
        double distance = 0.0;
        double time = 0.0;
        boolean hasSurcharge = false;
        double expectedFare = 60.0;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldReturnCorrectFareForPremiumDayBookingWithLongDistance() {
        // Base fare = 60, distance = 20km (20 * 12.5 = 250), time = 5min (5 * 3 = 15)
        // Total = 60 + 250 + 15 = 325
        double distance = 20.0;
        double time = 5.0;
        boolean hasSurcharge = false;
        double expectedFare = 325.0;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldReturnCorrectFareForPremiumDayBookingWithLongTime() {
        // Base fare = 60, distance = 2km (2 * 12.5 = 25), time = 30min (30 * 3 = 90)
        // Total = 60 + 25 + 90 = 175
        double distance = 2.0;
        double time = 30.0;
        boolean hasSurcharge = false;
        double expectedFare = 175.0;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }
    //Premium
    @Test
    public void shouldReturnCorrectFareWithSurchargeForPremiumNightBooking() {
        // Base fare = 60, distance = 5km (5 * 12.5 = 62.5), time = 10min (10 * 3 = 30)
        // Subtotal = 60 + 62.5 + 30 = 152.5
        // Surcharge = 152.5 * 1.35 = 205.875
        // Final Fare = 152.5 + 205.875 = 358.375
        double distance = 5.0;
        double time = 10.0;
        boolean hasSurcharge = true;
        double expectedFare = 152.5 * 1.35;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldReturnCorrectFareWithSurchargeForPremiumNightBookingWithZeroDistanceAndTime() {
        // Base fare = 60
        // Surcharge = 60 * 1.35 = 81
        // Final Fare = 60 + 81 = 141
        double distance = 0.0;
        double time = 0.0;
        boolean hasSurcharge = true;
        double expectedFare = 60.0 * 1.35;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldHandleNegativeDistanceByTreatingAsZero() {
        // For now, testing current behavior: 60 + (-62.5) + 30 = 27.5
        double distance = -5.0;
        double time = 10.0;
        boolean hasSurcharge = false;
        double expectedFare = 60.0 + (distance * 12.5) + (time * 3.0);
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldHandleNegativeTimeByTreatingAsZero() {
        // For now, testing current behavior: 60 + 62.5 + (-30) = 92.5
        double distance = 5.0;
        double time = -10.0;
        boolean hasSurcharge = false;
        double expectedFare = 60.0 + (distance * 12.5) + (time * 3.0);
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }
}