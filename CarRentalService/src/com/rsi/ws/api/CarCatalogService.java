package com.rsi.ws.api;

import com.rsi.ws.api.interfaces.ICarCatalogService;
import com.rsi.ws.dto.AddReservationDTO;
import com.rsi.ws.dto.GetCarDTO;
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
import java.util.Optional;

@WebService(endpointInterface = "com.rsi.ws.api.interfaces.ICarCatalogService")
public class CarCatalogService implements ICarCatalogService {
    IReservationRepository  reservationRepository = new ReservationRepository();
    ICarRepository carRepository = new CarRepository();
    IReservationService reservationService = new ReservationService(reservationRepository);
    ICarService carService = new CarService(carRepository,reservationRepository);
    @Override
    public List<GetCarDTO> getAllCars() {
        return carService.getAll();
    }

    @Override
    public Optional<GetCarDTO> getCar(int id) {
        return carService.getOne(id);
    }

    @Override
    public int reserve(AddReservationDTO reservation) throws Exception {
        try {
            return reservationService.reserveVehicle(reservation);
        } catch (IllegalArgumentException ex) {
            throw new Exception("Reservation failed: " + ex.getMessage());
        }
    }
}
