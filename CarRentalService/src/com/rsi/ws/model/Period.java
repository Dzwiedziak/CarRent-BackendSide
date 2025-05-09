package com.rsi.ws.model;

import java.time.LocalDateTime;

public class Period {
    private LocalDateTime dateTimeFrom;
    private LocalDateTime dateTimeTo;

    public Period() {
    }

    public Period(LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo) {
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
    }

    public LocalDateTime getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(LocalDateTime dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public LocalDateTime getDateTimeTo() {
        return dateTimeTo;
    }

    public void setDateTimeTo(LocalDateTime dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }
}

