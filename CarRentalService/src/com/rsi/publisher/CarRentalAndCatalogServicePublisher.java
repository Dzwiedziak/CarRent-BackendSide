package com.rsi.publisher;
import com.rsi.ws.api.CarCatalogService;
import com.rsi.ws.api.CarRentalService;

import javax.xml.ws.Endpoint;

public class CarRentalAndCatalogServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/CarCatalogService", new CarCatalogService());
        Endpoint.publish("http://localhost:8080/CarRentalService", new CarRentalService());

        System.out.println("CarCatalogService is running at http://localhost:8080/CarCatalogService?wsdl");
        System.out.println("CarRentalService is running at http://localhost:8080/CarRentalService?wsdl");
    }
}
