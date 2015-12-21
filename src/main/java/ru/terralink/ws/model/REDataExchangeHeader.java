
package ru.terralink.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for REDataExchangeHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="REDataExchangeHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LogicalSystem">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ObjectType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ObjectNumber">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="70"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ObjectNumber_ext" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="70"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Activity">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="01"/>
 *               &lt;enumeration value="02"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ObjectTypeDiff">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Destination">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REDataExchangeHeader", propOrder = {
        "LogicalSystem",
        "ObjectType",
        "ObjectNumber",
        "ObjectNumber_ext",
        "Activity",
        "ObjectTypeDiff",
        "Destination"
})
public class REDataExchangeHeader {

    @XmlElement(name = "LogicalSystem", required = true)
    protected String LogicalSystem;
    @XmlElement(name = "ObjectType", required = true)
    protected String ObjectType;
    @XmlElement(name = "ObjectNumber", required = true)
    protected String ObjectNumber;
    @XmlElement(name = "ObjectNumber_ext")
    protected String ObjectNumber_ext;
    @XmlElement(name = "Activity", required = true)
    protected String Activity;
    @XmlElement(name = "ObjectTypeDiff", required = true)
    protected String ObjectTypeDiff;
    @XmlElement(name = "Destination", required = true)
    protected String Destination;

    /**
     * Gets the value of the LogicalSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogicalSystem() {
        return LogicalSystem;
    }

    /**
     * Sets the value of the LogicalSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogicalSystem(String value) {
        this.LogicalSystem = value;
    }

    /**
     * Gets the value of the ObjectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectType() {
        return ObjectType;
    }

    /**
     * Sets the value of the ObjectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectType(String value) {
        this.ObjectType = value;
    }

    /**
     * Gets the value of the ObjectNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectNumber() {
        return ObjectNumber;
    }

    /**
     * Sets the value of the ObjectNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectNumber(String value) {
        this.ObjectNumber = value;
    }

    /**
     * Gets the value of the ObjectNumber_ext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectNumberExt() {
        return ObjectNumber_ext;
    }

    /**
     * Sets the value of the ObjectNumber_ext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectNumberExt(String value) {
        this.ObjectNumber_ext = value;
    }

    /**
     * Gets the value of the Activity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivity() {
        return Activity;
    }

    /**
     * Sets the value of the Activity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivity(String value) {
        this.Activity = value;
    }

    /**
     * Gets the value of the ObjectTypeDiff property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectTypeDiff() {
        return ObjectTypeDiff;
    }

    /**
     * Sets the value of the ObjectTypeDiff property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectTypeDiff(String value) {
        this.ObjectTypeDiff = value;
    }

    /**
     * Gets the value of the Destination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return Destination;
    }

    /**
     * Sets the value of the Destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.Destination = value;
    }

}
