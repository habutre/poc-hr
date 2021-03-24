package com.acme.poc.hr;

import com.acme.poc.hr.command.application.employee.EmployeeService;
import com.acme.poc.hr.command.application.employee.commands.CreateEmployee;
import com.acme.poc.hr.command.domain.employee.EmployeeId;
import java.time.LocalDate;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {

  @Inject EmployeeService service;

  @POST
  public void create(Map<String, String> payload) {
    System.out.println(payload);
    service.create(
        new CreateEmployee(
            new EmployeeId(payload.get("employeeId")),
            payload.get("name"),
            payload.get("surname"),
            LocalDate.parse(payload.get("birthday"))));
  }
}
