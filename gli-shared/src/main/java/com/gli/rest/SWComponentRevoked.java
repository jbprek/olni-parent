package com.gli.rest;

import java.util.Date;

/**
 * Created by jvp on 10/12/14.
 */
public class SWComponentRevoked extends SWComponent {
    private Date revokedDate;
    private String revokedStatus;
    private Date replaceByDate;

    public Date getRevokedDate() {
        return (Date)revokedDate.clone();
    }

    public void setRevokedDate(Date revokedDate) {
        this.revokedDate = (Date)revokedDate.clone();
    }

    public String getRevokedStatus() {
        return revokedStatus;
    }

    public void setRevokedStatus(String revokedStatus) {
        this.revokedStatus = revokedStatus;
    }

    public Date getReplaceByDate() {
        return (Date)replaceByDate.clone();
    }

    public void setReplaceByDate(Date replaceByDate) {
        this.replaceByDate = (Date)replaceByDate.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SWComponentRevoked that = (SWComponentRevoked) o;

        if (replaceByDate != null ? !replaceByDate.equals(that.replaceByDate) : that.replaceByDate != null)
            return false;
        if (revokedDate != null ? !revokedDate.equals(that.revokedDate) : that.revokedDate != null) return false;
        if (revokedStatus != null ? !revokedStatus.equals(that.revokedStatus) : that.revokedStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (revokedDate != null ? revokedDate.hashCode() : 0);
        result = 31 * result + (revokedStatus != null ? revokedStatus.hashCode() : 0);
        result = 31 * result + (replaceByDate != null ? replaceByDate.hashCode() : 0);
        return result;
    }
}
