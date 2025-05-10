package com.rsi.ws.api;

import com.rsi.ws.api.interfaces.IImageService;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


@MTOM
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_BINDING)
@WebService(endpointInterface = "com.rsi.ws.api.interfaces.IImageService")
public class ImageService implements IImageService {

    @Override
    public Image getImage(int id) {
        String imgPath;
        switch (id) {
            case 0:
                imgPath = "audi.webp";
                break;
            case 1:
                imgPath = "tesla.webp";
                break;
            default:
                throw new IllegalArgumentException("Invalid image id");
        }

        try {
            URL resource = getClass().getClassLoader().getResource(imgPath);
            if (resource == null) {
                throw new FileNotFoundException("Nie znaleziono pliku: " + imgPath);
            }

            return ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
