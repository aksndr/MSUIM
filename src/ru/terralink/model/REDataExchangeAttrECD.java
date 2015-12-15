
package ru.terralink.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import org.joda.time.LocalDate;


/**
 * <p>Java class for REDataExchangeAttrECD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="REDataExchangeAttrECD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://inform.gazprom.ru/C/SUIM/REDataExchange}REDataExchangeHeader"/>
 *         &lt;element name="OBJECT_REFS" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OBJECT_REF">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="70"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ObjCommType" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LINK" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DOCGUID" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="32"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Delete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PARTNER_REFS" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PARTNER_REF">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LINK" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DOCGUID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="32"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Delete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="GENERAL">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DOCTYPE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DOCGR_CODE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="12"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DOCNUM">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DOCDATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="DOCNAME" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="NODOCNUM" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="NODOCDATE" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="REMARKS" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RERF">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="12"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AUTORDOC">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CONTRACT" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BP1">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="10"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XBP1">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BP2">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="10"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XBP2">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECNBEG" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="RECNEND1ST" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="RECNREGDJR" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="RECNREGJR" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="30"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECNREGDCH" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="RECNNRCH" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="40"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECNREGST" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="80"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECNREGDST" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FINDOC" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RECNNREXT">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="50"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XCHILDORG" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECND" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="AJAHR" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECNTYPE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="80"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="SUMMA" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="18"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TAXAMOUNT" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="18"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CALCCURR" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="5"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DESCRIPTION" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LETTERS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CHILDORG1">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="10"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XCHILDORG1">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="SENDERFIO">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CHILDORG2">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="10"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XCHILDORG2">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECEIVERFIO" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DESCRIPTION" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="SUMMA" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="18"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CALCCURR" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="5"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ANY" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CUSTOMER">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CHILDORG">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XCHILDORG">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PERIODBEGIN" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="CONSTRUCTOBJECT" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CONSTRUCTNAME" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PERIOD" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="LINKDOCNUM" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LINKDOCDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="SUMMA" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="18"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CALCCURR" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="5"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ACTS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BP1">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XBP1">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BP2">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XBP2">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECVDOCNUM" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="250"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECVDOCDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="KADASTRNUM" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="KPD" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LAWSUBJECT">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XLAWSUBJECT">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XOLTYPE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="24"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OLTYPE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="REGNUM">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="24"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="REGDATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="CERTSER">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="5"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CERTNUM">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CERTDATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="CHILDORG">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XCHILDORG">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XOBJOFLAW">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="KADASTRNUM" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XLAWTYPE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LAWTYPE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="INVENTORNUM" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BP1" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="10"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RECNREGOROLD" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DFV" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MANAGING_SUBJEC">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="10"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XMANAGING_SUBJEC" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BUKRS" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="REGDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="REGNUM" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DOCNUM" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DOCDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="DOCNAME" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="NODOCNUM" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="NODOCDATE" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="REMARKS" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="REGORGAN" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DESCRIPTION" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NNA" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CHILDORG1">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XCHILDORG1">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OBJNAME" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OBJPLACE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="KADASTRNUM" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OGRN" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="250"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="EGRJLDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="EGRPDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="EGRPNUM" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="24"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CCC" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RATINGOBJECT">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ESTIMATEDORG" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="12"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="XESTIMATEDORG" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="400"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BONIA" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="WAY_RELSAPER_ID" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="COORDINAT_PAGE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ANCHOR" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AttrFile" type="{http://inform.gazprom.ru/C/SUIM/REDataExchange}REDataExchangeAttrFile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REDataExchangeAttrECD", propOrder = {
        "Header",
        "OBJECT_REFS",
        "PARTNER_REFS",
        "GENERAL",
        "CONTRACT",
        "FINDOC",
        "LETTERS",
        "ANY",
        "ACTS",
        "KPD",
        "DFV",
        "NNA",
        "CCC",
        "BONIA",
        "AttrFile"
})
@XmlRootElement(name = "REAttrDataExchangeMessage")
public class REDataExchangeAttrECD {

    @XmlElement(name = "Header", required = true)
    protected REDataExchangeHeader Header;
    @XmlElement(name = "OBJECT_REFS")
    protected List<REDataExchangeAttrECD.OBJECT_REFS> OBJECT_REFS;
    @XmlElement(name = "PARTNER_REFS")
    protected List<REDataExchangeAttrECD.PARTNER_REFS> PARTNER_REFS;
    @XmlElement(name = "GENERAL", required = true)
    protected REDataExchangeAttrECD.GENERAL GENERAL;
    @XmlElement(name = "CONTRACT")
    protected REDataExchangeAttrECD.CONTRACT CONTRACT;
    @XmlElement(name = "FINDOC")
    protected REDataExchangeAttrECD.FINDOC FINDOC;
    @XmlElement(name = "LETTERS")
    protected REDataExchangeAttrECD.LETTERS LETTERS;
    @XmlElement(name = "ANY")
    protected REDataExchangeAttrECD.ANY ANY;
    @XmlElement(name = "ACTS")
    protected REDataExchangeAttrECD.ACTS ACTS;
    @XmlElement(name = "KPD")
    protected REDataExchangeAttrECD.KPD KPD;
    @XmlElement(name = "DFV")
    protected REDataExchangeAttrECD.DFV DFV;
    @XmlElement(name = "NNA")
    protected REDataExchangeAttrECD.NNA NNA;
    @XmlElement(name = "CCC")
    protected REDataExchangeAttrECD.CCC CCC;
    @XmlElement(name = "BONIA")
    protected REDataExchangeAttrECD.BONIA BONIA;
    @XmlElement(name = "AttrFile")
    protected List<REDataExchangeAttrFile> AttrFile;

    /**
     * Gets the value of the Header property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeHeader }
     *     
     */
    public REDataExchangeHeader getHeader() {
        return Header;
    }

    /**
     * Sets the value of the Header property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeHeader }
     *     
     */
    public void setHeader(REDataExchangeHeader value) {
        this.Header = value;
    }

    /**
     * Gets the value of the OBJECT_REFS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore ANY modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the OBJECT_REFS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOBJECTREFS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link REDataExchangeAttrECD.OBJECT_REFS }
     * 
     * 
     */
    public List<REDataExchangeAttrECD.OBJECT_REFS> getOBJECTREFS() {
        if (OBJECT_REFS == null) {
            OBJECT_REFS = new ArrayList<REDataExchangeAttrECD.OBJECT_REFS>();
        }
        return this.OBJECT_REFS;
    }

    public void setOBJECT_REFS(Object object_refs) {
        this.getOBJECTREFS().add((REDataExchangeAttrECD.OBJECT_REFS)object_refs);
    }

    public void setPARTNER_REFS(Object partner_refs) {
        this.getPARTNERREFS().add((REDataExchangeAttrECD.PARTNER_REFS)partner_refs);
    }

    public void addAttrFile(REDataExchangeAttrFile attrFile) {
        this.getAttrFile().add(attrFile);
    }

    /**
     * Gets the value of the PARTNER_REFS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore ANY modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the PARTNER_REFS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPARTNERREFS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link REDataExchangeAttrECD.PARTNER_REFS }
     * 
     * 
     */
    public List<REDataExchangeAttrECD.PARTNER_REFS> getPARTNERREFS() {
        if (PARTNER_REFS == null) {
            PARTNER_REFS = new ArrayList<REDataExchangeAttrECD.PARTNER_REFS>();
        }
        return this.PARTNER_REFS;
    }

    /**
     * Gets the value of the GENERAL property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.GENERAL }
     *     
     */
    public REDataExchangeAttrECD.GENERAL getGENERAL() {
        return GENERAL;
    }

    /**
     * Sets the value of the GENERAL property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.GENERAL }
     *     
     */
    public void setGENERAL(REDataExchangeAttrECD.GENERAL value) {
        this.GENERAL = value;
    }

    /**
     * Gets the value of the CONTRACT property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.CONTRACT }
     *     
     */
    public REDataExchangeAttrECD.CONTRACT getCONTRACT() {
        return CONTRACT;
    }

    /**
     * Sets the value of the CONTRACT property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.CONTRACT }
     *     
     */
    public void setCONTRACT(REDataExchangeAttrECD.CONTRACT value) {
        this.CONTRACT = value;
    }

    /**
     * Gets the value of the FINDOC property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.FINDOC }
     *     
     */
    public REDataExchangeAttrECD.FINDOC getFINDOC() {
        return FINDOC;
    }

    /**
     * Sets the value of the FINDOC property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.FINDOC }
     *     
     */
    public void setFINDOC(REDataExchangeAttrECD.FINDOC value) {
        this.FINDOC = value;
    }

    /**
     * Gets the value of the LETTERS property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.LETTERS }
     *     
     */
    public REDataExchangeAttrECD.LETTERS getLETTERS() {
        return LETTERS;
    }

    /**
     * Sets the value of the LETTERS property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.LETTERS }
     *     
     */
    public void setLETTERS(REDataExchangeAttrECD.LETTERS value) {
        this.LETTERS = value;
    }

    /**
     * Gets the value of the ANY property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.ANY }
     *     
     */
    public REDataExchangeAttrECD.ANY getANY() {
        return ANY;
    }

    /**
     * Sets the value of the ANY property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.ANY }
     *     
     */
    public void setANY(REDataExchangeAttrECD.ANY value) {
        this.ANY = value;
    }

    /**
     * Gets the value of the ACTS property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.ACTS }
     *     
     */
    public REDataExchangeAttrECD.ACTS getACTS() {
        return ACTS;
    }

    /**
     * Sets the value of the ACTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.ACTS }
     *     
     */
    public void setACTS(REDataExchangeAttrECD.ACTS value) {
        this.ACTS = value;
    }

    /**
     * Gets the value of the KPD property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.KPD }
     *     
     */
    public REDataExchangeAttrECD.KPD getKPD() {
        return KPD;
    }

    /**
     * Sets the value of the KPD property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.KPD }
     *     
     */
    public void setKPD(REDataExchangeAttrECD.KPD value) {
        this.KPD = value;
    }

    /**
     * Gets the value of the DFV property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.DFV }
     *     
     */
    public REDataExchangeAttrECD.DFV getDFV() {
        return DFV;
    }

    /**
     * Sets the value of the DFV property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.DFV }
     *     
     */
    public void setDFV(REDataExchangeAttrECD.DFV value) {
        this.DFV = value;
    }

    /**
     * Gets the value of the NNA property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.NNA }
     *     
     */
    public REDataExchangeAttrECD.NNA getNNA() {
        return NNA;
    }

    /**
     * Sets the value of the NNA property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.NNA }
     *     
     */
    public void setNNA(REDataExchangeAttrECD.NNA value) {
        this.NNA = value;
    }

    /**
     * Gets the value of the CCC property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.CCC }
     *     
     */
    public REDataExchangeAttrECD.CCC getCCC() {
        return CCC;
    }

    /**
     * Sets the value of the CCC property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.CCC }
     *     
     */
    public void setCCC(REDataExchangeAttrECD.CCC value) {
        this.CCC = value;
    }

    /**
     * Gets the value of the BONIA property.
     * 
     * @return
     *     possible object is
     *     {@link REDataExchangeAttrECD.BONIA }
     *     
     */
    public REDataExchangeAttrECD.BONIA getBONIA() {
        return BONIA;
    }

    /**
     * Sets the value of the BONIA property.
     * 
     * @param value
     *     allowed object is
     *     {@link REDataExchangeAttrECD.BONIA }
     *     
     */
    public void setBONIA(REDataExchangeAttrECD.BONIA value) {
        this.BONIA = value;
    }

    /**
     * Gets the value of the AttrFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore ANY modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the AttrFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttrFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link REDataExchangeAttrFile }
     * 
     * 
     */
    public List<REDataExchangeAttrFile> getAttrFile() {
        if (AttrFile == null) {
            AttrFile = new ArrayList<REDataExchangeAttrFile>();
        }
        return this.AttrFile;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BP1">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XBP1">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BP2">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XBP2">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECVDOCNUM" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="250"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECVDOCDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="KADASTRNUM" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
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
    @XmlType(name = "", propOrder = {
            "BP1",
            "XBP1",
            "BP2",
            "XBP2",
            "RECVDOCNUM",
            "RECVDOCDATE",
            "KADASTRNUM"
    })
    public static class ACTS {

        @XmlElement(name = "BP1", required = true)
        protected String BP1;
        @XmlElement(name = "XBP1", required = true)
        protected String XBP1;
        @XmlElement(name = "BP2", required = true)
        protected String BP2;
        @XmlElement(name = "XBP2", required = true)
        protected String XBP2;
        @XmlElement(name = "RECVDOCNUM")
        protected String RECVDOCNUM;
        @XmlElement(name = "RECVDOCDATE")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar RECVDOCDATE;
        @XmlElement(name = "KADASTRNUM")
        protected String KADASTRNUM;

        /**
         * Gets the value of the BP1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBP1() {
            return BP1;
        }

        /**
         * Sets the value of the BP1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBP1(String value) {
            this.BP1 = value;
        }

        /**
         * Gets the value of the XBP1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXBP1() {
            return XBP1;
        }

        /**
         * Sets the value of the XBP1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXBP1(String value) {
            this.XBP1 = value;
        }

        /**
         * Gets the value of the BP2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBP2() {
            return BP2;
        }

        /**
         * Sets the value of the BP2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBP2(String value) {
            this.BP2 = value;
        }

        /**
         * Gets the value of the XBP2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXBP2() {
            return XBP2;
        }

        /**
         * Sets the value of the XBP2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXBP2(String value) {
            this.XBP2 = value;
        }

        /**
         * Gets the value of the RECVDOCNUM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECVDOCNUM() {
            return RECVDOCNUM;
        }

        /**
         * Sets the value of the RECVDOCNUM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECVDOCNUM(String value) {
            this.RECVDOCNUM = value;
        }

        /**
         * Gets the value of the RECVDOCDATE property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRECVDOCDATE() {
            return RECVDOCDATE;
        }

        /**
         * Sets the value of the RECVDOCDATE property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRECVDOCDATE(XMLGregorianCalendar value) {
            this.RECVDOCDATE = value;
        }

        /**
         * Gets the value of the KADASTRNUM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKADASTRNUM() {
            return KADASTRNUM;
        }

        /**
         * Sets the value of the KADASTRNUM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKADASTRNUM(String value) {
            this.KADASTRNUM = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CUSTOMER">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CHILDORG">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XCHILDORG">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PERIODBEGIN" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="CONSTRUCTOBJECT" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CONSTRUCTNAME" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PERIOD" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="LINKDOCNUM" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LINKDOCDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="SUMMA" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="18"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CALCCURR" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="5"/>
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
    @XmlType(name = "", propOrder = {
            "CUSTOMER",
            "CHILDORG",
            "XCHILDORG",
            "PERIODBEGIN",
            "CONSTRUCTOBJECT",
            "CONSTRUCTNAME",
            "PERIOD",
            "LINKDOCNUM",
            "LINKDOCDATE",
            "SUMMA",
            "CALCCURR"
    })
    public static class ANY {

        @XmlElement(name = "CUSTOMER", required = true)
        protected String CUSTOMER;
        @XmlElement(name = "CHILDORG", required = true)
        protected String CHILDORG;
        @XmlElement(name = "XCHILDORG", required = true)
        protected String XCHILDORG;
        @XmlElement(name = "PERIODBEGIN", required = true)
        //@XmlSchemaType(name = "date")
        protected LocalDate PERIODBEGIN;
        @XmlElement(name = "CONSTRUCTOBJECT")
        protected String CONSTRUCTOBJECT;
        @XmlElement(name = "CONSTRUCTNAME")
        protected String CONSTRUCTNAME;
        @XmlElement(name = "PERIOD")
//        @XmlSchemaType(name = "date")
        protected LocalDate PERIOD;
        @XmlElement(name = "LINKDOCNUM")
        protected String LINKDOCNUM;
        @XmlElement(name = "LINKDOCDATE")
//        @XmlSchemaType(name = "date")
        protected LocalDate LINKDOCDATE;
        @XmlElement(name = "SUMMA")
        protected String SUMMA;
        @XmlElement(name = "CALCCURR")
        protected String CALCCURR;

        /**
         * Gets the value of the CUSTOMER property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCUSTOMER() {
            return CUSTOMER;
        }

        /**
         * Sets the value of the CUSTOMER property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCUSTOMER(String value) {
            this.CUSTOMER = value;
        }

        /**
         * Gets the value of the CHILDORG property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCHILDORG() {
            return CHILDORG;
        }

        /**
         * Sets the value of the CHILDORG property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCHILDORG(String value) {
            this.CHILDORG = value;
        }

        /**
         * Gets the value of the XCHILDORG property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXCHILDORG() {
            return XCHILDORG;
        }

        /**
         * Sets the value of the XCHILDORG property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXCHILDORG(String value) {
            this.XCHILDORG = value;
        }

        /**
         * Gets the value of the PERIODBEGIN property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public LocalDate getPERIODBEGIN() {
            return PERIODBEGIN;
        }

        /**
         * Sets the value of the PERIODBEGIN property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setPERIODBEGIN(LocalDate value) {
            this.PERIODBEGIN = value;
        }

        /**
         * Gets the value of the CONSTRUCTOBJECT property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCONSTRUCTOBJECT() {
            return CONSTRUCTOBJECT;
        }

        /**
         * Sets the value of the CONSTRUCTOBJECT property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCONSTRUCTOBJECT(String value) {
            this.CONSTRUCTOBJECT = value;
        }

        /**
         * Gets the value of the CONSTRUCTNAME property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCONSTRUCTNAME() {
            return CONSTRUCTNAME;
        }

        /**
         * Sets the value of the CONSTRUCTNAME property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCONSTRUCTNAME(String value) {
            this.CONSTRUCTNAME = value;
        }

        /**
         * Gets the value of the PERIOD property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public LocalDate getPERIOD() {
            return PERIOD;
        }

        /**
         * Sets the value of the PERIOD property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setPERIOD(LocalDate value) {
            this.PERIOD = value;
        }

        /**
         * Gets the value of the LINKDOCNUM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLINKDOCNUM() {
            return LINKDOCNUM;
        }

        /**
         * Sets the value of the LINKDOCNUM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLINKDOCNUM(String value) {
            this.LINKDOCNUM = value;
        }

        /**
         * Gets the value of the LINKDOCDATE property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public LocalDate getLINKDOCDATE() {
            return LINKDOCDATE;
        }

        /**
         * Sets the value of the LINKDOCDATE property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLINKDOCDATE(LocalDate value) {
            this.LINKDOCDATE = value;
        }

        /**
         * Gets the value of the SUMMA property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSUMMA() {
            return SUMMA;
        }

        /**
         * Sets the value of the SUMMA property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSUMMA(String value) {
            this.SUMMA = value;
        }

        /**
         * Gets the value of the CALCCURR property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCALCCURR() {
            return CALCCURR;
        }

        /**
         * Sets the value of the CALCCURR property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCALCCURR(String value) {
            this.CALCCURR = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="WAY_RELSAPER_ID" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="COORDINAT_PAGE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ANCHOR" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
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
    @XmlType(name = "", propOrder = {
        "wayrelsaperid",
        "coordinatpage",
        "anchor"
    })
    public static class BONIA {

        @XmlElement(name = "WAY_RELSAPER_ID")
        protected String wayrelsaperid;
        @XmlElement(name = "COORDINAT_PAGE")
        protected String coordinatpage;
        @XmlElement(name = "ANCHOR")
        protected String anchor;

        /**
         * Gets the value of the wayrelsaperid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWAYRELSAPERID() {
            return wayrelsaperid;
        }

        /**
         * Sets the value of the wayrelsaperid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWAYRELSAPERID(String value) {
            this.wayrelsaperid = value;
        }

        /**
         * Gets the value of the coordinatpage property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOORDINATPAGE() {
            return coordinatpage;
        }

        /**
         * Sets the value of the coordinatpage property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOORDINATPAGE(String value) {
            this.coordinatpage = value;
        }

        /**
         * Gets the value of the anchor property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getANCHOR() {
            return anchor;
        }

        /**
         * Sets the value of the anchor property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setANCHOR(String value) {
            this.anchor = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="RATINGOBJECT">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ESTIMATEDORG" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="12"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XESTIMATEDORG" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
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
    @XmlType(name = "", propOrder = {
        "ratingobject",
        "estimatedorg",
        "xestimatedorg"
    })
    public static class CCC {

        @XmlElement(name = "RATINGOBJECT", required = true)
        protected String ratingobject;
        @XmlElement(name = "ESTIMATEDORG")
        protected String estimatedorg;
        @XmlElement(name = "XESTIMATEDORG")
        protected String xestimatedorg;

        /**
         * Gets the value of the ratingobject property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRATINGOBJECT() {
            return ratingobject;
        }

        /**
         * Sets the value of the ratingobject property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRATINGOBJECT(String value) {
            this.ratingobject = value;
        }

        /**
         * Gets the value of the estimatedorg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getESTIMATEDORG() {
            return estimatedorg;
        }

        /**
         * Sets the value of the estimatedorg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setESTIMATEDORG(String value) {
            this.estimatedorg = value;
        }

        /**
         * Gets the value of the xestimatedorg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXESTIMATEDORG() {
            return xestimatedorg;
        }

        /**
         * Sets the value of the xestimatedorg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXESTIMATEDORG(String value) {
            this.xestimatedorg = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BP1">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="10"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XBP1">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BP2">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="10"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XBP2">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECNBEG" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="RECNEND1ST" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="RECNREGDJR" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="RECNREGJR" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECNREGDCH" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="RECNNRCH" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="40"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECNREGST" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="80"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECNREGDST" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bp1",
        "xbp1",
        "bp2",
        "xbp2",
        "recnbeg",
        "recnend1ST",
        "recnregdjr",
        "recnregjr",
        "recnregdch",
        "recnnrch",
        "recnregst",
        "recnregdst"
    })
    public static class CONTRACT {

        @XmlElement(name = "BP1", required = true)
        protected String bp1;
        @XmlElement(name = "XBP1", required = true)
        protected String xbp1;
        @XmlElement(name = "BP2", required = true)
        protected String bp2;
        @XmlElement(name = "XBP2", required = true)
        protected String xbp2;
        @XmlElement(name = "RECNBEG")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar recnbeg;
        @XmlElement(name = "RECNEND1ST")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar recnend1ST;
        @XmlElement(name = "RECNREGDJR")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar recnregdjr;
        @XmlElement(name = "RECNREGJR")
        protected String recnregjr;
        @XmlElement(name = "RECNREGDCH")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar recnregdch;
        @XmlElement(name = "RECNNRCH")
        protected String recnnrch;
        @XmlElement(name = "RECNREGST")
        protected String recnregst;
        @XmlElement(name = "RECNREGDST")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar recnregdst;

        /**
         * Gets the value of the BP1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBP1() {
            return bp1;
        }

        /**
         * Sets the value of the BP1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBP1(String value) {
            this.bp1 = value;
        }

        /**
         * Gets the value of the XBP1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXBP1() {
            return xbp1;
        }

        /**
         * Sets the value of the XBP1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXBP1(String value) {
            this.xbp1 = value;
        }

        /**
         * Gets the value of the BP2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBP2() {
            return bp2;
        }

        /**
         * Sets the value of the BP2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBP2(String value) {
            this.bp2 = value;
        }

        /**
         * Gets the value of the XBP2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXBP2() {
            return xbp2;
        }

        /**
         * Sets the value of the XBP2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXBP2(String value) {
            this.xbp2 = value;
        }

        /**
         * Gets the value of the recnbeg property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRECNBEG() {
            return recnbeg;
        }

        /**
         * Sets the value of the recnbeg property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRECNBEG(XMLGregorianCalendar value) {
            this.recnbeg = value;
        }

        /**
         * Gets the value of the recnend1ST property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRECNEND1ST() {
            return recnend1ST;
        }

        /**
         * Sets the value of the recnend1ST property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRECNEND1ST(XMLGregorianCalendar value) {
            this.recnend1ST = value;
        }

        /**
         * Gets the value of the recnregdjr property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRECNREGDJR() {
            return recnregdjr;
        }

        /**
         * Sets the value of the recnregdjr property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRECNREGDJR(XMLGregorianCalendar value) {
            this.recnregdjr = value;
        }

        /**
         * Gets the value of the recnregjr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECNREGJR() {
            return recnregjr;
        }

        /**
         * Sets the value of the recnregjr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECNREGJR(String value) {
            this.recnregjr = value;
        }

        /**
         * Gets the value of the recnregdch property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRECNREGDCH() {
            return recnregdch;
        }

        /**
         * Sets the value of the recnregdch property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRECNREGDCH(XMLGregorianCalendar value) {
            this.recnregdch = value;
        }

        /**
         * Gets the value of the recnnrch property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECNNRCH() {
            return recnnrch;
        }

        /**
         * Sets the value of the recnnrch property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECNNRCH(String value) {
            this.recnnrch = value;
        }

        /**
         * Gets the value of the recnregst property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECNREGST() {
            return recnregst;
        }

        /**
         * Sets the value of the recnregst property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECNREGST(String value) {
            this.recnregst = value;
        }

        /**
         * Gets the value of the recnregdst property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRECNREGDST() {
            return recnregdst;
        }

        /**
         * Sets the value of the recnregdst property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRECNREGDST(XMLGregorianCalendar value) {
            this.recnregdst = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="MANAGING_SUBJEC">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="10"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XMANAGING_SUBJEC" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BUKRS" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="REGDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="REGNUM" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DOCNUM" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DOCDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="DOCNAME" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="NODOCNUM" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="NODOCDATE" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="REMARKS" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="REGORGAN" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DESCRIPTION" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
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
    @XmlType(name = "", propOrder = {
        "managingsubjec",
        "xmanagingsubjec",
        "bukrs",
        "regdate",
        "regnum",
        "docnum",
        "docdate",
        "docname",
        "nodocnum",
        "nodocdate",
        "remarks",
        "regorgan",
        "description"
    })
    public static class DFV {

        @XmlElement(name = "MANAGING_SUBJEC", required = true)
        protected String managingsubjec;
        @XmlElement(name = "XMANAGING_SUBJEC")
        protected String xmanagingsubjec;
        @XmlElement(name = "BUKRS")
        protected String bukrs;
        @XmlElement(name = "REGDATE")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar regdate;
        @XmlElement(name = "REGNUM")
        protected String regnum;
        @XmlElement(name = "DOCNUM")
        protected String docnum;
        @XmlElement(name = "DOCDATE")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar docdate;
        @XmlElement(name = "DOCNAME")
        protected String docname;
        @XmlElement(name = "NODOCNUM")
        protected Boolean nodocnum;
        @XmlElement(name = "NODOCDATE")
        protected Boolean nodocdate;
        @XmlElement(name = "REMARKS")
        protected String remarks;
        @XmlElement(name = "REGORGAN")
        protected String regorgan;
        @XmlElement(name = "DESCRIPTION")
        protected String description;

        /**
         * Gets the value of the managingsubjec property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMANAGINGSUBJEC() {
            return managingsubjec;
        }

        /**
         * Sets the value of the managingsubjec property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMANAGINGSUBJEC(String value) {
            this.managingsubjec = value;
        }

        /**
         * Gets the value of the xmanagingsubjec property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXMANAGINGSUBJEC() {
            return xmanagingsubjec;
        }

        /**
         * Sets the value of the xmanagingsubjec property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXMANAGINGSUBJEC(String value) {
            this.xmanagingsubjec = value;
        }

        /**
         * Gets the value of the bukrs property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBUKRS() {
            return bukrs;
        }

        /**
         * Sets the value of the bukrs property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBUKRS(String value) {
            this.bukrs = value;
        }

        /**
         * Gets the value of the regdate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getREGDATE() {
            return regdate;
        }

        /**
         * Sets the value of the regdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setREGDATE(XMLGregorianCalendar value) {
            this.regdate = value;
        }

        /**
         * Gets the value of the regnum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREGNUM() {
            return regnum;
        }

        /**
         * Sets the value of the regnum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREGNUM(String value) {
            this.regnum = value;
        }

        /**
         * Gets the value of the DOCNUM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDOCNUM() {
            return docnum;
        }

        /**
         * Sets the value of the DOCNUM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDOCNUM(String value) {
            this.docnum = value;
        }

        /**
         * Gets the value of the DOCDATE property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDOCDATE() {
            return docdate;
        }

        /**
         * Sets the value of the DOCDATE property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDOCDATE(XMLGregorianCalendar value) {
            this.docdate = value;
        }

        /**
         * Gets the value of the DOCNAME property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDOCNAME() {
            return docname;
        }

        /**
         * Sets the value of the DOCNAME property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDOCNAME(String value) {
            this.docname = value;
        }

        /**
         * Gets the value of the NODOCNUM property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNODOCNUM() {
            return nodocnum;
        }

        /**
         * Sets the value of the NODOCNUM property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNODOCNUM(Boolean value) {
            this.nodocnum = value;
        }

        /**
         * Gets the value of the NODOCDATE property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNODOCDATE() {
            return nodocdate;
        }

        /**
         * Sets the value of the NODOCDATE property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNODOCDATE(Boolean value) {
            this.nodocdate = value;
        }

        /**
         * Gets the value of the REMARKS property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARKS() {
            return remarks;
        }

        /**
         * Sets the value of the REMARKS property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARKS(String value) {
            this.remarks = value;
        }

        /**
         * Gets the value of the regorgan property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREGORGAN() {
            return regorgan;
        }

        /**
         * Sets the value of the regorgan property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREGORGAN(String value) {
            this.regorgan = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCRIPTION() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCRIPTION(String value) {
            this.description = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="RECNNREXT">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="50"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XCHILDORG" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECND" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="AJAHR" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECNTYPE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="80"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="SUMMA" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="18"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TAXAMOUNT" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="18"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CALCCURR" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="5"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DESCRIPTION" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
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
    @XmlType(name = "", propOrder = {
        "recnnrext",
        "xchildorg",
        "recnd",
        "ajahr",
        "recntype",
        "summa",
        "taxamount",
        "calccurr",
        "description"
    })
    public static class FINDOC {

        @XmlElement(name = "RECNNREXT", required = true)
        protected String recnnrext;
        @XmlElement(name = "XCHILDORG")
        protected String xchildorg;
        @XmlElement(name = "RECND", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar recnd;
        @XmlElement(name = "AJAHR")
        protected String ajahr;
        @XmlElement(name = "RECNTYPE", required = true)
        protected String recntype;
        @XmlElement(name = "SUMMA")
        protected String summa;
        @XmlElement(name = "TAXAMOUNT")
        protected String taxamount;
        @XmlElement(name = "CALCCURR")
        protected String calccurr;
        @XmlElement(name = "DESCRIPTION")
        protected String description;

        /**
         * Gets the value of the recnnrext property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECNNREXT() {
            return recnnrext;
        }

        /**
         * Sets the value of the recnnrext property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECNNREXT(String value) {
            this.recnnrext = value;
        }

        /**
         * Gets the value of the XCHILDORG property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXCHILDORG() {
            return xchildorg;
        }

        /**
         * Sets the value of the XCHILDORG property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXCHILDORG(String value) {
            this.xchildorg = value;
        }

        /**
         * Gets the value of the recnd property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRECND() {
            return recnd;
        }

        /**
         * Sets the value of the recnd property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRECND(XMLGregorianCalendar value) {
            this.recnd = value;
        }

        /**
         * Gets the value of the ajahr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAJAHR() {
            return ajahr;
        }

        /**
         * Sets the value of the ajahr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAJAHR(String value) {
            this.ajahr = value;
        }

        /**
         * Gets the value of the recntype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECNTYPE() {
            return recntype;
        }

        /**
         * Sets the value of the recntype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECNTYPE(String value) {
            this.recntype = value;
        }

        /**
         * Gets the value of the SUMMA property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSUMMA() {
            return summa;
        }

        /**
         * Sets the value of the SUMMA property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSUMMA(String value) {
            this.summa = value;
        }

        /**
         * Gets the value of the taxamount property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTAXAMOUNT() {
            return taxamount;
        }

        /**
         * Sets the value of the taxamount property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTAXAMOUNT(String value) {
            this.taxamount = value;
        }

        /**
         * Gets the value of the CALCCURR property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCALCCURR() {
            return calccurr;
        }

        /**
         * Sets the value of the CALCCURR property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCALCCURR(String value) {
            this.calccurr = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCRIPTION() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCRIPTION(String value) {
            this.description = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DOCTYPE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DOCGR_CODE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="12"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DOCNUM">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DOCDATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="DOCNAME" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="NODOCNUM" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="NODOCDATE" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="REMARKS" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RERF">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="12"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AUTORDOC">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
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
    @XmlType(name = "", propOrder = {
            "DOCTYPE",
            "DOCGR_CODE",
            "DOCNUM",
            "DOCDATE",
            "DOCNAME",
            "NODOCNUM",
            "NODOCDATE",
            "REMARKS",
            "RERF",
            "AUTORDOC"
    })
    public static class GENERAL {

        @XmlElement(name = "DOCTYPE", required = true)
        protected String DOCTYPE;
        @XmlElement(name = "DOCGR_CODE", required = true)
        protected String DOCGR_CODE;
        @XmlElement(name = "DOCNUM", required = true)
        protected String DOCNUM;
        @XmlElement(name = "DOCDATE", required = true)
        //@XmlSchemaType(name = "date")
        protected LocalDate DOCDATE;
        @XmlElement(name = "DOCNAME")
        protected String DOCNAME;
        @XmlElement(name = "NODOCNUM")
        protected Boolean NODOCNUM;
        @XmlElement(name = "NODOCDATE")
        protected Boolean NODOCDATE;
        @XmlElement(name = "REMARKS")
        protected String REMARKS;
        @XmlElement(name = "RERF", required = true)
        protected String RERF;
        @XmlElement(name = "AUTORDOC", required = true)
        protected String AUTORDOC;

        /**
         * Gets the value of the DOCTYPE property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDOCTYPE() {
            return DOCTYPE;
        }

        /**
         * Sets the value of the DOCTYPE property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDOCTYPE(String value) {
            this.DOCTYPE = value;
        }

        /**
         * Gets the value of the DOCGR_CODE property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDOCGRCODE() {
            return DOCGR_CODE;
        }

        /**
         * Sets the value of the DOCGR_CODE property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDOCGRCODE(String value) {
            this.DOCGR_CODE = value;
        }

        /**
         * Gets the value of the DOCNUM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDOCNUM() {
            return DOCNUM;
        }

        /**
         * Sets the value of the DOCNUM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDOCNUM(String value) {
            this.DOCNUM = value;
        }

        /**
         * Gets the value of the DOCDATE property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public LocalDate getDOCDATE() {
            return DOCDATE;
        }

        /**
         * Sets the value of the DOCDATE property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDOCDATE(LocalDate value) {
            this.DOCDATE = value;
        }

        /**
         * Gets the value of the DOCNAME property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDOCNAME() {
            return DOCNAME;
        }

        /**
         * Sets the value of the DOCNAME property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDOCNAME(String value) {
            this.DOCNAME = value;
        }

        /**
         * Gets the value of the NODOCNUM property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNODOCNUM() {
            return NODOCNUM;
        }

        /**
         * Sets the value of the NODOCNUM property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNODOCNUM(Boolean value) {
            this.NODOCNUM = value;
        }

        /**
         * Gets the value of the NODOCDATE property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNODOCDATE() {
            return NODOCDATE;
        }

        /**
         * Sets the value of the NODOCDATE property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNODOCDATE(Boolean value) {
            this.NODOCDATE = value;
        }

        /**
         * Gets the value of the REMARKS property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARKS() {
            return REMARKS;
        }

        /**
         * Sets the value of the REMARKS property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARKS(String value) {
            this.REMARKS = value;
        }

        /**
         * Gets the value of the RERF property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRERF() {
            return RERF;
        }

        /**
         * Sets the value of the RERF property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRERF(String value) {
            this.RERF = value;
        }

        /**
         * Gets the value of the AUTORDOC property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAUTORDOC() {
            return AUTORDOC;
        }

        /**
         * Sets the value of the AUTORDOC property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAUTORDOC(String value) {
            this.AUTORDOC = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="LAWSUBJECT">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XLAWSUBJECT">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XOLTYPE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="24"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OLTYPE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="REGNUM">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="24"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="REGDATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="CERTSER">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="5"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CERTNUM">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CERTDATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="CHILDORG">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XCHILDORG">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XOBJOFLAW">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="KADASTRNUM" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XLAWTYPE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LAWTYPE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="INVENTORNUM" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BP1" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="10"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECNREGOROLD" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
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
    @XmlType(name = "", propOrder = {
        "lawsubject",
        "xlawsubject",
        "xoltype",
        "oltype",
        "regnum",
        "regdate",
        "certser",
        "certnum",
        "certdate",
        "childorg",
        "xchildorg",
        "xobjoflaw",
        "kadastrnum",
        "xlawtype",
        "lawtype",
        "inventornum",
        "bp1",
        "recnregorold"
    })
    public static class KPD {

        @XmlElement(name = "LAWSUBJECT", required = true)
        protected String lawsubject;
        @XmlElement(name = "XLAWSUBJECT", required = true)
        protected String xlawsubject;
        @XmlElement(name = "XOLTYPE", required = true)
        protected String xoltype;
        @XmlElement(name = "OLTYPE")
        protected String oltype;
        @XmlElement(name = "REGNUM", required = true)
        protected String regnum;
        @XmlElement(name = "REGDATE", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar regdate;
        @XmlElement(name = "CERTSER", required = true)
        protected String certser;
        @XmlElement(name = "CERTNUM", required = true)
        protected String certnum;
        @XmlElement(name = "CERTDATE", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar certdate;
        @XmlElement(name = "CHILDORG", required = true)
        protected String childorg;
        @XmlElement(name = "XCHILDORG", required = true)
        protected String xchildorg;
        @XmlElement(name = "XOBJOFLAW", required = true)
        protected String xobjoflaw;
        @XmlElement(name = "KADASTRNUM")
        protected String kadastrnum;
        @XmlElement(name = "XLAWTYPE")
        protected String xlawtype;
        @XmlElement(name = "LAWTYPE")
        protected String lawtype;
        @XmlElement(name = "INVENTORNUM")
        protected String inventornum;
        @XmlElement(name = "BP1")
        protected String bp1;
        @XmlElement(name = "RECNREGOROLD")
        protected String recnregorold;

        /**
         * Gets the value of the lawsubject property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLAWSUBJECT() {
            return lawsubject;
        }

        /**
         * Sets the value of the lawsubject property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLAWSUBJECT(String value) {
            this.lawsubject = value;
        }

        /**
         * Gets the value of the xlawsubject property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXLAWSUBJECT() {
            return xlawsubject;
        }

        /**
         * Sets the value of the xlawsubject property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXLAWSUBJECT(String value) {
            this.xlawsubject = value;
        }

        /**
         * Gets the value of the xoltype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXOLTYPE() {
            return xoltype;
        }

        /**
         * Sets the value of the xoltype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXOLTYPE(String value) {
            this.xoltype = value;
        }

        /**
         * Gets the value of the oltype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOLTYPE() {
            return oltype;
        }

        /**
         * Sets the value of the oltype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOLTYPE(String value) {
            this.oltype = value;
        }

        /**
         * Gets the value of the regnum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREGNUM() {
            return regnum;
        }

        /**
         * Sets the value of the regnum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREGNUM(String value) {
            this.regnum = value;
        }

        /**
         * Gets the value of the regdate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getREGDATE() {
            return regdate;
        }

        /**
         * Sets the value of the regdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setREGDATE(XMLGregorianCalendar value) {
            this.regdate = value;
        }

        /**
         * Gets the value of the certser property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCERTSER() {
            return certser;
        }

        /**
         * Sets the value of the certser property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCERTSER(String value) {
            this.certser = value;
        }

        /**
         * Gets the value of the certnum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCERTNUM() {
            return certnum;
        }

        /**
         * Sets the value of the certnum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCERTNUM(String value) {
            this.certnum = value;
        }

        /**
         * Gets the value of the certdate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCERTDATE() {
            return certdate;
        }

        /**
         * Sets the value of the certdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCERTDATE(XMLGregorianCalendar value) {
            this.certdate = value;
        }

        /**
         * Gets the value of the CHILDORG property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCHILDORG() {
            return childorg;
        }

        /**
         * Sets the value of the CHILDORG property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCHILDORG(String value) {
            this.childorg = value;
        }

        /**
         * Gets the value of the XCHILDORG property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXCHILDORG() {
            return xchildorg;
        }

        /**
         * Sets the value of the XCHILDORG property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXCHILDORG(String value) {
            this.xchildorg = value;
        }

        /**
         * Gets the value of the xobjoflaw property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXOBJOFLAW() {
            return xobjoflaw;
        }

        /**
         * Sets the value of the xobjoflaw property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXOBJOFLAW(String value) {
            this.xobjoflaw = value;
        }

        /**
         * Gets the value of the KADASTRNUM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKADASTRNUM() {
            return kadastrnum;
        }

        /**
         * Sets the value of the KADASTRNUM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKADASTRNUM(String value) {
            this.kadastrnum = value;
        }

        /**
         * Gets the value of the xlawtype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXLAWTYPE() {
            return xlawtype;
        }

        /**
         * Sets the value of the xlawtype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXLAWTYPE(String value) {
            this.xlawtype = value;
        }

        /**
         * Gets the value of the lawtype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLAWTYPE() {
            return lawtype;
        }

        /**
         * Sets the value of the lawtype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLAWTYPE(String value) {
            this.lawtype = value;
        }

        /**
         * Gets the value of the inventornum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINVENTORNUM() {
            return inventornum;
        }

        /**
         * Sets the value of the inventornum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINVENTORNUM(String value) {
            this.inventornum = value;
        }

        /**
         * Gets the value of the BP1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBP1() {
            return bp1;
        }

        /**
         * Sets the value of the BP1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBP1(String value) {
            this.bp1 = value;
        }

        /**
         * Gets the value of the recnregorold property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECNREGOROLD() {
            return recnregorold;
        }

        /**
         * Sets the value of the recnregorold property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECNREGOROLD(String value) {
            this.recnregorold = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CHILDORG1">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="10"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XCHILDORG1">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="SENDERFIO">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CHILDORG2">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="10"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XCHILDORG2">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RECEIVERFIO" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DESCRIPTION" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="SUMMA" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="18"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CALCCURR" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="5"/>
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
    @XmlType(name = "", propOrder = {
        "childorg1",
        "xchildorg1",
        "senderfio",
        "childorg2",
        "xchildorg2",
        "receiverfio",
        "description",
        "summa",
        "calccurr"
    })
    public static class LETTERS {

        @XmlElement(name = "CHILDORG1", required = true)
        protected String childorg1;
        @XmlElement(name = "XCHILDORG1", required = true)
        protected String xchildorg1;
        @XmlElement(name = "SENDERFIO", required = true)
        protected String senderfio;
        @XmlElement(name = "CHILDORG2", required = true)
        protected String childorg2;
        @XmlElement(name = "XCHILDORG2", required = true)
        protected String xchildorg2;
        @XmlElement(name = "RECEIVERFIO")
        protected String receiverfio;
        @XmlElement(name = "DESCRIPTION")
        protected String description;
        @XmlElement(name = "SUMMA")
        protected String summa;
        @XmlElement(name = "CALCCURR")
        protected String calccurr;

        /**
         * Gets the value of the childorg1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCHILDORG1() {
            return childorg1;
        }

        /**
         * Sets the value of the childorg1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCHILDORG1(String value) {
            this.childorg1 = value;
        }

        /**
         * Gets the value of the xchildorg1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXCHILDORG1() {
            return xchildorg1;
        }

        /**
         * Sets the value of the xchildorg1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXCHILDORG1(String value) {
            this.xchildorg1 = value;
        }

        /**
         * Gets the value of the senderfio property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSENDERFIO() {
            return senderfio;
        }

        /**
         * Sets the value of the senderfio property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSENDERFIO(String value) {
            this.senderfio = value;
        }

        /**
         * Gets the value of the childorg2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCHILDORG2() {
            return childorg2;
        }

        /**
         * Sets the value of the childorg2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCHILDORG2(String value) {
            this.childorg2 = value;
        }

        /**
         * Gets the value of the xchildorg2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXCHILDORG2() {
            return xchildorg2;
        }

        /**
         * Sets the value of the xchildorg2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXCHILDORG2(String value) {
            this.xchildorg2 = value;
        }

        /**
         * Gets the value of the receiverfio property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECEIVERFIO() {
            return receiverfio;
        }

        /**
         * Sets the value of the receiverfio property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECEIVERFIO(String value) {
            this.receiverfio = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDESCRIPTION() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDESCRIPTION(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the SUMMA property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSUMMA() {
            return summa;
        }

        /**
         * Sets the value of the SUMMA property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSUMMA(String value) {
            this.summa = value;
        }

        /**
         * Gets the value of the CALCCURR property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCALCCURR() {
            return calccurr;
        }

        /**
         * Sets the value of the CALCCURR property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCALCCURR(String value) {
            this.calccurr = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CHILDORG1">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="XCHILDORG1">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OBJNAME" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OBJPLACE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="400"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="KADASTRNUM" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OGRN" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="250"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="EGRJLDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="EGRPDATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="EGRPNUM" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="24"/>
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
    @XmlType(name = "", propOrder = {
        "childorg1",
        "xchildorg1",
        "objname",
        "objplace",
        "kadastrnum",
        "ogrn",
        "egrjldate",
        "egrpdate",
        "egrpnum"
    })
    public static class NNA {

        @XmlElement(name = "CHILDORG1", required = true)
        protected String childorg1;
        @XmlElement(name = "XCHILDORG1", required = true)
        protected String xchildorg1;
        @XmlElement(name = "OBJNAME")
        protected String objname;
        @XmlElement(name = "OBJPLACE")
        protected String objplace;
        @XmlElement(name = "KADASTRNUM")
        protected String kadastrnum;
        @XmlElement(name = "OGRN")
        protected String ogrn;
        @XmlElement(name = "EGRJLDATE")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar egrjldate;
        @XmlElement(name = "EGRPDATE")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar egrpdate;
        @XmlElement(name = "EGRPNUM")
        protected String egrpnum;

        /**
         * Gets the value of the childorg1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCHILDORG1() {
            return childorg1;
        }

        /**
         * Sets the value of the childorg1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCHILDORG1(String value) {
            this.childorg1 = value;
        }

        /**
         * Gets the value of the xchildorg1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXCHILDORG1() {
            return xchildorg1;
        }

        /**
         * Sets the value of the xchildorg1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXCHILDORG1(String value) {
            this.xchildorg1 = value;
        }

        /**
         * Gets the value of the objname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOBJNAME() {
            return objname;
        }

        /**
         * Sets the value of the objname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOBJNAME(String value) {
            this.objname = value;
        }

        /**
         * Gets the value of the objplace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOBJPLACE() {
            return objplace;
        }

        /**
         * Sets the value of the objplace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOBJPLACE(String value) {
            this.objplace = value;
        }

        /**
         * Gets the value of the KADASTRNUM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKADASTRNUM() {
            return kadastrnum;
        }

        /**
         * Sets the value of the KADASTRNUM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKADASTRNUM(String value) {
            this.kadastrnum = value;
        }

        /**
         * Gets the value of the ogrn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOGRN() {
            return ogrn;
        }

        /**
         * Sets the value of the ogrn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOGRN(String value) {
            this.ogrn = value;
        }

        /**
         * Gets the value of the egrjldate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEGRJLDATE() {
            return egrjldate;
        }

        /**
         * Sets the value of the egrjldate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEGRJLDATE(XMLGregorianCalendar value) {
            this.egrjldate = value;
        }

        /**
         * Gets the value of the egrpdate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEGRPDATE() {
            return egrpdate;
        }

        /**
         * Sets the value of the egrpdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEGRPDATE(XMLGregorianCalendar value) {
            this.egrpdate = value;
        }

        /**
         * Gets the value of the egrpnum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEGRPNUM() {
            return egrpnum;
        }

        /**
         * Sets the value of the egrpnum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEGRPNUM(String value) {
            this.egrpnum = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="OBJECT_REF">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="70"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ObjCommType" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LINK" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DOCGUID" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="32"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
    @XmlType(name = "", propOrder = {
            "OBJECT_REF",
            "ObjCommType",
            "LINK",
            "DOCGUID",
            "Delete"
    })
    public static class OBJECT_REFS {

        @XmlElement(name = "OBJECT_REF", required = true)
        protected String OBJECT_REF;
        @XmlElement(name = "ObjCommType")
        protected String ObjCommType;
        @XmlElement(name = "LINK")
        protected String LINK;
        @XmlElement(name = "DOCGUID")
        protected String DOCGUID;
        @XmlElement(name = "Delete")
        protected Boolean Delete;

        /**
         * Gets the value of the OBJECT_REF property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOBJECTREF() {
            return OBJECT_REF;
        }

        /**
         * Sets the value of the OBJECT_REF property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOBJECTREF(String value) {
            this.OBJECT_REF = value;
        }

        /**
         * Gets the value of the ObjCommType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObjCommType() {
            return ObjCommType;
        }

        /**
         * Sets the value of the ObjCommType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObjCommType(String value) {
            this.ObjCommType = value;
        }

        /**
         * Gets the value of the LINK property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLINK() {
            return LINK;
        }

        /**
         * Sets the value of the LINK property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLINK(String value) {
            this.LINK = value;
        }

        /**
         * Gets the value of the DOCGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDOCGUID() {
            return DOCGUID;
        }

        /**
         * Sets the value of the DOCGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDOCGUID(String value) {
            this.DOCGUID = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PARTNER_REF">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LINK" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DOCGUID">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="32"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
    @XmlType(name = "", propOrder = {
            "PARTNER_REF",
            "LINK",
            "DOCGUID",
            "Delete"
    })
    public static class PARTNER_REFS {

        @XmlElement(name = "PARTNER_REF", required = true)
        protected String PARTNER_REF;
        @XmlElement(name = "LINK")
        protected String LINK;
        @XmlElement(name = "DOCGUID", required = true)
        protected String DOCGUID;
        @XmlElement(name = "Delete")
        protected Boolean Delete;

        /**
         * Gets the value of the PARTNER_REF property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPARTNERREF() {
            return PARTNER_REF;
        }

        /**
         * Sets the value of the PARTNER_REF property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPARTNERREF(String value) {
            this.PARTNER_REF = value;
        }

        /**
         * Gets the value of the LINK property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLINK() {
            return LINK;
        }

        /**
         * Sets the value of the LINK property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLINK(String value) {
            this.LINK = value;
        }

        /**
         * Gets the value of the DOCGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDOCGUID() {
            return DOCGUID;
        }

        /**
         * Sets the value of the DOCGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDOCGUID(String value) {
            this.DOCGUID = value;
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

}
