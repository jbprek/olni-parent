package com.olni.rest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author prekezes.
 */
public class Vlt implements Serializable {
    private String vltId;
    private String alias;
    private String location;
    private String retailerId;
    private String swSetAlias;
    private String manufacturer;
    private Date dateCommissioned;

    public String getVltId() {
        return vltId;
    }

    public void setVltId(String vltId) {
        this.vltId = vltId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public String getSwSetAlias() {
        return swSetAlias;
    }

    public void setSwSetAlias(String swSetAlias) {
        this.swSetAlias = swSetAlias;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getDateCommissioned() {
        return (Date)dateCommissioned.clone();
    }

    public void setDateCommissioned(Date dateCommissioned) {
        this.dateCommissioned = (Date)dateCommissioned.clone();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vlt vlt = (Vlt) o;

        if (alias != null ? !alias.equals(vlt.alias) : vlt.alias != null) return false;
        if (dateCommissioned != null ? !dateCommissioned.equals(vlt.dateCommissioned) : vlt.dateCommissioned != null)
            return false;
        if (location != null ? !location.equals(vlt.location) : vlt.location != null) return false;
        if (manufacturer != null ? !manufacturer.equals(vlt.manufacturer) : vlt.manufacturer != null) return false;
        if (retailerId != null ? !retailerId.equals(vlt.retailerId) : vlt.retailerId != null) return false;
        if (swSetAlias != null ? !swSetAlias.equals(vlt.swSetAlias) : vlt.swSetAlias != null) return false;
        if (vltId != null ? !vltId.equals(vlt.vltId) : vlt.vltId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vltId != null ? vltId.hashCode() : 0;
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (retailerId != null ? retailerId.hashCode() : 0);
        result = 31 * result + (swSetAlias != null ? swSetAlias.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (dateCommissioned != null ? dateCommissioned.hashCode() : 0);
        return result;
    }
}
