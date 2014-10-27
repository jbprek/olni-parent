package com.gli.mockdata;

import com.gli.rest.SWComponent;
import com.gli.rest.SWComponentRevoked;
import com.gli.rest.SWSetInfo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by jvp on 10/12/14.
 */
public class MockData {
    // Date format string for json serialization
    private static final String dateFormatString = "yyyyMMdd'T'HH:mm:ss.SSSXXX";
    // Enforced timezone to use GLI's examples
    private static final TimeZone tz = TimeZone.getTimeZone("EST");

    private static DateFormat fmt = new SimpleDateFormat(dateFormatString);

    public static final String[] swSetInfos = {
            "{\"swSetInfo\":{\"swSetAlias\":\"567_swsetalias_345\",\"manufacturer\":\"SWSet Manufacturer\",\"revokedComponents\":[],\"replaceWithComponents\":[]}}",

            "{\"swSetInfo\":{\"swSetAlias\":\"123_swsetalias_789\",\"manufacturer\":\"SWSet Manufacturer\",\"revokedComponents\":[{\"componentId\":\"789\",\"manufacturer\":\"SWSet Manufacturer\",\"version\":\"1.0\",\"function\":\"PERSONALITY PGM\",\"status\":\"RV\",\"revokedDate\":\"20130815T00:00:00.000-05:00\",\"revokedStatus\":\"conditional\",\"replaceByDate\":\"20140101T00:00:00.000-05:00\"}],\"replaceWithComponents\":[{\"componentId\":\"789_2\",\"manufacturer\":\"SWSet Manufacturer\",\"version\":\"2.0\",\"function\":\"PERSONALITY PGM\",\"status\":\"AP\"}]}}"
    };


    /* Populate component list */
    private static final List<SWComponent> componentsList = new ArrayList<>();

    static {
        SWComponent comp = new SWComponent();
        comp.setComponentId("789_2");
        comp.setManufacturer("SWSet Manufacturer");
        comp.setVersion("2.0");
        comp.setFunction("PERSONALITY PGM");
        comp.setStatus("AP");
        componentsList.add(comp);
    }

    public static List<SWComponent> getComponents() {
        return componentsList;
    }

    /* Populate revoked component list */
    public static final List<SWComponentRevoked> componentRevokedList = new ArrayList<>();

    static {
        // Enforce GLI's TZ
        try {
            fmt.setTimeZone(tz);
            SWComponentRevoked rev = new SWComponentRevoked();
            rev.setComponentId("789");
            rev.setManufacturer("SWSet Manufacturer");
            rev.setVersion("1.0");
            rev.setFunction("PERSONALITY PGM");
            rev.setStatus("RV");
            rev.setRevokedDate(fmt.parse("20130815T00:00:00.000-05:00"));
            rev.setRevokedStatus("conditional");
            rev.setReplaceByDate(fmt.parse("20140101T00:00:00.000-05:00"));
            componentRevokedList.add(rev);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize data :", e);
        }
    }

    public static List<SWComponentRevoked> getRevokedComponents() {
        return componentRevokedList;
    }

    /* Populate SwSetInfo list */
    public static final List<SWSetInfo> swSetInfoList = new ArrayList<>();
    public static final Map<String, SWSetInfo> swSetInfoByAlias = new HashMap<>();
    static {
        SWSetInfo swi = new SWSetInfo();
        swi.setSwSetAlias("567_swsetalias_345");
        swi.setManufacturer("SWSet Manufacturer");
        swSetInfoList.add(swi);
        swSetInfoByAlias.put(swi.getSwSetAlias(), swi);

        swi = new SWSetInfo();
        swi.setSwSetAlias("123_swsetalias_789");
        swi.setManufacturer("SWSet Manufacturer");
        swi.setRevokedComponents(getRevokedComponents());
        swi.setReplaceWithComponents(getComponents());
        swSetInfoList.add(swi);
        swSetInfoByAlias.put(swi.getSwSetAlias(), swi);
    }

    public static List<SWSetInfo> getSwSetInfos() {
        return swSetInfoList;
    }

    public static Map<String, SWSetInfo> getSwSetInfoMap() {
          return swSetInfoByAlias;
    }

}
