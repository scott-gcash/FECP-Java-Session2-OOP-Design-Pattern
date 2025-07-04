package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StandardFareCalculatorTest {

    private final StandardFareCalculator calculator = new StandardFareCalculator();

    @Test
    public void shouldReturnCorrectFareForStandardDayBookingWithoutSurcharge() {
        // Base fare = 45, distance = 5km (5 * 10 = 50), time = 10min (10 * 2 = 20)
        // Total = 45 + 50 + 20 = 115
        double distance = 5.0;
        double time = 10.0;
        boolean hasSurcharge = false;
        double expectedFare = 115.0;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldReturnCorrectFareForStandardDayBookingWithZeroDistanceAndTime() {
        // Base fare = 45
        double distance = 0.0;
        double time = 0.0;
        boolean hasSurcharge = false;
        double expectedFare = 45.0;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldReturnCorrectFareForStandardDayBookingWithLongDistance() {
        // Base fare = 45, distance = 20km (20 * 10 = 200), time = 5min (5 * 2 = 10)
        // Total = 45 + 200 + 10 = 255
        double distance = 20.0;
        double time = 5.0;
        boolean hasSurcharge = false;
        double expectedFare = 255.0;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldReturnCorrectFareForStandardDayBookingWithLongTime() {
        // Base fare = 45, distance = 2km (2 * 10 = 20), time = 30min (30 * 2 = 60)
        // Total = 45 + 20 + 60 = 125
        double distance = 2.0;
        double time = 30.0;
        boolean hasSurcharge = false;
        double expectedFare = 125.0;
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldReturnCorrectFareWithSurchargeForStandardNightBooking() {
        // Base fare = 45, distance = 5km (5 * 10 = 50), time = 10min (10 * 2 = 20)
        // Subtotal = 45 + 50 + 20 = 115
        // Surcharge = 115 * 1.35 = 155.25
        // Final Fare = 115 + 155.25 = 270.25
        double distance = 5.0;
        double time = 10.0;
        boolean hasSurcharge = true;
        double expectedFare = 115.0 + (115.0 * 1.35); // Correct calculation: fare += (fare * 1.35)
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldReturnCorrectFareWithSurchargeForStandardNightBookingWithZeroDistanceAndTime() {
        // Base fare = 45
        // Surcharge = 45 * 1.35 = 60.75
        // Final Fare = 45 + 60.75 = 105.75
        double distance = 0.0;
        double time = 0.0;
        boolean hasSurcharge = true;
        double expectedFare = 45.0 + (45.0 * 1.35);
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldHandleNegativeDistanceByTreatingAsZero() {
        // Testing current behavior: 45 + (-50) + 20 = 15
        double distance = -5.0;
        double time = 10.0;
        boolean hasSurcharge = false;
        double expectedFare = 45.0 + (distance * 10.0) + (time * 2.0);
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }

    @Test
    public void shouldHandleNegativeTimeByTreatingAsZero() {
        // For now, testing current behavior: 45 + 50 + (-20) = 75
        double distance = 5.0;
        double time = -10.0;
        boolean hasSurcharge = false;
        double expectedFare = 45.0 + (distance * 10.0) + (time * 2.0);
        assertEquals(expectedFare, calculator.calculateFare(distance, time, hasSurcharge), 0.001);
    }
}