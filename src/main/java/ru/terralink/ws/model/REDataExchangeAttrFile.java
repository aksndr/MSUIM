
package ru.terralink.ws.model;

import org.joda.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * <p>Java class for REDataExchangeAttrFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="REDataExchangeAttrFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="File_ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Current_Part">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="All_Parts">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Current_Hash">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="All_Hash">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NOMER">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FILE_NAME">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="USERS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="USERSTXT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DATUM" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Delete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REDataExchangeAttrFile", propOrder = {
        "File_ID",
        "Current_Part",
        "All_Parts",
        "Current_Hash",
        "All_Hash",
        "NOMER",
        "FILE_NAME",
        "USERS",
        "USERSTXT",
        "DATUM",
        "Delete"
})
public class REDataExchangeAttrFile {

    @XmlElement(name = "File_ID", required = true)
    protected String File_ID;
    @XmlElement(name = "Current_Part", required = true)
    protected Integer Current_Part;
    @XmlElement(name = "All_Parts", required = true)
    protected Integer All_Parts;
    @XmlElement(name = "Current_Hash", required = true)
    protected String Current_Hash;
    @XmlElement(name = "All_Hash", required = true)
    protected String All_Hash;
    @XmlElement(name = "NOMER", required = true)
    protected Integer NOMER;
    @XmlElement(name = "FILE_NAME", required = true)
    protected String FILE_NAME;
    @XmlElement(name = "USERS")
    protected String USERS;
    @XmlElement(name = "USERSTXT")
    protected String USERSTXT;
    @XmlElement(name = "DATUM", required = true)
    //@XmlSchemaType(name = "date")
    protected LocalDate DATUM;
    @XmlElement(name = "Delete")
    protected Boolean Delete;

    /**
     * Gets the value of the File_ID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileID() {
        return File_ID;
    }

    /**
     * Sets the value of the File_ID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileID(String value) {
        this.File_ID = value;
    }

    /**
     * Gets the value of the Current_Part property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getCurrentPart() {
        return Current_Part;
    }

    /**
     * Sets the value of the Current_Part property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCurrentPart(Integer value) {
        this.Current_Part = value;
    }

    /**
     * Gets the value of the All_Parts property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getAllParts() {
        return All_Parts;
    }

    /**
     * Sets the value of the All_Parts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAllParts(Integer value) {
        this.All_Parts = value;
    }

    /**
     * Gets the value of the Current_Hash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentHash() {
        return Current_Hash;
    }

    /**
     * Sets the value of the Current_Hash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentHash(String value) {
        this.Current_Hash = value;
    }

    /**
     * Gets the value of the All_Hash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllHash() {
        return All_Hash;
    }

    /**
     * Sets the value of the All_Hash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllHash(String value) {
        this.All_Hash = value;
    }

    /**
     * Gets the value of the NOMER property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getNOMER() {
        return NOMER;
    }

    /**
     * Sets the value of the NOMER property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNOMER(Integer value) {
        this.NOMER = value;
    }

    /**
     * Gets the value of the FILE_NAME property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFILENAME() {
        return FILE_NAME;
    }

    /**
     * Sets the value of the FILE_NAME property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFILENAME(String value) {
        this.FILE_NAME = value;
    }

    /**
     * Gets the value of the USERS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERS() {
        return USERS;
    }

    /**
     * Sets the value of the USERS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERS(String value) {
        this.USERS = value;
    }

    /**
     * Gets the value of the USERSTXT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERSTXT() {
        return USERSTXT;
    }

    /**
     * Sets the value of the USERSTXT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERSTXT(String value) {
        this.USERSTXT = value;
    }

    /**
     * Gets the value of the DATUM property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public LocalDate getDATUM() {
        return DATUM;
    }

    /**
     * Sets the value of the DATUM property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATUM(LocalDate value) {
        this.DATUM = value;
    }

    /**
     * Gets the value of the Delete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDelete() {
        return Delete;
    }

    /**
     * Sets the value of the Delete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDelete(Boolean value) {
        this.Delete = value;
    }

}
