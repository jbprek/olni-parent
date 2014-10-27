package com.ohl.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.olni.rest.Retailer;
import com.olni.rest.RetailerVlts;
import com.olni.rest.Retailers;
import com.olni.rest.Vlt;
import com.olni.rest.VltWraped;
import org.dozer.Mapper;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Serving the following verbs
 * /GLI/[ver]/GetRetailers
 * /GLI/[ver]/GetVLT/[ID]
 * /GLI/[ver]/GetRetailerVlts/[ID]
 */
@Path("/")
public class ServiceRest {

    @Inject
    private ApplicationSetup applicationSetup;

    @Inject
    private Service service;

    private ObjectMapper objectMapper;

    private Mapper beanMapper;

    @PostConstruct
    public void setup() {
        objectMapper = applicationSetup.getJsonObjectMapper();
        beanMapper = applicationSetup.getBeanMapper();
    }

    @GET
    @Path("/ping")
    @Produces("application/json")
    public String getPing() {
        return "{'version:'" + 1.0 + "'}";

    }


    @GET
    @Path("/GetRetailers")
    @Produces("application/json")
    public Response getRetailers() {

        try {
            List<Retailer> retailerList = service.getRetailers();
            if (retailerList.isEmpty()) {
                // TODO log
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            Retailers retailers = new Retailers();
            retailers.setRetailers(retailerList);
            String responseString = objectMapper.writeValueAsString(retailers);
            Response.ResponseBuilder bui = Response.ok(responseString);
            return bui.build();
        } catch (JsonProcessingException e) {
            // TODO log entry
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }

    @GET
    @Path("/GetVLT/{id}")
    @Produces("application/json")
    public Response getVLT(@PathParam("id") String vltId) {

        try {
            Vlt vlt = service.getVlt(vltId);
            if (vlt == null) {
                // TODO log
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            VltWraped vltWraped = new VltWraped();
            vltWraped.setVlt(vlt);

            String responseString = objectMapper.writeValueAsString(vltWraped);
            Response.ResponseBuilder bui = Response.ok(responseString);
            return bui.build();
        } catch (JsonProcessingException e) {
            // TODO log entry
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }

    @GET
    @Path("/GetRetailerVlts/{id}")
    @Produces("application/json")
    public Response getRetailerVlts(@PathParam("id") String retailerId) {

        try {
            Retailer retailer = service.getRetailer(retailerId);
            if (retailer == null) {
                // TODO log
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            List<Vlt> vltList = service.getRetailerVlts(retailerId);

            RetailerVlts retailerVlts = new RetailerVlts();
            beanMapper.map(retailer, retailerVlts.getRetailerVlts());
            retailerVlts.getRetailerVlts().setVlts(vltList);

            String responseString = objectMapper.writeValueAsString(retailerVlts);
            Response.ResponseBuilder bui = Response.ok(responseString);
            return bui.build();
        } catch (JsonProcessingException e) {
            // TODO log entry
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }


}
