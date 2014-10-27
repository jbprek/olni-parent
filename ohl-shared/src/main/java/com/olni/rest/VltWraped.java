package com.olni.rest;

import java.io.Serializable;

/**
 * @author prekezes.
 */
public class VltWraped implements Serializable {
    private Vlt vlt;

    public Vlt getVlt() {
        return vlt;
    }

    public void setVlt(Vlt vlt) {
        this.vlt = vlt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VltWraped vltWraped = (VltWraped) o;

        if (vlt != null ? !vlt.equals(vltWraped.vlt) : vltWraped.vlt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return vlt != null ? vlt.hashCode() : 0;
    }
}
