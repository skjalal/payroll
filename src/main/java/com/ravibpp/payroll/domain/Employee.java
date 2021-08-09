package com.ravibpp.payroll.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Timestamp;

@Data
@Builder
public class Employee {

    @Id
    @Column("employeeid")
    private Long employeeId;

    @Column("employeename")
    private String employeeName;

    @Column("departmentid")
    private Long departmentId;

    @Column("dob")
    private Timestamp dob;

    @Column("address1")
    private String address1;

    @Column("address2")
    private String address2;

    @Column("city")
    private String city;

    @Column("state")
    private String state;

    @Column("createdby")
    private String createdBy;

    @Column("createddate")
    private Timestamp createdDate;

    @Column("updatedby")
    private String updatedBy;

    @Column("updateddate")
    private Timestamp updatedDate;
}
