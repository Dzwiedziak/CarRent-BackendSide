
package com.rsi.ws.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "reserve", namespace = "http://interfaces.api.ws.rsi.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserve", namespace = "http://interfaces.api.ws.rsi.com/")
public class Reserve {

    @XmlElement(name = "reservation", namespace = "")
    private com.rsi.ws.dto.AddReservationDTO reservation;

    /**
     * 
     * @return
     *     returns AddReservationDTO
     */
    public com.rsi.ws.dto.AddReservationDTO getReservation() {
        return this.reservation;
    }

    /**
     * 
     * @param reservation
     *     the value for the reservation property
     */
    public void setReservation(com.rsi.ws.dto.AddReservationDTO reservation) {
        this.reservation = reservation;
    }

}
