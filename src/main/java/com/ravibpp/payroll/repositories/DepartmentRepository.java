package com.ravibpp.payroll.repositories;

import com.ravibpp.payroll.domain.Department;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface DepartmentRepository extends R2dbcRepository<Department, Long> {
}
