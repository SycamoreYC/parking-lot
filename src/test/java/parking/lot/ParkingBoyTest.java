package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ParkingBoyTest {

    ParkingBoy parkingBoy;

    @BeforeEach
    void setUp() {
        ParkingLot parkingLot1 = new ParkingLot(1, 10);
        ParkingLot parkingLot2 = new ParkingLot(2, 10);
        Car car1 = new Car(1);
        parkingLot1.park(car1);
        parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
    }

    @Test
    void should_park_a_car() {
        String result = parkingBoy.setCar(new Car(2));
        Assertions.assertEquals("ParkingLotId: 2", result);
    }

    @Test
    void should_park_a_car_in_the_emptiest_parking_lot() {
        String result = parkingBoy.setCar(new Car(2));
        Assertions.assertEquals("ParkingLotId: 2", result);
    }
}