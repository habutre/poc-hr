package com.acme.poc.hr.core;

import com.acme.poc.hr.command.domain.employee.EmployeeId;
import java.time.LocalDate;

public record EmployeeCreated(EmployeeId id,
                              String name,
                              String surname,
                              LocalDate birthday) {
}
