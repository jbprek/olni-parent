package com.olni.mockdata;

import com.olni.rest.Retailer;
import com.olni.rest.Vlt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by jvp on 10/11/14.
 */
public class MockData {

    // Date format string for json serialization
    private static final String dateFormatString = "yyyyMMdd'T'HH:mm:ss.SSSXXX";
    // Enforced timezone to use GLI's examples
    private static final TimeZone tz = TimeZone.getTimeZone("EST");

    private static DateFormat fmt = new SimpleDateFormat(dateFormatString);

    static ArrayList<Retailer> retailers = new ArrayList<>();
    static HashMap<String, Retailer> retailerById = new HashMap<>();
    static HashMap<String, Vlt> vltById = new HashMap<>();
    static HashMap<String, List<Vlt>> vltByRetailerID = new HashMap<>();

    static {
        try {
        /* Enforce GLI's timezone */
            fmt.setTimeZone(tz);

        /* Create retailers */
            Retailer retailer = new Retailer();
            retailer.setRetailerId("retailer_123");
            retailer.setDescription("This is a retailer.");
            retailer.setEmail("contactEmail@retailer.com");
            retailer.setContactName("Mike Retailer");
            retailers.add(retailer);

            retailer = new Retailer();
            retailer.setRetailerId("anotherRetailer");
            retailer.setDescription("This is another retailer.");
            retailer.setEmail("Bill@anotherRetailer.com");
            retailer.setContactName("Bill");
            retailers.add(retailer);

            retailer = new Retailer();
            retailer.setRetailerId("retailer_987");
            retailer.setDescription("Retailer 987.");
            retailer.setEmail("John987@retailer.com");
            retailer.setContactName("John Retailer");
            retailers.add(retailer);

             /*  Create Vlts   */
            Vlt vlt = new Vlt();
            vlt.setVltId("123456");
            vlt.setAlias("vltAlias for 123456");
            vlt.setLocation("bank 1, position 1");
            vlt.setRetailerId("retailer_123");
            vlt.setSwSetAlias("567_swsetalias_345");
            vlt.setManufacturer("VLT Manufacturer");
            vlt.setDateCommissioned(fmt.parse("20130710T23:59:59.999-05:00"));
            vltById.put(vlt.getVltId(), vlt);
            updateVltByRetailerID(vlt);

            vlt = new Vlt();
            vlt.setVltId("777777");
            vlt.setAlias("vltAlias for 777777");
            vlt.setLocation("bank 1, position 2");
            vlt.setRetailerId("retailer_123");
            vlt.setSwSetAlias("swSetAlias_777");
            vlt.setManufacturer("VLT Manufacturer 2");
            vlt.setDateCommissioned(fmt.parse("20130802T08:32:19.127-05:00"));
            vltById.put(vlt.getVltId(), vlt);
            updateVltByRetailerID(vlt);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize data :", e);
        }
    }

    private static void updateVltByRetailerID(Vlt vlt) {
        if (vltByRetailerID.get(vlt.getRetailerId()) == null) {
            List<Vlt> retailerVltList = new ArrayList<>();
            retailerVltList.add(vlt);
            vltByRetailerID.put(vlt.getRetailerId(), retailerVltList);
        } else {
            vltByRetailerID.get(vlt.getRetailerId()).add(vlt);
        }
    }


    public static ArrayList<Retailer> getRetailers() {
        return retailers;
    }

    public static Collection<Vlt> getVlts() {
        return vltById.values();
    }

    public static Vlt getVltById(String id) {
        return vltById.get(id);
    }

    public static List<Vlt> getVltsByRetailer(String retailerId) {
        return vltByRetailerID.get(retailerId);
    }

}
