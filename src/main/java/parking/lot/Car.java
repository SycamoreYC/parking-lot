package parking.lot;

public class Car {

    private int carId;

    public Car(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    @Override
    public int hashCode() {
        return String.valueOf(carId).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return carId == car.getCarId();
        }
        return false;
    }
}
