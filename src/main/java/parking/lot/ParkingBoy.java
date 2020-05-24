package parking.lot;

import java.util.Comparator;
import java.util.List;

public class ParkingBoy {

    List<ParkingLot> parkingLots;
    String parkingBoyName;

    public ParkingBoy(List<ParkingLot> parkingLots, String parkingBoyName) {
        this.parkingLots = parkingLots;
        this.parkingBoyName = parkingBoyName;
    }

    Integer getCurrentEmptyLots() {
        return this.parkingLots.stream().mapToInt(ParkingLot::getEmptySize).sum();
    }

    String setCar(Car car) {
        this.parkingLots.sort(Comparator.comparingInt(ParkingLot::getSize));
        this.parkingLots.get(0).park(car);
        return String.format("ParkingLotId: %s", this.parkingLots.get(0).getParkingLotId());
    }

    String setCarByEmptyRate(Car car) {
        this.parkingLots.sort(Comparator.comparingDouble(ParkingLot::usageRate));
        this.parkingLots.get(0).park(car);
        return String.format("ParkingLotId: %s", this.parkingLots.get(0).getParkingLotId());
    }
}
