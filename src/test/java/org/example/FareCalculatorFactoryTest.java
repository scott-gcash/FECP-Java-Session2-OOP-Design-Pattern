package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FareCalculatorFactoryTest {

    @Test
    public void shouldReturnStandardFareCalculatorForStandardVehicleType() {
        String vehicleType = "standard";

        FareCalculator calculator = FareCalculatorFactory.createCalculator(vehicleType);

        assertNotNull(calculator);
        assertTrue(calculator instanceof StandardFareCalculator);
        assertFalse(calculator instanceof PremiumFareCalculator);
    }
    // Standard Fare

    @Test
    public void shouldReturnPremiumFareCalculatorForPremiumVehicleType() {
        String vehicleType = "premium";

        FareCalculator calculator = FareCalculatorFactory.createCalculator(vehicleType);

        assertNotNull(calculator);
        assertTrue(calculator instanceof PremiumFareCalculator);
        assertFalse(calculator instanceof StandardFareCalculator);
    }

    @Test
    public void shouldReturnStandardFareCalculatorForMixedCaseStandardVehicleType() {
        String vehicleType = "StAnDaRd";

        FareCalculator calculator = FareCalculatorFactory.createCalculator(vehicleType);

        assertNotNull(calculator);
        assertTrue(calculator instanceof StandardFareCalculator);
    }

    @Test
    public void shouldReturnPremiumFareCalculatorForMixedCasePremiumVehicleType() {
        String vehicleType = "PrEmIuM";

        FareCalculator calculator = FareCalculatorFactory.createCalculator(vehicleType);

        assertNotNull(calculator);
        assertTrue(calculator instanceof PremiumFareCalculator);
    }

    @Test
    public void shouldReturnNullForUnknownVehicleType() {
        String vehicleType = "unknown";

        FareCalculator calculator = FareCalculatorFactory.createCalculator(vehicleType);

        assertNull(calculator);
    }

    @Test
    public void shouldReturnNullForEmptyVehicleType() {
        String vehicleType = "";

        FareCalculator calculator = FareCalculatorFactory.createCalculator(vehicleType);

        assertNull(calculator);
    }

    @Test
    public void shouldReturnNullForNullVehicleType() {
        String vehicleType = null;

        FareCalculator calculator = FareCalculatorFactory.createCalculator(vehicleType);

        assertNull(calculator);
    }
}