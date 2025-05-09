package com.rsi.ws.services;

import com.rsi.ws.dto.GetCarDTO;
import com.rsi.ws.model.Car;
import com.rsi.ws.model.Period;
import com.rsi.ws.model.Reservation;
import com.rsi.ws.repositories.interfaces.ICarRepository;
import com.rsi.ws.repositories.interfaces.IReservationRepository;
import com.rsi.ws.services.interfaces.ICarService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarService implements ICarService {
    private ICarRepository repository;
    private IReservationRepository reservationRepository;

    public CarService(ICarRepository repository,
                                    IReservationRepository reservationRepository) {
        this.repository = repository;
        this.reservationRepository = reservationRepository;
    }
    @Override
    public List<GetCarDTO> getAll() {
        List<Car> cars = repository.getAll();
        return cars.stream()
                .map(this::getDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GetCarDTO> getOne(int id) {
        Car modelObj = repository.getOne(id);
        if (modelObj == null) {
            return Optional.empty();
        }
        return Optional.of(getDTO(modelObj));
    }
    public GetCarDTO getDTO(Car car) {
        List<Period> unavailablePeriods = reservationRepository.getByCarId(car.getId()).stream()
                .map(Reservation::getPeriod)
                .collect(Collectors.toList());

        return new GetCarDTO(
                car.getId(),
                car.getImgSrc(),
                car.getModel(),
                car.getNumberOfSeats(),
                car.getDescription(),
                unavailablePeriods
        );
    }
}
