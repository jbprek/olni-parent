package com.olni.rest;

import java.io.Serializable;

/**
 * @author prekezes.
 */
public class Retailer implements Serializable {
    private String retailerId;
    private String description;
    private String email;
    private String contactName;

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Retailer retailer = (Retailer) o;

        if (contactName != null ? !contactName.equals(retailer.contactName) : retailer.contactName != null)
            return false;
        if (description != null ? !description.equals(retailer.description) : retailer.description != null)
            return false;
        if (email != null ? !email.equals(retailer.email) : retailer.email != null) return false;
        if (retailerId != null ? !retailerId.equals(retailer.retailerId) : retailer.retailerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retailerId != null ? retailerId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        return result;
    }
}

