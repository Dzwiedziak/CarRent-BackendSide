package com.rsi.ws.dto;

import com.rsi.ws.model.Period;

public class UpdateReservationDTO {
    private int id;
    private Period period;

    // Konstruktor domyślny
    public UpdateReservationDTO() {
    }

    // Konstruktor z parametrami
    public UpdateReservationDTO(int id, Period period) {
        this.id = id;
        this.period = period;
    }

    // Gettery i settery
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

