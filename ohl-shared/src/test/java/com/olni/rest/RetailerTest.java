package com.olni.rest;

import com.olni.mockdata.MockData;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.olni.AllTests.getDateFormat;
import static com.olni.AllTests.jsonMapper;

/**
 * Created by jvp on 10/11/14.
 */
public class RetailerTest {

    public static final String jsonExample = "{\"retailerId\":\"retailer_123\",\"description\":\"This is a retailer.\",\"email\":\"contactEmail@retailer.com\",\"contactName\":\"Mike Retailer\"}";
    public static final String jsonExampleArray = "{\"retailers\":[{\"retailerId\":\"retailer_123\",\"description\":\"This is a retailer.\",\"email\":\"contactEmail@retailer.com\",\"contactName\":\"Mike Retailer\"},{\"retailerId\":\"anotherRetailer\",\"description\":\"This is another retailer.\",\"email\":\"Bill@anotherRetailer.com\",\"contactName\":\"Bill\"},{\"retailerId\":\"retailer_987\",\"description\":\"Retailer 987.\",\"email\":\"John987@retailer.com\",\"contactName\":\"John Retailer\"}]}";
    public static Date commisionDateExample;

    static {
        try {
            commisionDateExample = getDateFormat().parse("20130710T23:59:59.999-05:00");
        } catch (ParseException e) {
            commisionDateExample = null;
            e.printStackTrace();
        }
    }


    @Test
    public void testMarshall() throws Exception {

        Retailer retailer = MockData.getRetailers().get(0);


        Assert.assertEquals(jsonExample, jsonMapper.writeValueAsString(retailer));


    }

    @Test
    public void testUnmarshall() throws IOException {


        Retailer retailer = MockData.getRetailers().get(0);

        Retailer unmarshalled = jsonMapper.readValue(jsonExample, Retailer.class);

        Assert.assertEquals(retailer, unmarshalled);


    }


    @Test
    public void testMarshallArray() throws Exception {
//        {"retailerId":"retailer_123","description":"This is a retailer.","email":"contactEmail@retailer.com","contactName":"Mike Retailer"}


        List<Retailer> list = MockData.getRetailers();
        Retailers retailers = new Retailers();
        retailers.setRetailers(list);
        Assert.assertEquals(jsonExampleArray, jsonMapper.writeValueAsString(retailers));


    }

    @Test
    public void testUnmarshallArray() throws IOException {

        ArrayList<Retailer> retailersOri = MockData.getRetailers();

        Retailers unmarshalled = jsonMapper.readValue(jsonExampleArray, Retailers.class);
        ArrayList<Retailer> retailersUnmars = new ArrayList<>(unmarshalled.getRetailers());


        Assert.assertArrayEquals(retailersOri.toArray(), retailersUnmars.toArray());


    }
}
