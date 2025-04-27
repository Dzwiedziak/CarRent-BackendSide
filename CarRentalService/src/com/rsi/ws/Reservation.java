package com.rsi.ws;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
    private String reservationId;
    private Car car;
    private Date fromDate;
    private Date toDate;

    public Reservation() {}

    public Reservation(String reservationId, Car car, Date fromDate, Date toDate) {
        this.reservationId = reservationId;
        this.car = car;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getReservationId() { return reservationId; }
    public void setReservationId(String reservationId) { this.reservationId = reservationId; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public Date getFromDate() { return fromDate; }
    public void setFromDate(Date fromDate) { this.fromDate = fromDate; }

    public Date getToDate() { return toDate; }
    public void setToDate(Date toDate) { this.toDate = toDate; }
}
