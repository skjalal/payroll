package com.ravibpp.payroll.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Timestamp;

@Data
@Builder
public class Payroll {

    @Id
    @Column("payrollid")
    private Long payrollId;

    @Column("employeeid")
    private Long employeeId;

    @Column("payrolldate")
    private Timestamp payrollDate;

    @Column("payrollamount")
    private Double payrollAmount;

    @Column("createdby")
    private String createdBy;

    @Column("createddate")
    private Timestamp createdDate;

    @Column("updatedby")
    private String updatedBy;

    @Column("updateddate")
    private Timestamp updatedDate;
}
