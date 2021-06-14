package com.chemstore.service;

import com.chemstore.model.materials.Reagent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Collection;

@Stateless
public class QueryService {

    @Inject
    EntityManager entityManager;

    @PostConstruct
    private void init() {
    }

    @PreDestroy
    private void destroy() {
    }

    public Collection<Reagent> getReagents() {
        return entityManager.createQuery("select r from Reagent r", Reagent.class)
                .getResultList();
    }
}
