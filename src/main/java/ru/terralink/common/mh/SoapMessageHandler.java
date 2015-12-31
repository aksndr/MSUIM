package ru.terralink.common.mh;//Created by Arzamastsev on 30.12.2015.

import com.sun.xml.internal.messaging.saaj.soap.impl.ElementImpl;
import com.sun.xml.internal.ws.util.ByteArrayDataSource;
import org.w3c.dom.*;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SoapMessageHandler implements SOAPHandler<SOAPMessageContext> {

    private List<byte[]> chunks = new ArrayList<>();
    private int counter = 0;
    private String mimeType = "";

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        SOAPMessage m = context.getMessage();
        byte[] chunk = chunks.get(counter);
        ByteArrayDataSource dataSource = new ByteArrayDataSource(chunk, mimeType);
        DataHandler dh = new DataHandler(dataSource);
        AttachmentPart ap = m.createAttachmentPart(dh);
        ap.setContentId("cid-001");
        m.addAttachmentPart(ap);
        counter++;
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public void setChunks(List<byte[]> chunks) {
        this.chunks = chunks;
    }
}
