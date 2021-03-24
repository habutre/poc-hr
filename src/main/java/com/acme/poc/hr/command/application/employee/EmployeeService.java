package com.acme.poc.hr.command.application.employee;

import com.acme.poc.hr.command.application.employee.commands.CreateEmployee;
import com.acme.poc.hr.command.domain.employee.Employee;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.axonframework.commandhandling.gateway.CommandGateway;

@ApplicationScoped
public class EmployeeService {

  @Inject EntityManager em;
  @Inject CommandGateway commandGateway;

  public Optional<Employee> create(CreateEmployee command) {
    // TODO try to use a callback to assert the result
    commandGateway.sendAndWait(command);

    //    System.out.println(result);
    return Optional.empty();
  }
}
