import ru.terralink.MSUIMClient;

import java.lang.reflect.Field;
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

        Map<String, Object> result = client.init();
        assertTrue((Boolean)result.get("ok"));
    }

    @org.junit.Test
    public void testAddANYSection() throws Exception {
        String sectionName = "ANY";

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("CUSTOMER","text");
        attributes.put("CHILDORG", "text");
        attributes.put("XCHILDORG","text");
        attributes.put("PERIODBEGIN","20150302");
        attributes.put("CONSTRUCTOBJECT","text");
        attributes.put("CONSTRUCTNAME","text");
        attributes.put("PERIOD","20150302");
        attributes.put("LINKDOCNUM","text");
        attributes.put("LINKDOCDATE","20150302");
        attributes.put("SUMMA","text");
        attributes.put("CALCCURR","text");

        Map<String, Object> result = client.buildMessage(sectionName, attributes);
       // assertTrue((Boolean)result.get("ok"));
       // Map<String, Object> sections = client.getSections();

        //Object section = sections.get(sectionName);
        //assertNotNull(section);

       // Map<String, Object> result = client.buildMessage();

    }

    @org.junit.Test
    public void testOBJECT_REFSSection() throws Exception {
        String sectionName = "OBJECT_REFS";

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("OBJECT_REF","text");
        attributes.put("ObjCommType", "text");
        attributes.put("LINK","text");
        attributes.put("DOCGUID","20150302");
        attributes.put("Delete",true);

        Map<String, Object> result = client.buildMessage(sectionName, attributes);

    }
}