package ru.terralink.common;//Created by Arzamastsev on 14.12.2015.

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.datatype.DatatypeConfigurationException;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import com.sun.jmx.remote.internal.ArrayQueue;

public class Utils {

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
        Date newDate =  new Date(date.getTime() + 1 * 3600 * 1000);

        DateTime dt = new DateTime(newDate);
        return new LocalDate(dt.getMillis());
    }

    public static List<byte[]> splitContent(byte[] attachmentContent) {
        int defaultChunkSize = 5 * 1024 * 1024;
        return splitContent(attachmentContent, defaultChunkSize);
    }

    public static List<byte[]> splitContent(byte[] attachmentContent, int chunkSize) {
        int len = attachmentContent.length;
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

}
