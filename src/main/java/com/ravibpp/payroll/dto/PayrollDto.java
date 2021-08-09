package com.ravibpp.payroll.dto;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class PayrollDto {

    private ZonedDateTime payrollDate;
    private Double payrollAmount;
}
