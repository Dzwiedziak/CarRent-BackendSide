package com.rsi.ws.dto;

import com.rsi.ws.model.Period;

public class AddReservationDTO {
    private int carId;
    private Period period;

    public AddReservationDTO() {
    }

    public AddReservationDTO(int carId, Period period) {
        this.carId = carId;
        this.period = period;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}

