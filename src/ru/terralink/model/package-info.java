@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.class)
})
@javax.xml.bind.annotation.XmlSchema(namespace = "http://inform.gazprom.ru/C/SUIM/REDataExchange")
package ru.terralink.model;

import org.joda.time.LocalDate;
import ru.terralink.common.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;