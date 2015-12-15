import ru.terralink.MSUIMClient;
import ru.terralink.common.Utils;
import ru.terralink.model.REDataExchangeAttrECD;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

//Created by Arzamastsev on 14.12.2015.
public class MSUIMClientTest {

    MSUIMClient client;

    private static final String serverUrl = "";
    private static final String login = "";
    private static final String pass = "";

    @org.junit.Before
    public void setUp() throws Exception {
        client = new MSUIMClient(serverUrl, login, pass);
    }

    @org.junit.Test
    public void addSectionTest()throws Exception {
        Map<String, Object> result = client.init();
        assertTrue((Boolean)result.get("ok"));

        result = client.addSection("OBJECT_REFS", getOBJECT_REFS());
        assertTrue((Boolean)result.get("ok"));

        result = client.addSection("PARTNER_REFS", getPARTNER_REFS());
        assertTrue((Boolean)result.get("ok"));

        result = client.addSection("ANY", getANY());
        assertTrue((Boolean)result.get("ok"));

        result = client.addSection("GENERAL", getGENERAL());
        assertTrue((Boolean)result.get("ok"));

        result = client.addSection("Header", getHeader());
        assertTrue((Boolean)result.get("ok"));

        result = client.addAttachment(getAttrFile());
        assertTrue((Boolean)result.get("ok"));

        REDataExchangeAttrECD message = client.getMessage();
        Utils.marshalObject("./marshalled.xml", message);

    }

    public Map<String, Object> getGENERAL() throws Exception {
        Map<String, Object> GENERAL = new HashMap<>();
        GENERAL.put("DOCTYPE","text");
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
        OBJECT_REFS.put("OBJECT_REF","text");
        OBJECT_REFS.put("ObjCommType", "te");
        OBJECT_REFS.put("LINK","rt");
        OBJECT_REFS.put("DOCGUID","20150302");
        OBJECT_REFS.put("Delete",true);

        return OBJECT_REFS;
    }

    public Map<String, Object> getPARTNER_REFS() throws Exception {
        Map<String, Object> PARTNER_REFS = new HashMap<>();
        PARTNER_REFS.put("PARTNER_REF","text");
        PARTNER_REFS.put("LINK","rt");
        PARTNER_REFS.put("DOCGUID","20150302");
        PARTNER_REFS.put("Delete",true);

        return PARTNER_REFS;
    }

    public Map<String, Object> getANY() throws Exception {
        Map<String, Object> ANY = new HashMap<>();
        ANY.put("CUSTOMER","text");
        ANY.put("CHILDORG", "text");
        ANY.put("XCHILDORG","text");
        ANY.put("PERIODBEGIN","20150302");
        ANY.put("CONSTRUCTOBJECT","text");
        ANY.put("CONSTRUCTNAME","text");
        ANY.put("PERIOD","20150302");
        ANY.put("LINKDOCNUM","text");
        ANY.put("LINKDOCDATE","20150302");
        ANY.put("SUMMA","text");
        ANY.put("CALCCURR","text");

        return ANY;
    }

    public Map<String, Object> getHeader() throws Exception {
        Map<String, Object> Header = new HashMap<>();
        Header.put("LogicalSystem","text");
        Header.put("ObjectType","te");
        Header.put("ObjectNumber","text");
        Header.put("ObjectNumber_ext","text");
        Header.put("Activity","01");
        Header.put("ObjectTypeDiff","text");
        Header.put("Destination","text");

        return Header;
    }

    public Map<String, Object> getAttrFile() throws Exception {

        File file = new File("D:\\temp\\Test files\\css.pdf");

        Map<String, Object> AttrFile = new HashMap<>();
        AttrFile.put("File_ID","4673");
        AttrFile.put("NOMER",12);
        AttrFile.put("FILE_NAME",file.getName());
        AttrFile.put("USERS","text");
        AttrFile.put("USERSTXT","text");
        AttrFile.put("DATUM","19470202");
        AttrFile.put("CONTENT", Files.readAllBytes(file.toPath()));
        AttrFile.put("Delete",false);

        return AttrFile;
    }

}