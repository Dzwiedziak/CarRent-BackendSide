package com.rsi.ws.services.interfaces;

import com.rsi.ws.dto.AddReservationDTO;
import com.rsi.ws.dto.UpdateReservationDTO;
import com.rsi.ws.model.Reservation;

import java.util.List;

public interface IReservationService {
    int reserveVehicle(AddReservationDTO reservation);
    void updateReservation(UpdateReservationDTO reservation);
    List<Reservation> getAll();
}
