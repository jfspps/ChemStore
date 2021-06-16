package com.chemstore.resource;

import com.chemstore.service.ReagentQueryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("reagent")
@Produces("application/json")
public class ReagentResource {

    @Inject
    ReagentQueryService reagentQueryService;

    @GET()
    @Path("findAll")
    public Response getAllReagents() {
        return Response.ok(reagentQueryService.getReagents()).status(Response.Status.OK).build();
    }

    @GET()
    @Path("findById/{id}")
    public Response getReagentById(@PathParam("id") Long ID) {
        return Response.ok(reagentQueryService.getReagentById(ID)).status(Response.Status.OK).build();
    }
}
