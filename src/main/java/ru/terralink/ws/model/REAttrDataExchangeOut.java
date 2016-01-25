
package ru.terralink.ws.model;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "REAttrDataExchangeOut", targetNamespace = "http://inform.gazprom.ru/C/SUIM/REDataExchange")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface REAttrDataExchangeOut {


    /**
     * 
     * @param reAttrDataExchangeMessage
     */
    @WebMethod(operationName = "REAttrDataExchangeOut", action = "http://sap.com/xi/WebService/soap1.1")
    @Oneway
    public void reAttrDataExchangeOut(
        @WebParam(name = "REAttrDataExchangeMessage", targetNamespace = "http://inform.gazprom.ru/C/SUIM/REDataExchange", partName = "REAttrDataExchangeMessage")
        REDataExchangeAttrECD reAttrDataExchangeMessage);

}
