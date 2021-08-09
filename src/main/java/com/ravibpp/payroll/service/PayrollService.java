package com.ravibpp.payroll.service;

import com.ravibpp.payroll.dto.EmployeeDto;
import reactor.core.publisher.Flux;

public interface PayrollService {

    Flux<EmployeeDto> get();
}
