package com.gli.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jvp on 10/12/14.
 */
public class SWSetInfo implements Serializable {


    private String swSetAlias;
    private String manufacturer;
    private List<SWComponentRevoked> revokedComponents = new ArrayList<>();
    private List<SWComponent> replaceWithComponents = new ArrayList<>();

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

    public List<SWComponentRevoked> getRevokedComponents() {
        return revokedComponents;
    }

    public void setRevokedComponents(List<SWComponentRevoked> revokedComponents) {
        this.revokedComponents = new ArrayList<>(revokedComponents);
    }

    public List<SWComponent> getReplaceWithComponents() {
        return replaceWithComponents;
    }

    public void setReplaceWithComponents(List<SWComponent> replaceWithComponents) {
        this.replaceWithComponents = new ArrayList<>(replaceWithComponents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SWSetInfo swSetInfo = (SWSetInfo) o;

        if (manufacturer != null ? !manufacturer.equals(swSetInfo.manufacturer) : swSetInfo.manufacturer != null)
            return false;
        if (replaceWithComponents != null ? !replaceWithComponents.equals(swSetInfo.replaceWithComponents) : swSetInfo.replaceWithComponents != null)
            return false;
        if (revokedComponents != null ? !revokedComponents.equals(swSetInfo.revokedComponents) : swSetInfo.revokedComponents != null)
            return false;
        if (swSetAlias != null ? !swSetAlias.equals(swSetInfo.swSetAlias) : swSetInfo.swSetAlias != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = swSetAlias != null ? swSetAlias.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (revokedComponents != null ? revokedComponents.hashCode() : 0);
        result = 31 * result + (replaceWithComponents != null ? replaceWithComponents.hashCode() : 0);
        return result;
    }
}
