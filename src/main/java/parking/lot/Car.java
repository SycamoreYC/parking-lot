package parking.lot;

public class Car {

    Integer carId;

    public Car(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarId() {
        return carId;
    }

    @Override
    public boolean equals(Object obj) {
        Car otherCar = (Car) obj;
        return otherCar.getCarId().equals(this.getCarId());
    }

    @Override
    public int hashCode() {
        return this.carId.hashCode();
    }
}
