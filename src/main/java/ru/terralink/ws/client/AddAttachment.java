package ru.terralink.ws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.terralink.common.Utils;
import ru.terralink.ws.model.REDataExchangeAttrFile;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by AzarovD on 22.01.2016.
 */

public class AddAttachment {

    @Autowired
    private ReplyHelper replyHelper;
    private List<byte[]> chunks;
    private String mimeType;
    private String contentId;
    private List<REDataExchangeAttrFile> attrFiles;

    private static final Logger logger = LoggerFactory.getLogger(AddAttachment.class.getSimpleName());

    public Map<String, Object> addAttachment(int partSize, Map<String, Object> attributes) {
        logger.info("Started addAttachment");
        if (attributes != null) {
            try {
                if (!attributes.containsKey("Content")) {
                    return replyHelper.failed("System does not received attachment content data");
                }

                byte[] content = (byte[]) attributes.get("Content");

                if (content.length <= 0) {
                    return replyHelper.failed("System does not received attachment content data");
                }
                logger.info("Attachment size: " + content.length);

                String fileName = extractStringAttribute(attributes, "FILE_NAME");
                String fileId = extractStringAttribute(attributes, "File_ID");
                BigInteger nomer = extractBigIntegerAttribute(attributes, "NOMER");
                String users = extractStringAttribute(attributes, "USERS");
                String userstxt = extractStringAttribute(attributes, "USERSTXT");
                XMLGregorianCalendar DATUM = extractXmlGregorianCalendarAttribute(attributes, "DATUM");
                Boolean Delete = extractBooleanAttribute(attributes, "Delete");

                String allHash = Utils.getSha1Hash(content);
                logger.info("allHash: " + allHash);

                setAttachmentValue(partSize, content, fileName, fileId);

                int currentPart = 1;
                BigInteger totalParts = BigInteger.valueOf(chunks.size());
                for (byte[] chunk : chunks) {
                    String currentHash = Utils.getSha1Hash(chunk);
                    REDataExchangeAttrFile attrFile = new REDataExchangeAttrFile();
                    attrFile.setFileID(fileId);
                    attrFile.setFILENAME(fileName);
                    attrFile.setNOMER(nomer);
                    attrFile.setUSERS(users);
                    attrFile.setUSERSTXT(userstxt);
                    attrFile.setDATUM(DATUM);
                    attrFile.setDelete(Delete);
                    attrFile.setCurrentPart(BigInteger.valueOf(currentPart));
                    attrFile.setCurrentHash(currentHash);
                    attrFile.setAllParts(totalParts);
                    attrFile.setAllHash(allHash);

                    getAttrFiles().add(attrFile);

                    currentPart++;
                }
            } catch (Exception e) {
                return replyHelper.failed("Error in addAttachment method. Exception: " + e.toString());
            }
        } else {
            logger.warn("Got empty attachment args.");
        }
        logger.info("Finished addAttachment\n");
        return replyHelper.succeed();
    }

    private void setAttachmentValue(int partSize, byte[] content, String fileName, String fileId) throws IOException {
        setChunks(Utils.splitContent(content, partSize));
        logger.info("chunks size: " + getChunks().size());
        setMimeType(Utils.getMimeType(fileName));
        logger.info("mimeType: " + getMimeType());
        setContentId(fileId);
        logger.info("contentId: " + getContentId());
    }

    private Boolean extractBooleanAttribute(Map<String, Object> attributes, String attrKey) {
        boolean value = attributes.containsKey(attrKey) ? (Boolean) attributes.get(attrKey) : false;
        logger.info("Attribute " + attrKey + " : " + value);
        return value;
    }

    private XMLGregorianCalendar extractXmlGregorianCalendarAttribute(Map<String, Object> attributes, String attrKey) throws ParseException, DatatypeConfigurationException {
        XMLGregorianCalendar xmlGregorianCalendar = attributes.containsKey(attrKey) ?
                Utils.stringToXMLGregorianCalendar(String.valueOf(attributes.get(attrKey))) : null;
        logger.info("Attribute " + attrKey + " : " + attrKey);
        return xmlGregorianCalendar;
    }

    private BigInteger extractBigIntegerAttribute(Map<String, Object> attributes, String attrKey) {
        BigInteger value = BigInteger.valueOf(attributes.containsKey(attrKey) ? (Integer) attributes.get(attrKey) : 0);
        logger.info("Attribute " + attrKey + " : " + value);
        return value;
    }

    private String extractStringAttribute(Map<String, Object> attributes, String attrKey) {
        String fileName = attributes.containsKey(attrKey) ? String.valueOf(attributes.get(attrKey)) : "";
        logger.info("Attribute " + attrKey + " : " + fileName);
        return fileName;
    }

    public List<byte[]> getChunks() {
        return chunks;
    }

    public void setChunks(List<byte[]> chunks) {
        this.chunks = chunks;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public List<REDataExchangeAttrFile> getAttrFiles() {
        if (attrFiles == null) {
            this.attrFiles = new ArrayList<REDataExchangeAttrFile>();
        }
        return attrFiles;
    }

    public void setAttrFiles(List<REDataExchangeAttrFile> attrFiles) {
        this.attrFiles = attrFiles;
    }
}
