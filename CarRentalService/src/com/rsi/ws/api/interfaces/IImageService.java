package com.rsi.ws.api.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import java.awt.*;

@MTOM
@WebService
public interface IImageService {

    @WebMethod
    Image getImage(@WebParam(name="id") int id);
}
