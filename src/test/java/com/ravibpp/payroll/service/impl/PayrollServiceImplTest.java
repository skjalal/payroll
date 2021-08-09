package com.ravibpp.payroll.service.impl;

import com.ravibpp.payroll.domain.Department;
import com.ravibpp.payroll.domain.Employee;
import com.ravibpp.payroll.domain.Payroll;
import com.ravibpp.payroll.dto.EmployeeDto;
import com.ravibpp.payroll.dto.PayrollDto;
import com.ravibpp.payroll.mapper.DataMapper;
import com.ravibpp.payroll.repositories.DepartmentRepository;
import com.ravibpp.payroll.repositories.EmployeeRepository;
import com.ravibpp.payroll.repositories.PayrollRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class PayrollServiceImplTest {

    @InjectMocks
    PayrollServiceImpl dataService;

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    DepartmentRepository departmentRepository;

    @Mock
    PayrollRepository payrollRepository;

    @Mock
    DataMapper dataMapper;

    @Test
    void testGet() {
        Mockito.when(employeeRepository.findAll()).thenReturn(Flux.just(getEmployee()));
        Mockito.when(dataMapper.map(any(Employee.class))).thenReturn(EmployeeDto.builder().build());
        Mockito.when(dataMapper.map(any(Payroll.class))).thenReturn(PayrollDto.builder().build());
        Mockito.when(departmentRepository.findById(anyLong())).thenReturn(Mono.just(Department.builder().build()));
        Mockito.when(payrollRepository.findByEmployeeId(anyLong())).thenReturn(Flux.just(Payroll.builder().build()));

        StepVerifier.create(dataService.get())
                .consumeNextWith(Assertions::assertNotNull)
                .verifyComplete();
    }

    private Employee getEmployee() {
        return Employee.builder().employeeId(11L).departmentId(21L).build();
    }
}