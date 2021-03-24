package com.acme.poc.hr.command.domain.employee;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.acme.poc.hr.command.application.employee.commands.CreateEmployee;
import com.acme.poc.hr.core.EmployeeCreated;
import java.time.LocalDate;
import org.axonframework.cdi.stereotype.Aggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

@Aggregate
public class Employee {

  @AggregateIdentifier private EmployeeId id;
  private String name;
  private String surname;
  private LocalDate birthday;

  @CommandHandler
  public Employee(CreateEmployee createEmployee) {
    apply(
        new EmployeeCreated(
            createEmployee.getEmployeeId(),
            createEmployee.getName(),
            createEmployee.getSurname(),
            createEmployee.getBirthday()));
  }

  public Employee() {
    // Axon required
  }

  @EventSourcingHandler
  public void on(EmployeeCreated event) {
    this.id = event.id();
    this.name = event.name();
    this.surname = event.surname();
    this.birthday = event.birthday();
  }
}
