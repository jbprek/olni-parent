package com.gli.rest;

import com.gli.mockdata.MockData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;


/**
 * Created by jvp on 10/12/14.
 */
public class SWComponentRevokedTest {
    public static final String jsonExample = "{\"componentId\":\"789\",\"manufacturer\":\"SWSet Manufacturer\",\"version\":\"1.0\",\"function\":\"PERSONALITY PGM\",\"status\":\"RV\",\"revokedDate\":\"20130815T00:00:00.000-05:00\",\"revokedStatus\":\"conditional\",\"replaceByDate\":\"20140101T00:00:00.000-05:00\"}";

    @BeforeClass


    @Test
    public void testMarshall() throws Exception {

        SWComponentRevoked toMarshall = MockData.getRevokedComponents().get(0);

        Assert.assertEquals(jsonExample, Globals.jsonMapper.writeValueAsString(toMarshall));
    }

    @Test
    public void testUnmarshall() throws IOException {


        SWComponentRevoked oriObj = MockData.getRevokedComponents().get(0);

        SWComponentRevoked unmarshalled = Globals.jsonMapper.readValue(jsonExample, SWComponentRevoked.class);

        Assert.assertEquals(oriObj, unmarshalled);


    }

}
