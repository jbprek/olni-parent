package com.olni.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jvp on 10/11/14.
 */
public class RetailerVlts implements Serializable {
    public static class Data implements Serializable {
        private String retailerId;
        private String description;
        private String email;
        private String contactName;
        private List<Vlt> vlts = new ArrayList<>();

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

        public List<Vlt> getVlts() {
            return vlts;
        }

        public void setVlts(List<Vlt> vlts) {
            this.vlts = vlts;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data = (Data) o;

            if (contactName != null ? !contactName.equals(data.contactName) : data.contactName != null) return false;
            if (description != null ? !description.equals(data.description) : data.description != null) return false;
            if (email != null ? !email.equals(data.email) : data.email != null) return false;
            if (retailerId != null ? !retailerId.equals(data.retailerId) : data.retailerId != null) return false;
            if (vlts != null ? !vlts.equals(data.vlts) : data.vlts != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = retailerId != null ? retailerId.hashCode() : 0;
            result = 31 * result + (description != null ? description.hashCode() : 0);
            result = 31 * result + (email != null ? email.hashCode() : 0);
            result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
            result = 31 * result + (vlts != null ? vlts.hashCode() : 0);
            return result;
        }
    }

    public Data retailerVlts = new Data();

    public Data getRetailerVlts() {
        return retailerVlts;
    }

    public void setRetailerVlts(Data retailerVlts) {
        this.retailerVlts = retailerVlts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RetailerVlts that = (RetailerVlts) o;

        if (retailerVlts != null ? !retailerVlts.equals(that.retailerVlts) : that.retailerVlts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return retailerVlts != null ? retailerVlts.hashCode() : 0;
    }
}
