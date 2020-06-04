package parking.lot;

import java.util.*;

public class ParkingManager {

    private ParkingLot parkingLot;

    private List<ParkingBoy> parkingBoys;

    public ParkingManager(ParkingLot parkingLot, List<ParkingBoy> parkingBoys) {
        this.parkingLot = parkingLot;
        this.parkingBoys = parkingBoys;
    }

    public Boolean park(Car car) {
        return this.parkingLot.parkCar(car);
    }

    public String distribute(Car car) {
        Optional<ParkingBoy> parkingBoyOp = this.parkingBoys.stream().max(Comparator.comparingInt(ParkingBoy::getCurrentEmptyLots));
        ParkingBoy parkingBoy = parkingBoyOp.get();
        return parkingBoy.parkToFirstEmptySpotParkingLot(car);
    }

    public ArrayList<String> getParkingBoyReports() {
        ArrayList<String> list = new ArrayList<>();
        this.parkingBoys.forEach(parkingBoy -> {
            list.add(parkingBoy.toString());
        });
        return list;
    }

    public String printReport() {
        return String.join(";", this.getParkingBoyReports());
    }
}
