package com.rsi.ws.api.interfaces;
import com.rsi.ws.dto.AddReservationDTO;
import com.rsi.ws.dto.GetCarDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService
public interface ICarCatalogService {
    @WebMethod
    List<GetCarDTO> getAllCars();

    @WebMethod
    Optional<GetCarDTO> getCar(@WebParam(name = "id") int id);

    @WebMethod
    int reserve(@WebParam(name = "reservation") AddReservationDTO reservation) throws Exception;
}
