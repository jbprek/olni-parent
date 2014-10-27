package com.olni.rest;

import com.olni.AllTests;
import com.olni.mockdata.MockData;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import static com.olni.AllTests.getDateFormat;
import static com.olni.AllTests.jsonMapper;

/**
 * Created by jvp on 10/11/14.
 */
public class VltTest {

    public static final String vltJsonExample = "{\"vltId\":\"123456\",\"alias\":\"vltAlias for 123456\",\"location\":\"bank 1, position 1\",\"retailerId\":\"retailer_123\",\"swSetAlias\":\"567_swsetalias_345\",\"manufacturer\":\"VLT Manufacturer\",\"dateCommissioned\":\"20130710T23:59:59.999-05:00\"}";
//    public static  Date commisionDateExample;
//    static {
//        try {
//            commisionDateExample = getDateFormat().parse("20130710T23:59:59.999-05:00");
//        } catch (ParseException e) {
//            commisionDateExample = null;
//            e.printStackTrace();
//        }
//    }

//    @BeforeClass
//    public static  void setup(){
//        MockitoAnnotations.initMocks(VltTest.class);
//    }


    @Test
    public void testDateFormat() throws Exception {
        Date now = new Date();
        DateFormat fmt = getDateFormat();
        String nowStr = fmt.format(now);
        Date now1 = fmt.parse(nowStr);
        Assert.assertEquals(now, now1);
    }


    @Test
    public void testMarshall() throws Exception {

        DateFormat dfmt = AllTests.getDateFormat();

        Vlt vlt = MockData.getVltById("123456");


        Assert.assertEquals(vltJsonExample, jsonMapper.writeValueAsString(vlt));


    }

    @Test
    public void testUnmarshall() throws IOException {


        Vlt vlt = MockData.getVltById("123456");


        Vlt unmarshalled = jsonMapper.readValue(vltJsonExample, Vlt.class);

        Assert.assertEquals(vlt, unmarshalled);


    }
}
