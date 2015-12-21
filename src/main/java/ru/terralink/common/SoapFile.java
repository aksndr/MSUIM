package ru.terralink.common;//Created by Arzamastsev on 14.12.2015.

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlType
public class SoapFile implements Serializable {

    private String fileName;
    private byte[] bytes;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public SoapFile() {
    }

    public byte[] getFileData() {
        return bytes;
    }

    public void setFileData(byte[] dh) {
        this.bytes = dh;
    }

    public SoapFile(String fileName, byte[] dh) {
        this.fileName = fileName;
        this.bytes = dh;
    }
}