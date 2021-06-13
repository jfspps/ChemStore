package com.chemstore.ChemStore.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.enterprise.inject.Produces;

public class Producers {

    // grant bean injection of EntityManager
    @Produces
    @PersistenceContext
    EntityManager entityManager;
}
