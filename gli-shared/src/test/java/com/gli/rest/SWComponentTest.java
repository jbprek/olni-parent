package com.gli.rest;

import com.gli.mockdata.MockData;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


/**
 * Created by jvp on 10/12/14.
 */
public class SWComponentTest {

    public static final String jsonExample = "{\"componentId\":\"789_2\",\"manufacturer\":\"SWSet Manufacturer\",\"version\":\"2.0\",\"function\":\"PERSONALITY PGM\",\"status\":\"AP\"}";

    @Test
    public void testMarshall() throws Exception {

        SWComponent component = MockData.getComponents().get(0);

        Assert.assertEquals(jsonExample, Globals.jsonMapper.writeValueAsString(component));
    }

    @Test
    public void testUnmarshall() throws IOException {


        SWComponent oriObj = MockData.getComponents().get(0);

        SWComponent unmarshalled = Globals.jsonMapper.readValue(jsonExample, SWComponent.class);

        Assert.assertEquals(oriObj, unmarshalled);


    }

}
