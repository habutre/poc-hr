package com.acme.poc.hr.command.domain.dummy;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

// this entity exists to make Quarkus JPA not fails
// Quarkus expects at least one entity
@Entity
public class DummyEntity {
  @Id
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @GeneratedValue(generator = "UUID")
  @Column(name = "id", updatable = false, nullable = false)
  UUID id;
}
