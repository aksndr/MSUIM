
package ru.terralink.ws.model;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01
 * Generated source version: 2.2
 */
@WebServiceClient(name = "REAttrDataExchangeOutService", targetNamespace = "http://inform.gazprom.ru/C/SUIM/REDataExchange", wsdlLocation = "file:/D:/rnd/workspace/java/MSUIM/REAttrDataExchangeOutService.wsdl")
public class REAttrDataExchangeOutService extends Service {

    private final static URL REATTRDATAEXCHANGEOUTSERVICE_WSDL_LOCATION;
    private final static WebServiceException REATTRDATAEXCHANGEOUTSERVICE_EXCEPTION;
    private final static QName REATTRDATAEXCHANGEOUTSERVICE_QNAME = new QName("http://inform.gazprom.ru/C/SUIM/REDataExchange", "REAttrDataExchangeOutService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/rnd/workspace/java/MSUIM/REAttrDataExchangeOutService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        REATTRDATAEXCHANGEOUTSERVICE_WSDL_LOCATION = url;
        REATTRDATAEXCHANGEOUTSERVICE_EXCEPTION = e;
    }

    public REAttrDataExchangeOutService() {
        super(__getWsdlLocation(), REATTRDATAEXCHANGEOUTSERVICE_QNAME);
    }

    public REAttrDataExchangeOutService(WebServiceFeature... features) {
        super(__getWsdlLocation(), REATTRDATAEXCHANGEOUTSERVICE_QNAME, features);
    }

    public REAttrDataExchangeOutService(URL wsdlLocation) {
        super(wsdlLocation, REATTRDATAEXCHANGEOUTSERVICE_QNAME);
    }

    public REAttrDataExchangeOutService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, REATTRDATAEXCHANGEOUTSERVICE_QNAME, features);
    }

    public REAttrDataExchangeOutService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public REAttrDataExchangeOutService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns REAttrDataExchangeOut
     */
    @WebEndpoint(name = "HTTP_Port")
    public REAttrDataExchangeOut getHTTPPort() {
        return super.getPort(new QName("http://inform.gazprom.ru/C/SUIM/REDataExchange", "HTTP_Port"), REAttrDataExchangeOut.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns REAttrDataExchangeOut
     */
    @WebEndpoint(name = "HTTP_Port")
    public REAttrDataExchangeOut getHTTPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://inform.gazprom.ru/C/SUIM/REDataExchange", "HTTP_Port"), REAttrDataExchangeOut.class, features);
    }

    /**
     * @return returns REAttrDataExchangeOut
     */
    @WebEndpoint(name = "HTTPS_Port")
    public REAttrDataExchangeOut getHTTPSPort() {
        return super.getPort(new QName("http://inform.gazprom.ru/C/SUIM/REDataExchange", "HTTPS_Port"), REAttrDataExchangeOut.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns REAttrDataExchangeOut
     */
    @WebEndpoint(name = "HTTPS_Port")
    public REAttrDataExchangeOut getHTTPSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://inform.gazprom.ru/C/SUIM/REDataExchange", "HTTPS_Port"), REAttrDataExchangeOut.class, features);
    }

    private static URL __getWsdlLocation() {
        if (REATTRDATAEXCHANGEOUTSERVICE_EXCEPTION != null) {
            throw REATTRDATAEXCHANGEOUTSERVICE_EXCEPTION;
        }
        return REATTRDATAEXCHANGEOUTSERVICE_WSDL_LOCATION;
    }

}
