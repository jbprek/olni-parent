package com.gli.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gli.mockdata.MockData;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;


/**
 * Created by jvp on 10/12/14.
 */
public class SWSetInfoTest {


    @Test
    public void testMarshall() throws Exception {

        for (int i = 0; i < MockData.getSwSetInfos().size(); i++) {
            SWSetInfo  swInfo =   MockData.getSwSetInfos().get(i);
            SWSetInfoWrapped  toMarshall = new SWSetInfoWrapped();
            toMarshall.setSwSetInfo(swInfo);
            String  expected = MockData.swSetInfos[i];
            Assert.assertEquals(expected, Globals.jsonMapper.writeValueAsString(toMarshall));
        }
    }

    @Test
    public void testUnmarshall() throws IOException {
        for (int i = 0; i < MockData.getSwSetInfos().size(); i++) {
            SWSetInfo oriObj =   MockData.getSwSetInfos().get(i);
            SWSetInfoWrapped wrapUnm = Globals.jsonMapper.readValue(MockData.swSetInfos[i], SWSetInfoWrapped.class);
            SWSetInfo unmarshalled = wrapUnm.getSwSetInfo();
            Assert.assertEquals(oriObj, unmarshalled);
        }

    }

}
