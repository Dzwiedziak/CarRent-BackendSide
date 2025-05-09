package com.rsi.ws.repositories.interfaces;

import com.rsi.ws.model.Car;

import java.util.List;
public interface ICarRepository {
    List<Car> getAll();
    Car getOne(int id);

}
