package com.chemstore.resource;

import com.chemstore.model.materials.Reagent;
import com.chemstore.service.ReagentPersistenceService;
import com.chemstore.service.ReagentQueryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("reagent")
@Produces("application/json")
@Consumes("application/json")
public class ReagentResource {

    @Context
    private UriInfo uriInfo;

    // use the query service to retrieve data, use the persistence service to save/delete data
    @Inject
    ReagentQueryService reagentQueryService;

    @Inject
    ReagentPersistenceService reagentPersistenceService;

    @GET()
    @Path("reagents")
    public Response getAllReagents() {
        return Response.ok(reagentQueryService.getReagents()).status(Response.Status.OK).build();
    }

    @GET()
    @Path("reagents/{id}")
    public Response getReagentById(@PathParam("id") @DefaultValue("0") Long ID) {
        return Response.ok(reagentQueryService.getReagentById(ID)).status(Response.Status.OK).build();
    }

    @POST()
    @Path("reagents")
    public Response newReagent(Reagent reagent){
        reagentPersistenceService.saveReagent(reagent);

        URI uri = uriInfo.getAbsolutePathBuilder().path(reagent.getId().toString()).build();
        return Response.created(uri).status(Response.Status.CREATED).build();
    }
}
