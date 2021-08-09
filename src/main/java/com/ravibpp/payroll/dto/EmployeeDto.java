package com.ravibpp.payroll.dto;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class EmployeeDto {

    private String employeeName;
    private String departmentName;
    private ZonedDateTime dob;
    private String city;

    @Builder.Default
    private List<PayrollDto> payrolls = new ArrayList<>();
}
