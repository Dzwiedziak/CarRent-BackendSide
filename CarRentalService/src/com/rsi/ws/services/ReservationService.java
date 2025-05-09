package com.rsi.ws.services;

import com.rsi.ws.dto.AddReservationDTO;
import com.rsi.ws.dto.UpdateReservationDTO;
import com.rsi.ws.model.Period;
import com.rsi.ws.model.Reservation;
import com.rsi.ws.repositories.interfaces.IReservationRepository;
import com.rsi.ws.services.interfaces.IReservationService;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationService implements IReservationService {
    private final IReservationRepository reservationRepository;

    public ReservationService(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    @Override
    public int reserveVehicle(AddReservationDTO reservation) {
        if (!isAvailable(reservation.getCarId(), reservation.getPeriod(), null)) {
            throw new IllegalArgumentException("Car in this period is reserved");
        }
        return reservationRepository.add(new AddReservationDTO(
                reservation.getCarId(),
                reservation.getPeriod()
        ));
    }
    public boolean isAvailable(int carId, Period period, Integer excludeReservationId) {
        List<Reservation> reservations = reservationRepository.getByCarId(carId).stream()
                .filter(r -> excludeReservationId == null || r.getId() != excludeReservationId)
                .collect(Collectors.toList());

        return reservations.stream()
                .noneMatch(r -> hasCommonPeriod(r.getPeriod(), period));
    }

    public boolean hasCommonPeriod(Period fPeriod, Period sPeriod) {
        long fStart = fPeriod.getDateTimeFrom() != null ? fPeriod.getDateTimeFrom().toInstant(java.time.ZoneOffset.UTC).toEpochMilli() : Long.MIN_VALUE;
        long fEnd = fPeriod.getDateTimeTo() != null ? fPeriod.getDateTimeTo().toInstant(java.time.ZoneOffset.UTC).toEpochMilli() : Long.MAX_VALUE;
        long sStart = sPeriod.getDateTimeFrom() != null ? sPeriod.getDateTimeFrom().toInstant(java.time.ZoneOffset.UTC).toEpochMilli() : Long.MIN_VALUE;
        long sEnd = sPeriod.getDateTimeTo() != null ? sPeriod.getDateTimeTo().toInstant(java.time.ZoneOffset.UTC).toEpochMilli() : Long.MAX_VALUE;

        return fStart < sEnd && fEnd > sStart;
    }

    public Reservation createCarReservation(UpdateReservationDTO updateDTO) {
        Reservation reservation = reservationRepository.getOne(updateDTO.getId());
        if (reservation == null) return null;
        reservation.setPeriod(updateDTO.getPeriod());
        return reservation;
    }

    @Override
    public void updateReservation(UpdateReservationDTO reservation) {
        Reservation modelObj = reservationRepository.getOne(reservation.getId());
        if (modelObj == null) {
            throw new IllegalArgumentException("Reservation does not exist");
        }

        if (!isAvailable(modelObj.getCarId(), reservation.getPeriod(), modelObj.getId())) {
            throw new IllegalArgumentException("Car in this period is reserved");
        }

        modelObj.setPeriod(reservation.getPeriod());
        reservationRepository.update(modelObj);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }
}
