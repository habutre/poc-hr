package com.acme.poc.hr.command.domain.employee;

import com.acme.poc.hr.command.application.employee.commands.CreateEmployee;
import com.acme.poc.hr.core.EmployeeCreated;
import java.time.LocalDate;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

  private FixtureConfiguration<Employee> fixture;

  @BeforeEach
  public void setup() {
    fixture = new AggregateTestFixture<>(Employee.class);
  }

  @Test
  @DisplayName("should create an aggregate when shift is created and a work log doesn't exist")
  public void createsAggregateOnEmployeeCreated() {
    fixture
        .given()
        .when(new CreateEmployee(new EmployeeId("1234"), "rogerio", "ramos", LocalDate.now()))
        .expectSuccessfulHandlerExecution()
        .expectEvents(
            new EmployeeCreated(new EmployeeId("1234"), "rogerio", "ramos", LocalDate.now()));
  }
}
