package com.chemstore.ChemStore.service;

import com.chemstore.ChemStore.model.materials.Reagent;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class PersistenceService {

    @Inject
    EntityManager entityManager;

    public Reagent newReagent(Reagent reagent){
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
