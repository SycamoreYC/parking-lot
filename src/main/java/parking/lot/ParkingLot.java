package parking.lot;

import java.util.ArrayList;

public class ParkingLot {

    private ArrayList<Car> spotsList;
    private int parkingLotId;
    private int size;

    public ParkingLot(Integer parkingLotId, Integer size) {
        this.parkingLotId = parkingLotId;
        this.size = size;
        this.spotsList = new ArrayList<>();
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public int getSize() {
        return this.size;
    }

    public int getCarAmount() {
        return spotsList.size();
    }

    public int getEmptySize() {
        return this.size - this.spotsList.size();
    }

    public double getUsageRate() {
        return (double) this.spotsList.size() / this.size;
    }

    public boolean parkCar(Car car) {
        if (this.isFull()) {
            return false;
        }
        this.spotsList.add(car);
        return true;
    }

    public void pickCar(Car car) {
        this.spotsList.remove(car);
    }

    public boolean isFull() {
        return this.size == this.spotsList.size();
    }
}
