package com.rsi.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Date;

@WebService
public interface CarRentalService {
    @WebMethod
    List<Car> listAvailableCars(Date from, Date to);

    @WebMethod
    String reserveCar(int carId, Date from, Date to);
}
