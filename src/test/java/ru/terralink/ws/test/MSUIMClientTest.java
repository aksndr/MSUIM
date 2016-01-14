package ru.terralink.ws.test;

import org.springframework.core.io.ClassPathResource;
import ru.terralink.common.Utils;
import ru.terralink.ws.client.MSUIMClient;
import ru.terralink.ws.model.REAttrDataExchangeOut;
import ru.terralink.ws.model.REAttrDataExchangeOutService;
import ru.terralink.ws.model.REDataExchangeAttrECD;

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

    private MSUIMClient client;

    private static final String serverUrl = "http://localhost:8088/mockREAttrDataExchangeOutBinding?WSDL";
    private static final String login = "";
    private static final String pass = "";

    @org.junit.Before
    public void setUp() throws Exception {
        client = new MSUIMClient(serverUrl, login, pass);
    }

    @org.junit.Test
    public void addSectionTest() throws Exception {
        Map<String, Object> result = client.init();
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

        result = client.doWork();
        assertTrue((Boolean) result.get("ok"));

        REDataExchangeAttrECD message = client.getMessage();
        Utils.marshalObject("./marshalled.xml", message);
    }

    @org.junit.Test
    public void testDoWork() throws Exception {
        client.init();
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
        GENERAL.put("DOCTYPE", "text");
        GENERAL.put("DOCGR_CODE", "text");
        GENERAL.put("DOCNUM", "text");
        GENERAL.put("DOCDATE", "20150302");
        GENERAL.put("DOCNAME", "text");
        GENERAL.put("NODOCNUM", false);
        GENERAL.put("NODOCDATE", false);
        GENERAL.put("REMARKS", "text");
        GENERAL.put("RERF", "text");
        GENERAL.put("AUTORDOC", "text");

        return GENERAL;
    }

    public Map<String, Object> getOBJECT_REFS() throws Exception {
        Map<String, Object> OBJECT_REFS = new HashMap<>();
        OBJECT_REFS.put("OBJECT_REF", "text");
        OBJECT_REFS.put("ObjCommType", "te");
        OBJECT_REFS.put("LINK", "rt");
        OBJECT_REFS.put("DOCGUID", "20150302");
        OBJECT_REFS.put("Delete", true);

        return OBJECT_REFS;
    }

    public Map<String, Object> getPARTNER_REFS() throws Exception {
        Map<String, Object> PARTNER_REFS = new HashMap<>();
        PARTNER_REFS.put("PARTNER_REF", "text");
        PARTNER_REFS.put("LINK", "rt");
        PARTNER_REFS.put("DOCGUID", "20150302");
        PARTNER_REFS.put("Delete", true);

        return PARTNER_REFS;
    }

    public Map<String, Object> getANY() throws Exception {
        Map<String, Object> ANY = new HashMap<>();
        ANY.put("CUSTOMER", "text");
        ANY.put("CHILDORG", "text");
        ANY.put("XCHILDORG", "text");
        ANY.put("PERIODBEGIN", "20150302");
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
        Header.put("LogicalSystem", "text");
        Header.put("ObjectType", "te");
        Header.put("ObjectNumber", "text");
        Header.put("ObjectNumber_ext", "text");
        Header.put("Activity", "01");
        Header.put("ObjectTypeDiff", "text");
        Header.put("Destination", "text");

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
        byte[] b =  Files.readAllBytes(file.toPath());
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
    public void getMimeTypeTest() throws Exception{
        File file = new ClassPathResource("ECMLink 10.5 SP1 - User Guide.pdf").getFile();
        String fileName = file.getName();
        String mimeType = Utils.getMimeType(fileName);
        assertNotNull(mimeType);

    }

    @org.junit.Test
    public void getServerTest() throws Exception{
        REAttrDataExchangeOut service = new REAttrDataExchangeOutService().getHTTPPort();
        assertNotNull("");

    }


}