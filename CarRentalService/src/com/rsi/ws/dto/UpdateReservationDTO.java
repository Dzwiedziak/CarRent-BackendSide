package com.rsi.ws.dto;

import com.rsi.ws.model.Period;


public class UpdateReservationDTO {
    private int id;
    private Period period;

    public UpdateReservationDTO() {
    }

    public UpdateReservationDTO(int id, Period period) {
        this.id = id;
        this.period = period;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}

