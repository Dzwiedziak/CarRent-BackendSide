package com.rsi.publisher;
import com.rsi.ws.CarRentalServiceImpl;

import javax.xml.ws.Endpoint;

public class CarRentalServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/CarRentalService", new CarRentalServiceImpl());
        System.out.println("CarRentalService is running at http://localhost:8080/CarRentalService?wsdl");
    }
}
