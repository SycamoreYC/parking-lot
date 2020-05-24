package parking.lot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondaryParkingBoy {

    ParkingLot parkingLot;

    List<ParkingBoy> parkingBoys;

    public SecondaryParkingBoy(ParkingLot parkingLot, List<ParkingBoy> parkingBoys) {
        this.parkingLot = parkingLot;
        this.parkingBoys = parkingBoys;
    }

    Boolean park(Car car) {
        return this.parkingLot.park(car);
    }

    String distribute(Car car) {
        Optional<ParkingBoy> parkingBoyOp = this.parkingBoys.stream().max(Comparator.comparingInt(ParkingBoy::getCurrentEmptyLots));
        ParkingBoy parkingBoy = parkingBoyOp.get();
        return parkingBoy.setCar(car);
    }


}
