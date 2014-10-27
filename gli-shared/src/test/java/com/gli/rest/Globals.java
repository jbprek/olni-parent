package com.gli.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by jvp on 10/26/14.
 */
public class Globals {
    public static final ObjectMapper jsonMapper;
    public static final String dateFormatString = "yyyyMMdd'T'HH:mm:ss.SSSXXX";
    public static final TimeZone tz = TimeZone.getTimeZone("EST");

    static {
        jsonMapper = new ObjectMapper();

        // to prevent exception when encountering unknown property:
        jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // to allow coercion of JSON empty String ("") to null Object value:
        jsonMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        jsonMapper.setDateFormat(getDateFormat());
    }

    public static DateFormat getDateFormat() {
        DateFormat fmt = new SimpleDateFormat(dateFormatString);
        fmt.setTimeZone(tz);
        return fmt;
    }
}
