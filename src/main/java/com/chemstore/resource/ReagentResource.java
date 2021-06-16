package com.chemstore.resource;

import com.chemstore.model.materials.Reagent;
import com.chemstore.service.ReagentPersistenceService;
import com.chemstore.service.ReagentQueryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("reagent")
@Produces("application/json")
public class ReagentResource {

    @Inject
    ReagentQueryService reagentQueryService;

    @Inject
    ReagentPersistenceService reagentPersistenceService;

    @GET()
    @Path("addToDB")
    public Reagent addTempReagent() {
        Reagent alcohol = new Reagent();
        alcohol.setChemicalName("Alcohol");
        alcohol.setCAS_id("Some CAS id");

        return reagentPersistenceService.saveReagent(alcohol);
    }

    @GET()
    @Path("query")
    public Response getReagentsOnFile() {
        return Response.ok(reagentQueryService.getReagents()).status(Response.Status.OK).build();
    }
}
