package com.gli.rest;

import java.io.Serializable;

/**
 * Created by jvp on 10/12/14.
 */
public class SWSetInfoWrapped implements Serializable{
    private SWSetInfo swSetInfo;

    public SWSetInfo getSwSetInfo() {
        return swSetInfo;
    }

    public void setSwSetInfo(SWSetInfo swSetInfo) {
        this.swSetInfo = swSetInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SWSetInfoWrapped that = (SWSetInfoWrapped) o;

        if (swSetInfo != null ? !swSetInfo.equals(that.swSetInfo) : that.swSetInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return swSetInfo != null ? swSetInfo.hashCode() : 0;
    }
}
