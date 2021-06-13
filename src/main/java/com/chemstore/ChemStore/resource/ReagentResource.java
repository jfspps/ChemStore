package com.chemstore.ChemStore.resource;

import com.chemstore.ChemStore.model.materials.Reagent;
import com.chemstore.ChemStore.service.QueryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

@Path("reagent")
@Produces("application/json")
public class ReagentResource {

    @Inject
    QueryService queryService;

    @GET()
    @Path("query")
    public Collection<Reagent> getReagentsOnFile() {
        Collection<Reagent> reagents = new ArrayList<>();

        Reagent alcohol = new Reagent();
        alcohol.setChemicalName("Alcohol");
        alcohol.setCAS_id("Some CAS id");

        reagents.add(alcohol);

        return reagents;

//        return Response.ok(queryService.getReagents()).status(Response.Status.OK).build();
    }
}
