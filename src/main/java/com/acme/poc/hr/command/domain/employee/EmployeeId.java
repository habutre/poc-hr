package com.acme.poc.hr.command.domain.employee;

public record EmployeeId(String id) {

  @Override
  public String toString() {
    return this.id();
  }
}
