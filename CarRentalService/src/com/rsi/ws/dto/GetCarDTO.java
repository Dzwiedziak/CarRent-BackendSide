package com.rsi.ws.dto;

import com.rsi.ws.model.Period;

import java.util.List;

public class GetCarDTO {
    private int id;
    private String imgSrc;
    private String model;
    private int numberOfSeats;
    private String description;
    private List<Period> unavailablePeriods;

    public GetCarDTO() {
    }

    public GetCarDTO(int id, String imgSrc, String model, int numberOfSeats, String description, List<Period> unavailablePeriods) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.description = description;
        this.unavailablePeriods = unavailablePeriods;
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

    public List<Period> getUnavailablePeriods() {
        return unavailablePeriods;
    }

    public void setUnavailablePeriods(List<Period> unavailablePeriods) {
        this.unavailablePeriods = unavailablePeriods;
    }
}

