package com.gli.server;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by jvp on 10/11/14.
 */
@Singleton
@Startup
public class ApplicationSetup {

    // Jackson Object Mapper
    private ObjectMapper jsonObjectMapper;
    // Dozer mapper
    private Mapper mapper = new DozerBeanMapper();

    // Date format string for json serialization
    public static final String dateFormatString = "yyyyMMdd'T'HH:mm:ss.SSSXXX";
    // Enforced timezone to use GLI's examples
    public static final TimeZone tz = TimeZone.getTimeZone("EST");

    @PostConstruct
    public void setup() {
        jsonObjectMapper = new ObjectMapper();
        // to prevent exception when encountering unknown property:
        jsonObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // to allow coercion of JSON empty String ("") to null Object value:
        jsonObjectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        DateFormat fmt = new SimpleDateFormat(dateFormatString);
        fmt.setTimeZone(tz);
        jsonObjectMapper.setDateFormat(fmt);
    }

    // TODO consider CDI Producers
    public ObjectMapper getJsonObjectMapper() {
        return jsonObjectMapper;
    }

    public Mapper getBeanMapper() {
        return mapper;
    }
}
