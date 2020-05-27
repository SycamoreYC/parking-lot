package parking.lot;

import java.util.ArrayList;

public class ParkingLot {

    ArrayList<Car> spotsList;
    Integer parkingLotId;
    Integer size;

    public ParkingLot(Integer parkingLotId, Integer size) {
        this.parkingLotId = parkingLotId;
        this.size = size;
        this.spotsList = new ArrayList<>();
    }

    Integer getSize() {
        return this.size;
    }

    Integer getEmptySize() {
        return this.size - this.spotsList.size();
    }

    Double usageRate() {
        return (double) this.spotsList.size() / this.size;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    Boolean isFull() {
        return this.size == this.spotsList.size();
    }


    Boolean park(Car car) {
        if (this.isFull()) {
            return false;
        }
        this.spotsList.add(car);
        return true;
    }

    void pickCar(Car car) {
        this.spotsList.remove(car);
    }
}
