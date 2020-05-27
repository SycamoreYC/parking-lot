package parking.lot;

import java.util.*;

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

    ArrayList<String> getParkingBoyReports() {
        ArrayList<String> list = new ArrayList<>();
        this.parkingBoys.forEach(parkingBoy -> {
            list.add(parkingBoy.toString());
        });
        return list;
    }

    String printReport() {
        return String.join(";", this.getParkingBoyReports());
    }
}
