package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SecondaryParkingBoyTest {

    SecondaryParkingBoy secondaryParkingBoy;

    @BeforeEach
    void setUp() {
        ParkingLot parkingLot = new ParkingLot(1, 50);
        ParkingLot parkingLot1 = new ParkingLot(2,100);
        ParkingLot parkingLot2 = new ParkingLot(3, 70);
        ParkingLot parkingLot3 = new ParkingLot(4, 80);
        ParkingLot parkingLot4 = new ParkingLot(5, 90);
        ParkingBoy parkingBoy1 = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2), "boy1");
        ParkingBoy parkingBoy2 = new ParkingBoy(Arrays.asList(parkingLot3, parkingLot4), "boy2");
        secondaryParkingBoy = new SecondaryParkingBoy(parkingLot, Arrays.asList(parkingBoy1, parkingBoy2));
    }

    @Test
    void should_return_true_when_parking_a_car_in_the_parking_lot_of_secondaryParkingBoy() {
        Car car = new Car(1);
        Boolean result = secondaryParkingBoy.park(car);
        Assertions.assertEquals(true, result);
    }

    @Test
    void should_return_parking_lot_id_when_secondaryParkingBoy_distribute_the_car_to_a_parkingBoy() {
        Car car = new Car(1);
        String result = secondaryParkingBoy.distribute(car);
        Assertions.assertEquals("ParkingLotId: 2", result);
    }

    @Test
    void should_return_report() {
        String result = secondaryParkingBoy.printReport();
        String expected = "boy1,170,0.0,170;boy2,170,0.0,170";
        Assertions.assertEquals(expected, result);
    }
}