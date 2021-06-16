package com.chemstore.resource;

import com.chemstore.model.materials.Reagent;
import com.chemstore.service.ReagentPersistenceService;
import com.chemstore.service.ReagentQueryService;

import javax.inject.Inject;
import javax.validation.Valid;
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
        Reagent found = reagentQueryService.getReagentById(ID);

        if (found == null){
            throw new NotFoundException();
        }

        return Response.ok(found).status(Response.Status.OK).build();
    }

    // api/v1/reagent?id=1
    @GET()
    @Path("reagent")
    public Response getReagentByIdQuery(@QueryParam("id") @DefaultValue("0") Long ID) {
        return Response.ok(reagentQueryService.getReagentById(ID)).status(Response.Status.OK).build();
    }

    @POST()
    @Path("reagents")
    public Response newReagent(@Valid Reagent reagent) {
        reagentPersistenceService.saveReagent(reagent);

        URI uri = uriInfo.getAbsolutePathBuilder().path(reagent.getId().toString()).build();
        return Response.created(uri).status(Response.Status.CREATED).build();
    }

    // note that not-found exception already mapped (see package exception)
    @PUT()
    @Path("reagents/{id}")
    public Response updateReagent(@PathParam("id") Long ID, @Valid Reagent reagent) {
        Reagent found = reagentQueryService.getReagentById(ID);

        if (found == null){
            throw new NotFoundException();
        }

        found.setCAS_id(reagent.getCAS_id());
        found.setChemicalName(reagent.getChemicalName());
        reagentPersistenceService.updateReagent(found);

        URI uri = uriInfo.getAbsolutePathBuilder().path(found.getId().toString()).build();
        return Response.created(uri).status(Response.Status.CREATED).build();
    }
}
