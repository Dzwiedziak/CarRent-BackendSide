package com.rsi.ws;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(endpointInterface = "com.rsi.ws.CarRentalService")
public class CarRentalServiceImpl implements CarRentalService {

    private static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car(1, "Toyota", "Corolla", true));
        cars.add(new Car(2, "BMW", "X5", true));
        cars.add(new Car(3, "Audi", "A3", true));
    }

    @Override
    public List<Car> listAvailableCars(Date from, Date to) {
        List<Car> available = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                available.add(car);
            }
        }
        return available;
    }

    @Override
    public String reserveCar(int carId, Date from, Date to) {
        for (Car car : cars) {
            if (car.getId() == carId && car.isAvailable()) {
                car.setAvailable(false);
                return "Reservation confirmed for car ID: " + carId;
            }
        }
        return "Car not available.";
    }
}

