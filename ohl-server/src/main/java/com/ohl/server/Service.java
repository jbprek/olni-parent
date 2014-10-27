package com.ohl.server;

import com.olni.mockdata.MockData;
import com.olni.rest.Retailer;
import com.olni.rest.Vlt;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by jvp on 10/11/14.
 */
public class Service {


    public Retailer getRetailer(String id) {
        checkNotNull(id);
        for (Retailer r : MockData.getRetailers()) {
            if (r.getRetailerId().equals(id))
                return r;
        }
        return null;
    }


    public Vlt getVlt(String vltId){
        checkNotNull(vltId);
        return MockData.getVltById(vltId);
    }


    public List<Retailer> getRetailers() {

        return MockData.getRetailers();
    }

    public List<Vlt> getRetailerVlts(String retailerId) {
        checkNotNull(retailerId);
        List<Vlt> lst = MockData.getVltsByRetailer(retailerId);
        if (lst == null)
            return new ArrayList<Vlt>();
        else
            return lst;
    }


}
