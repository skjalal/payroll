package com.ravibpp.payroll.repositories;

import com.ravibpp.payroll.domain.Employee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface EmployeeRepository extends R2dbcRepository<Employee, Long> {
}
