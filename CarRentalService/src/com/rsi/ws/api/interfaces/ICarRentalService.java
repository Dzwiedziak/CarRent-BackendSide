package com.rsi.ws.api.interfaces;

import com.rsi.ws.dto.UpdateReservationDTO;
import com.rsi.ws.model.Reservation;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
@HandlerChain(file="handler-chain.xml")
public interface ICarRentalService {
    @WebMethod
    void updateReservation(@WebParam(name = "reservation") UpdateReservationDTO reservation) throws Exception;

    @WebMethod
    List<Reservation> getAllReservations();
}
