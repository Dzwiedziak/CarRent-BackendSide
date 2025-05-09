package com.rsi.ws.api.interfaces;

import com.rsi.ws.dto.UpdateReservationDTO;
import com.rsi.ws.model.Reservation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ICarRentalService {
    @WebMethod
    void updateReservation(@WebParam(name = "reservation") UpdateReservationDTO reservation) throws Exception;

    @WebMethod
    List<Reservation> getAllReservations();
}
