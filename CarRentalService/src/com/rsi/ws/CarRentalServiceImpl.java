package com.rsi.ws;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@MTOM
@WebService(endpointInterface = "com.rsi.ws.CarRentalService")
public class CarRentalServiceImpl implements CarRentalService {

    private static List<Car> cars = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

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
                String reservationId = UUID.randomUUID().toString();
                Reservation reservation = new Reservation(reservationId, car, from, to);
                reservations.add(reservation);
                car.setAvailable(false);
                return "Reservation confirmed for car ID: " + carId;
            }
        }
        return "Car not available.";
    }

    @Override
    public boolean cancelReservation(String reservationId) {
        for (Reservation res : reservations) {
            if (res.getReservationId().equals(reservationId)) {
                res.getCar().setAvailable(true);
                reservations.remove(res);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modifyReservation(String reservationId, Date newFrom, Date newTo) {
        for (Reservation res : reservations) {
            if (res.getReservationId().equals(reservationId)) {
                res.setFromDate(newFrom);
                res.setToDate(newTo);
                return true;
            }
        }
        return false;
    }

    @Override
    public DataHandler getReservationConfirmation(String reservationId) {
        try {
            for (Reservation res : reservations) {
                if (res.getReservationId().equals(reservationId)) {
                    File pdf = generatePdfConfirmation(res);
                    DataSource source = new FileDataSource(pdf);
                    return new DataHandler(source);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reservation> listReservations() {
        return reservations;
    }

    private File generatePdfConfirmation(Reservation res) throws Exception {
        String fileName = "confirmation_" + res.getReservationId() + ".txt";
        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            String content = "Reservation Confirmation\n\n" +
                    "Reservation ID: " + res.getReservationId() + "\n" +
                    "Car: " + res.getCar().getBrand() + " " + res.getCar().getModel() + "\n" +
                    "From: " + new SimpleDateFormat("yyyy-MM-dd").format(res.getFromDate()) + "\n" +
                    "To: " + new SimpleDateFormat("yyyy-MM-dd").format(res.getToDate()) + "\n";
            fos.write(content.getBytes());
        }

        return file;
    }
}

