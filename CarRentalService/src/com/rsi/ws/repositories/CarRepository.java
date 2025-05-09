package com.rsi.ws.repositories;

import com.rsi.ws.model.Car;
import com.rsi.ws.repositories.interfaces.ICarRepository;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CarRepository implements ICarRepository {
    private final List<Car> cars = new ArrayList<Car>(){{
        add(new Car(
                0,
                "https://samochodowy.pl/uploads/blogs/1729238435tnahb-1713735596a494nangjpg.jpeg",
                "Tesla S",
                5,
                "Experience the perfect blend of power, style, and technology. This vehicle is built to impress and engineered to perform in any environment.",
                new ArrayList<Integer>(Arrays.asList(0,1))
        ));
        add(new Car(
                1,
                "https://carleasepolska.pl/media/cache/car_details_thumbnail_small/uploads/5a5346f4bad4e35cec4164b864c6e2df_webp_converted.webp",
                "Audi A6",
                5,
                "\"Powerful vehicle. Rent this car and check it yourself",
                new ArrayList<Integer>(Arrays.asList(2))
        ));
    }};

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public Car getOne(int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

