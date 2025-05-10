
package com.rsi.ws.api.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCar", namespace = "http://interfaces.api.ws.rsi.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCar", namespace = "http://interfaces.api.ws.rsi.com/")
public class GetCar {

    @XmlElement(name = "id", namespace = "")
    private int id;

    /**
     * 
     * @return
     *     returns int
     */
    public int getId() {
        return this.id;
    }

    /**
     * 
     * @param id
     *     the value for the id property
     */
    public void setId(int id) {
        this.id = id;
    }

}
