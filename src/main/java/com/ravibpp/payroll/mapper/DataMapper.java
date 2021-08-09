package com.ravibpp.payroll.mapper;

import com.ravibpp.payroll.domain.Employee;
import com.ravibpp.payroll.domain.Payroll;
import com.ravibpp.payroll.dto.EmployeeDto;
import com.ravibpp.payroll.dto.PayrollDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DataMapper {

    @Mapping(target = "employeeName", source = "employee.employeeName")
    @Mapping(target = "dob", source = "employee.dob")
    @Mapping(target = "city", source = "employee.city")
    EmployeeDto map(Employee employee);

    @Mapping(target = "payrollDate", source = "payrollDate")
    @Mapping(target = "payrollAmount", source = "payrollAmount")
    PayrollDto map(Payroll payroll);

    default ZonedDateTime map(Timestamp timestamp) {
        return ZonedDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.UTC);
    }
}
