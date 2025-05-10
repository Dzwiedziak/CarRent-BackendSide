package com.rsi.ws.api;

import com.rsi.ws.api.interfaces.IImageService;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


@MTOM
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_BINDING)
@WebService(endpointInterface = "com.rsi.ws.api.interfaces.IImageService")
public class ImageService implements IImageService {

    @Override
    public Image getImage(int id) {
        String imgPath = "C:/Users/niedz/Desktop/Images/";
        switch (id) {
            case 0:
                imgPath += "audi.png";
                break;
            case 1:
                imgPath += "tesla.png";
                break;
            default:
                throw new IllegalArgumentException("Invalid image id");
        }

        try {
            File file = new File(imgPath);
            System.out.println("Ścieżka do pliku: " + file.getAbsolutePath());
            System.out.println("Plik istnieje? " + file.exists());
            BufferedImage image = ImageIO.read(file);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
