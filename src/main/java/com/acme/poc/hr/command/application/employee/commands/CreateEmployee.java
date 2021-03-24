package com.acme.poc.hr.command.application.employee.commands;

import com.acme.poc.hr.command.domain.employee.EmployeeId;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateEmployee {
  @NotBlank @TargetAggregateIdentifier private final EmployeeId employeeId;

  @NotBlank(message = "Name cannot be blank")
  private final String name;

  @NotBlank(message = "Surname cannot be blank")
  private final String surname;

  @NotNull
  @PastOrPresent(message = "The birthday cannot be on future")
  private final LocalDate birthday;

  public CreateEmployee(
      @NotBlank EmployeeId employeeId,
      @NotBlank(message = "Name cannot be blank") String name,
      @NotBlank(message = "Surname cannot be blank") String surname,
      @NotNull @PastOrPresent(message = "The birthday cannot be on future") LocalDate birthday) {
    this.employeeId = employeeId;
    this.name = name;
    this.surname = surname;
    this.birthday = birthday;
  }

  public EmployeeId getEmployeeId() {
    return employeeId;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public LocalDate getBirthday() {
    return birthday;
  }
}
