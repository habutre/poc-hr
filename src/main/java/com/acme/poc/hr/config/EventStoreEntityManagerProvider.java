package com.acme.poc.hr.config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.axonframework.common.jpa.EntityManagerProvider;

@ApplicationScoped
public class EventStoreEntityManagerProvider implements EntityManagerProvider {

  @Inject EntityManager entityManager;

  @Override
  public EntityManager getEntityManager() {
    return null;
  }

  @PersistenceContext(unitName = "event-store")
  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }
}
