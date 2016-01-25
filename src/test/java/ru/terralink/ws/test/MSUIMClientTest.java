package ru.terralink.ws.test;

import org.junit.Ignore;
import org.springframework.core.io.ClassPathResource;
import ru.terralink.common.Utils;

import ru.terralink.ws.client.MSUIMClient2;
import ru.terralink.ws.client.MainApp;
import ru.terralink.ws.model.REAttrDataExchangeOut;
import ru.terralink.ws.model.REAttrDataExchangeOutService;
import ru.terralink.ws.model.REDataExchangeAttrECD;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

//Created by Arzamastsev on 14.12.2015.
public class MSUIMClientTest {

    private MainApp client;

    private static final String serverUrl = "http://localhost:8088/mockREAttrDataExchangeOutBinding?wsdl";
    private static final String login = "";
    private static final String pass = "";

    @org.junit.Before
    public void setUp() throws Exception {
        client = new MainApp();
    }

    @org.junit.Test
    public void testInitContext() throws Exception {
        Map<String, Object> result = client.init(serverUrl, login, pass);
        assertTrue((Boolean) result.get("ok"));
    }

    @org.junit.Test
    public void addSectionTest() throws Exception {
        Map<String, Object> result =  client.init(serverUrl, login, pass);
        assertTrue((Boolean) result.get("ok"));

        result = client.addAttachment(5,getAttrFile());
        assertTrue((Boolean) result.get("ok"));

        result = client.addSection("OBJECT_REFS", getOBJECT_REFS());
        assertTrue((Boolean) result.get("ok"));

        result = client.addSection("PARTNER_REFS", getPARTNER_REFS());
        assertTrue((Boolean) result.get("ok"));

        result = client.addSection("ANY", getANY());
        assertTrue((Boolean) result.get("ok"));

        result = client.addSection("GENERAL", getGENERAL());
        assertTrue((Boolean) result.get("ok"));

        result = client.addSection("Header", getHeader());
        assertTrue((Boolean) result.get("ok"));

        result = client.addSection("CCC", getCCC());
        assertTrue((Boolean) result.get("ok"));

        result = client.doWork();
        assertTrue((Boolean) result.get("ok"));

        REDataExchangeAttrECD message = client.getMessage();
        Utils.marshalObject("./marshalled.xml", message);
    }

    @org.junit.Test
    public void testDoWork() throws Exception {
        client.init(serverUrl, login, pass);
        client.addSection("OBJECT_REFS", getOBJECT_REFS());
        client.addSection("PARTNER_REFS", getPARTNER_REFS());
        client.addSection("ANY", getANY());
        client.addSection("GENERAL", getGENERAL());
        client.addSection("Header", getHeader());
        client.addAttachment(5, getAttrFile());
        client.getMessage();
        client.doWork();
    }

    public Map<String, Object> getGENERAL() throws Exception {
        Map<String, Object> GENERAL = new HashMap<>();
        GENERAL.put("doctype", "text");
        GENERAL.put("docgrcode", "text");
        GENERAL.put("docnum", "text");
        GENERAL.put("docdate", "20151123");
        GENERAL.put("docname", "text");
        GENERAL.put("nodocnum", false);
        GENERAL.put("nodocdate", false);
        GENERAL.put("remarks", "text");
        GENERAL.put("rerf", "text");
        GENERAL.put("autordoc", "text");

        return GENERAL;
    }

    public Map<String, Object> getOBJECT_REFS() throws Exception {
        Map<String, Object> OBJECT_REFS = new HashMap<>();
        OBJECT_REFS.put("OBJECT_REF", "I000000000000000000825");
        OBJECT_REFS.put("ObjCommType", "te");
        OBJECT_REFS.put("LINK", "rt");
        OBJECT_REFS.put("DOCGUID", "20150302");
        OBJECT_REFS.put("Delete", true);

        return OBJECT_REFS;
    }

