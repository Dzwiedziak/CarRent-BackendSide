package com.rsi.ws.model;

import java.util.List;

public class Car {
    private int id;
    private String imgSrc;
    private String model;
    private int numberOfSeats;
    private String description;
    private List<Integer> reservationIds;

    public Car() {
    }

    public Car(int id, String imgSrc, String model, int numberOfSeats, String description, List<Integer> reservationIds) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.description = description;
        this.reservationIds = reservationIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getReservationIds() {
        return reservationIds;
    }

    public void setReservationIds(List<Integer> reservationIds) {
        this.reservationIds = reservationIds;
    }
}

