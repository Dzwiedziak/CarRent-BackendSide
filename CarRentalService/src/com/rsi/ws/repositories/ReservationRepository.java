package com.rsi.ws.repositories;

import com.rsi.ws.dto.AddReservationDTO;
import com.rsi.ws.model.Period;
import com.rsi.ws.model.Reservation;
import com.rsi.ws.repositories.interfaces.IReservationRepository;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository implements IReservationRepository {
    private final List<Reservation> reservations = new ArrayList<Reservation>() {{
        add(new Reservation(
                0,
                0,
                new Period(null, java.time.LocalDateTime.now())
        ));
        add(new Reservation(
                1,
                0,
                new Period(java.time.LocalDateTime.of(2025, 4, 7, 0, 0), java.time.LocalDateTime.of(2025, 4, 9, 0, 0))
        ));
        add(new Reservation(
                2,
                1,
                new Period(null, java.time.LocalDateTime.now())
        ));
    }};

    private int currentId = 3;
    @Override
    public List<Reservation> getAll() {
        return reservations;
    }

    @Override
    public Reservation getOne(int id) {
        return reservations.stream()
                .filter(reservation -> reservation.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reservation> getByCarId(int id) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCarId() == id) {
                result.add(reservation);
            }
        }
        return result;
    }

    @Override
    public int add(AddReservationDTO reservation) {
        Reservation modelObj = createCarReservation(reservation);
        reservations.add(modelObj);
        return currentId++;
    }

    @Override
    public void update(Reservation carReservation) {
        int index = -1;
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId() == carReservation.getId()) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            reservations.set(index, carReservation);
        }
    }
    public Reservation createCarReservation(AddReservationDTO addReservation) {
        return new Reservation(
                currentId,
                addReservation.getCarId(),
                addReservation.getPeriod()
        );
    }
}
