package com.gli.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gli.rest.SWSetInfo;
import com.gli.rest.SWSetInfoWrapped;
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
 * Created by jvp on 10/11/14.
 */
@Path("/")
public class ServiceRest {

    @Inject
    private ApplicationSetup applicationSetup;

    @Inject
    private Service service;

    private ObjectMapper objectMapper;


    @PostConstruct
    public void setup() {
        objectMapper = applicationSetup.getJsonObjectMapper();
    }

    @GET
    @Path("/ping")
    @Produces("application/json")
    public String getPing() {
        return "{'version:'" + 1.0 + "'}";
    }

    /*  GET /OHL/[ver]/GetSWSetAlias/123_swsetalias_789 */
    @GET
    @Path("GetSWSetAlias/{id}")
    @Produces("application/json")
    public Response getSWSetAlias(@PathParam("id") String swAlias) {
        try {
            SWSetInfo swSetInfo = service.getSWSetInfo(swAlias);
            if (swSetInfo == null) {
                // TODO log
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            SWSetInfoWrapped wrapped = new SWSetInfoWrapped()  ;
            wrapped.setSwSetInfo(swSetInfo);

            String responseString = objectMapper.writeValueAsString(wrapped);
            Response.ResponseBuilder bui = Response.ok(responseString);
            return bui.build();
        } catch (JsonProcessingException e) {
            // TODO log entry
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }


}
