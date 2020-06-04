package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingLotTest {

    ParkingLot parkingLot;
    Car car;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(1, 10);
        car = new Car(1);
    }

    @Test
    void should_park_a_car() {
       parkingLot.parkCar(car);
       Assertions.assertEquals(1, parkingLot.getCarAmount());
    }

    @Test
    void should_pick_a_car() {
        parkingLot.parkCar(car);
        parkingLot.pickCar(car);
        Assertions.assertEquals(10, parkingLot.getEmptySize());
    }
}