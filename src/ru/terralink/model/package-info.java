@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.class)
})
//@javax.xml.bind.annotation.XmlSchema(
//        xmlns = {
//                @XmlNs(prefix = "ns", namespaceURI = "http://inform.gazprom.ru/C/SUIM/REDataExchange")
//        },
//        elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)


@javax.xml.bind.annotation.XmlSchema(namespace = "http://inform.gazprom.ru/C/SUIM/REDataExchange" )

        //,elementFormDefault = javax.xml.bind.annotation.XmlNsForm.UNQUALIFIED


package ru.terralink.model;

import org.joda.time.LocalDate;
import ru.terralink.common.LocalDateAdapter;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;