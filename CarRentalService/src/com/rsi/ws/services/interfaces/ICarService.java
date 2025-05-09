package com.rsi.ws.services.interfaces;

import com.rsi.ws.dto.GetCarDTO;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    List<GetCarDTO> getAll();
    Optional<GetCarDTO> getOne(int id);
}
