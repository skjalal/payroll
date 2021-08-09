package com.ravibpp.payroll.repositories;

import com.ravibpp.payroll.domain.Payroll;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface PayrollRepository extends R2dbcRepository<Payroll, Long> {

    Flux<Payroll> findByEmployeeId(long employeeId);
}
