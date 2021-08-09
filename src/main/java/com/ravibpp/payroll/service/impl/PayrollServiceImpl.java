package com.ravibpp.payroll.service.impl;

import com.ravibpp.payroll.domain.Employee;
import com.ravibpp.payroll.dto.EmployeeDto;
import com.ravibpp.payroll.mapper.DataMapper;
import com.ravibpp.payroll.repositories.DepartmentRepository;
import com.ravibpp.payroll.repositories.EmployeeRepository;
import com.ravibpp.payroll.repositories.PayrollRepository;
import com.ravibpp.payroll.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PayrollServiceImpl implements PayrollService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PayrollRepository payrollRepository;
    private final DataMapper dataMapper;

    @Override
    public Flux<EmployeeDto> get() {
        return employeeRepository.findAll().flatMap(this::build);
    }

    private Flux<EmployeeDto> build(Employee employee) {
        EmployeeDto employeeDto = dataMapper.map(employee);
        return setDepartment(employeeDto, employee).flatMapMany(data -> setPayroll(data, employee));
    }

    private Mono<EmployeeDto> setDepartment(EmployeeDto employeeDto, Employee employee) {
        return departmentRepository.findById(employee.getDepartmentId())
                .map(d -> {
                    employeeDto.setDepartmentName(d.getDepartmentName());
                    return employeeDto;
                });
    }

    private Mono<EmployeeDto> setPayroll(EmployeeDto employeeDto, Employee employee) {
        return payrollRepository.findByEmployeeId(employee.getEmployeeId())
                .map(dataMapper::map)
                .collectList()
                .map(payroll -> {
                    employeeDto.getPayrolls().addAll(payroll);
                    return employeeDto;
                });
    }
}
