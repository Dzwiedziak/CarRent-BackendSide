package com.rsi.ws.repositories.interfaces;

import com.rsi.ws.dto.AddReservationDTO;
import com.rsi.ws.model.Reservation;
import java.util.List;

public interface IReservationRepository {
    List<Reservation> getAll();
    Reservation getOne(int id);
    List<Reservation> getByCarId(int id);
    int add(AddReservationDTO reservation);
    void update(Reservation carReservation);
}
