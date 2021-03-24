package com.acme.poc.hr.config;

import io.quarkus.runtime.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.axonframework.commandhandling.AsynchronousCommandBus;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.common.transaction.NoTransactionManager;
import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.axonframework.serialization.json.JacksonSerializer;

@Startup
@ApplicationScoped
public class AxonConfig {

  @Inject EventStoreEntityManagerProvider entityManagerProvider;

  @Produces
  public EventStorageEngine eventStorageEngine() {
    return JpaEventStorageEngine.builder()
        .entityManagerProvider(entityManagerProvider)
        .eventSerializer(JacksonSerializer.defaultSerializer())
        .build();
  }

  @Produces
  public Configuration axonConfiguration() {
    return DefaultConfigurer.defaultConfiguration()
        .configureCommandBus(
            config ->
                AsynchronousCommandBus.builder()
                    .transactionManager(NoTransactionManager.INSTANCE)
                    .messageMonitor(
                        config.messageMonitor(AsynchronousCommandBus.class, "commandBus"))
                    .build())
        .configureEventStore(
            conf -> EmbeddedEventStore.builder().storageEngine(eventStorageEngine()).build())
        .start();
  }

  @Produces
  public CommandBus commandBus(Configuration configuration) {
    return configuration.commandBus();
  }

  @Produces
  public CommandGateway commandGateway(CommandBus commandBus) {
    return DefaultCommandGateway.builder().commandBus(commandBus).build();
  }
}
