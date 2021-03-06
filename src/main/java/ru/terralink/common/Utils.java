package ru.terralink.common;//Created by Arzamastsev on 14.12.2015.

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.activation.MimetypesFileTypeMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import com.sun.jmx.remote.internal.ArrayQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class.getSimpleName());

    private static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";

    public static Date getCalendar(String s) throws ParseException, DatatypeConfigurationException {
        final DateFormat format = new SimpleDateFormat("yyyyMMdd");
        final Date date = format.parse(s);

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        return date;
    }

    public static LocalDate getLocalDate(String s) throws ParseException {
        final DateFormat format = new SimpleDateFormat("yyyyMMdd");
        final Date date = format.parse(s);
        Date newDate = new Date(date.getTime() + 1 * 3600 * 1000);

        DateTime dt = new DateTime(newDate);
        return new LocalDate(dt.getMillis());
    }

    public static XMLGregorianCalendar stringToXMLGregorianCalendar(String s)
            throws ParseException, DatatypeConfigurationException {

        XMLGregorianCalendar result = null;
        Date date;
        SimpleDateFormat simpleDateFormat;
        GregorianCalendar gregorianCalendar;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        date = simpleDateFormat.parse(s);
        gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
        gregorianCalendar.setTime(date);
        result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        result.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        result.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);

        return result;
    }

    public static List<byte[]> splitContent(byte[] attachmentContent) {
        int defaultChunkSize = getInMibs(5);
        return splitContent(attachmentContent, defaultChunkSize);
    }

    public static List<byte[]> splitContent(byte[] attachmentContent, int chunkSize) {
        int len = attachmentContent.length;
        chunkSize = getInMibs(chunkSize);
        int chunksQty = len / chunkSize;

        int start = 0;
        int end = chunkSize;

        List<byte[]> chunks = new ArrayQueue<byte[]>(chunksQty + 1);
        for (int i = 0; i <= chunksQty; i++) {
            if (end >= len) end = len;
            chunks.add(Arrays.copyOfRange(attachmentContent, start, end));
            start += chunkSize;
            end += chunkSize;
        }
        return chunks;
    }

    private static int getInMibs(int i) {
        return i * 1024 * 1024;
    }

    public static String getSha1Hash(byte[] chunk) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
            byte[] mdbytes = md.digest(chunk);

            StringBuilder sb = new StringBuilder();
            for (byte mdbyte : mdbytes) {
                sb.append(Integer.toString((mdbyte & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static void marshalObject(String xmlExportPath, Object o) {
        try {
            File file = new File(xmlExportPath);
            JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(o, file);
            jaxbMarshaller.marshal(o, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static String getMimeType(String fileName) throws IOException {
        logger.info("Start Utils GetMimeType for file " + fileName);
        if(!new ClassPathResource("mime.types").exists()){
            logger.info("MimeType file not found. Please make sure that this file has been to jar/resources.");
        }
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap(
                new ClassPathResource("mime.types").getInputStream());
        String mimeType = mimeTypesMap.getContentType(fileName);
        logger.info("Content Type : "+ mimeType);
        return mimeType == null ? DEFAULT_CONTENT_TYPE : mimeType;
    }
}
