package com.olni.rest;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jvp on 10/11/14.
 */
public class Retailers implements Serializable {

    private List<Retailer> retailers;

    public List<Retailer> getRetailers() {
        return retailers;
    }

    public void setRetailers(List<Retailer> retailers) {
        this.retailers = retailers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Retailers retailers1 = (Retailers) o;

        if (retailers != null ? !retailers.equals(retailers1.retailers) : retailers1.retailers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return retailers != null ? retailers.hashCode() : 0;
    }
}
