package com.rsi.ws.model;

import com.rsi.ws.model.Period;

public class Reservation {
    private int id;
    private int carId;
    private Period period;

    public Reservation() {
    }

    public Reservation(int id, int carId, Period period) {
        this.id = id;
        this.carId = carId;
        this.period = period;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

