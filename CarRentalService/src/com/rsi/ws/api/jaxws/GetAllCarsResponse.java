
package com.rsi.ws.api.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllCarsResponse", namespace = "http://interfaces.api.ws.rsi.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllCarsResponse", namespace = "http://interfaces.api.ws.rsi.com/")
public class GetAllCarsResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.rsi.ws.dto.GetCarDTO> _return;

    /**
     * 
     * @return
     *     returns List<GetCarDTO>
     */
    public List<com.rsi.ws.dto.GetCarDTO> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.rsi.ws.dto.GetCarDTO> _return) {
        this._return = _return;
    }

}
