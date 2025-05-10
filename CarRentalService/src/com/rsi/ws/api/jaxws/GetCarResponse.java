
package com.rsi.ws.api.jaxws;

import java.util.Optional;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCarResponse", namespace = "http://interfaces.api.ws.rsi.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCarResponse", namespace = "http://interfaces.api.ws.rsi.com/")
public class GetCarResponse {

    @XmlElement(name = "return", namespace = "")
    private Optional _return;

    /**
     * 
     * @return
     *     returns Optional
     */
    public Optional getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Optional _return) {
        this._return = _return;
    }

}
