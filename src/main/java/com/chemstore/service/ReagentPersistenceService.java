package com.chemstore.service;

import com.chemstore.model.materials.Reagent;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// this is not strictly necessary for the in-memory H2 database (app only uses one, see persistence.xml)
@DataSourceDefinition(
        name = "java:app/ChemStore/DB",
        className = "org.h2.Driver",
        url = "jdbc:h2:mem:chemstore",
        user = "username1",
        password = "somePass")
@Stateless
public class ReagentPersistenceService {

    @Inject
    EntityManager entityManager;

    public void saveReagent(Reagent reagent){
        entityManager.persist(reagent);
    }

    public void updateReagent(Reagent reagent){
        entityManager.merge(reagent);
    }
}
