package com.rsi.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Date;
import javax.activation.DataHandler;

@WebService
public interface CarRentalService {
    @WebMethod
    List<Car> listAvailableCars(Date from, Date to);
    @WebMethod
    String reserveCar(int carId, Date from, Date to);

    @WebMethod
    boolean cancelReservation(String reservationId);

    @WebMethod
    boolean modifyReservation(String reservationId, Date newFrom, Date newTo);

    @WebMethod
    DataHandler getReservationConfirmation(String reservationId); // zwraca PDF

    @WebMethod
    List<Reservation> listReservations();
}
