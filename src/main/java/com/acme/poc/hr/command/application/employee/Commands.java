package com.acme.poc.hr.command.application.employee;

import java.time.LocalDate;
import java.util.UUID;

record RenameEmployee(UUID id, String name, String surname){};
record ChangeBirthdayEmployee(UUID id, LocalDate birthday){};
record RemoveEmployee(UUID id){};
