package parking.lot;

import java.util.Comparator;
import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;
    private String parkingBoyName;

    public ParkingBoy(List<ParkingLot> parkingLots, String parkingBoyName) {
        this.parkingLots = parkingLots;
        this.parkingBoyName = parkingBoyName;
    }

    public String parkToFirstEmptySpotParkingLot(Car car) {
        ParkingLot parkingLot = getFirstEmptySpotParkingLot();
        parkingLot.parkCar(car);
        return String.format("ParkingLotId: %s", parkingLot.getParkingLotId());
    }

    private ParkingLot getFirstEmptySpotParkingLot() {
        return parkingLots.stream().filter(parkingLot -> !parkingLot.isFull()).findFirst().get();
    }

    public String parkToEmptiestParkingLot(Car car) {
        ParkingLot parkingLot = getEmptiestParkingLot();
        parkingLot.parkCar(car);
        return String.format("ParkingLotId: %s", parkingLot.getParkingLotId());
    }

    private ParkingLot getEmptiestParkingLot() {
        parkingLots.sort(Comparator.comparingInt(ParkingLot::getEmptySize));
        return parkingLots.get(parkingLots.size() - 1);
    }

    public String parkToHighestEmptyRateCarPark(Car car) {
        ParkingLot parkingLot = this.getHighestEmptyRateParkingLot();
        parkingLot.parkCar(car);
        return String.format("ParkingLotId: %s", parkingLot.getParkingLotId());
    }

    private ParkingLot getHighestEmptyRateParkingLot() {
        this.parkingLots.sort(Comparator.comparingDouble(ParkingLot::getUsageRate));
        return this.parkingLots.get(0);
    }

    public String getParkingBoyName() {
        return parkingBoyName;
    }

    public int getCurrentEmptyLots() {
        return this.parkingLots.stream().mapToInt(ParkingLot::getEmptySize).sum();
    }

    public int getTotalSpace() {
        return this.parkingLots.stream().mapToInt(ParkingLot::getSize).sum();
    }

    public double totalUsageRate() {
        return (double) (this.getTotalSpace() - this.getCurrentEmptyLots()) / this.getTotalSpace();
    }

    @Override
    public String toString() {
        return this.parkingBoyName + ',' +
                this.getTotalSpace() + ',' +
                this.totalUsageRate() + ',' +
                this.getCurrentEmptyLots();
    }
}
