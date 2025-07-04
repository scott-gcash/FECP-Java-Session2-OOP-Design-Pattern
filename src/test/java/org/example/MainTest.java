    package org.example;

    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.*;

    class MainTest {
//   Main
        private Ride bookRide;

        @BeforeEach
        void setup(){
            bookRide = new Ride("Standard", 10, 120);
        }

        @Test
        void shouldReturnCorrectSum(){
            String actualVehicleType = bookRide.getVehicleType();
            double actualDistance = bookRide.getDistance();
            int actualDuration = bookRide.getTimeMinutes();
            assertEquals("Standard", actualVehicleType);
            assertEquals(10, actualDistance);
            assertEquals(120, actualDuration);
        }
    }