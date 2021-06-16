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

    public Reagent saveReagent(Reagent reagent){
        entityManager.persist(reagent);
        return reagent;
    }

    public Reagent updateReagent(Reagent reagent){
        entityManager.merge(reagent);
        return reagent;
    }

    public Reagent findReagentById(Long id){
        return entityManager.find(Reagent.class, id);
    }

    public List<Reagent> getReagents(){
        return entityManager.createQuery("SELECT r FROM Reagent r", Reagent.class).getResultList();
    }
}