    public Map<String, Object> getPARTNER_REFS() throws Exception {
        Map<String, Object> PARTNER_REFS = new HashMap<>();
        PARTNER_REFS.put("PARTNER_REF", "");
        PARTNER_REFS.put("LINK", "");
        PARTNER_REFS.put("DOCGUID", "");
        PARTNER_REFS.put("Delete", "");

        return PARTNER_REFS;
    }

    public Map<String, Object> getANY() throws Exception {
        Map<String, Object> ANY = new HashMap<>();
        ANY.put("CUSTOMER", "text");
        ANY.put("CHILDORG", "text");
        ANY.put("XCHILDORG", "text");
        ANY.put("periodbegin", "20150302");
//        ANY.put("CONSTRUCTOBJECT", "text");
//        ANY.put("CONSTRUCTNAME", "text");
        ANY.put("PERIOD", "20150302");
        ANY.put("LINKDOCNUM", "text");
        ANY.put("LINKDOCDATE", "20150302");
        ANY.put("SUMMA", "text");
        ANY.put("CALCCURR", "text");

        return ANY;
    }

    public Map<String, Object> getHeader() throws Exception {
        Map<String, Object> Header = new HashMap<>();
        Header.put("logicalSystem", "text");
        Header.put("objectType", "te");
        Header.put("objectNumber", "text");
        Header.put("objectNumberExt", "text");
        Header.put("activity", "01");
        Header.put("objectTypeDiff", "text");
        Header.put("destination", "text");

        return Header;
    }

    public Map<String, Object> getCCC() throws Exception {
        Map<String, Object> Header = new HashMap<>();
        Header.put("ESTIMATEDORG", "Факел");
        Header.put("RATINGOBJECT", "Автобус ПАЗ-32054-110-07 г/н Р 319 НУ56");
        return Header;
    }

    //TODO: You need add simple pdf file to the resources and change arg name for ClassPathResource
    public Map<String, Object> getAttrFile() throws Exception {

        File file = new ClassPathResource("ECMLink 10.5 SP1 - User Guide.pdf").getFile();

        Map<String, Object> AttrFile = new HashMap<>();
        AttrFile.put("File_ID", "4673");
        AttrFile.put("NOMER", 12);
        AttrFile.put("FILE_NAME", file.getName());
        AttrFile.put("USERS", "text");
        AttrFile.put("USERSTXT", "text");
        AttrFile.put("DATUM", "19470202");
        AttrFile.put("Delete", false);

        AttrFile.put("Content", Files.readAllBytes(file.toPath()));

        return AttrFile;
    }

    //TODO: You need add simple pdf file to the resources and change arg name for ClassPathResource
    public byte[] getFileContent() throws Exception {
        File file = new ClassPathResource("ECMLink 10.5 SP1 - User Guide.pdf").getFile();
        byte[] b = Files.readAllBytes(file.toPath());
        return b;
    }

    //TODO: You need add simple pdf file to the resources and change arg name for ClassPathResource
    @org.junit.Test
    public void getTestFile() throws IOException {
        File file = new ClassPathResource("ECMLink 10.5 SP1 - User Guide.pdf").getFile();
        byte[] b = Files.readAllBytes(file.toPath());
        System.out.print(b.length);
        assertNotSame(0, b.length);
    }

    //TODO: You need add simple pdf file to the resources and change arg name for ClassPathResource
    @org.junit.Test
    public void getMimeTypeTest() throws Exception {
        File file = new ClassPathResource("ECMLink 10.5 SP1 - User Guide.pdf").getFile();
        String fileName = file.getName();
        String mimeType = Utils.getMimeType(fileName);
        assertNotNull(mimeType);

    }

    @Ignore
    @org.junit.Test
    public void getServerTest() throws Exception {
        REAttrDataExchangeOut service = new REAttrDataExchangeOutService().getHTTPPort();
        assertNotNull("");
    }

    @org.junit.Test
    public void getMimeTypeByFileName() throws IOException {
        String fileName = "img-178991022012016.pdf";
        String mimeType = Utils.getMimeType(fileName);
        assertEquals("application/pdf", mimeType);
    }
}