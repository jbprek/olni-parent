package com.olni;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by jvp on 10/11/14.
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        com.olni.rest.RetailerTest.class,
        com.olni.rest.VltTest.class
})

public class AllTests {

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
