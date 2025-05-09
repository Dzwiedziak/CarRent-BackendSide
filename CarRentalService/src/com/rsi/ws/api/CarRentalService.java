package com.rsi.ws.api;

import com.rsi.ws.api.interfaces.ICarRentalService;
import com.rsi.ws.dto.UpdateReservationDTO;
import com.rsi.ws.model.Reservation;
import com.rsi.ws.repositories.CarRepository;
import com.rsi.ws.repositories.ReservationRepository;
import com.rsi.ws.repositories.interfaces.ICarRepository;
import com.rsi.ws.repositories.interfaces.IReservationRepository;
import com.rsi.ws.services.CarService;
import com.rsi.ws.services.ReservationService;
import com.rsi.ws.services.interfaces.ICarService;
import com.rsi.ws.services.interfaces.IReservationService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.rsi.ws.api.interfaces.ICarRentalService")
public class CarRentalService implements ICarRentalService {
    IReservationRepository reservationRepository = new ReservationRepository();
    ICarRepository carRepository = new CarRepository();
    IReservationService reservationService = new ReservationService(reservationRepository);
    ICarService carService = new CarService(carRepository,reservationRepository);
    @Override
    public void updateReservation(UpdateReservationDTO reservation) throws Exception {
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation data is required.");
        }

        try {
            reservationService.updateReservation(reservation);
        } catch (Exception e) {
            throw new Exception("Update for this reservation is impossible.");
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationService.getAll();
    }
}
