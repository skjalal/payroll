package com.ravibpp.payroll.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Timestamp;

@Data
@Builder
public class Department {

    @Id
    @Column("departmentid")
    private Long departmentId;

    @Column("departmentname")
    private String departmentName;

    @Column("location")
    private String location;

    @Column("createdby")
    private String createdBy;

    @Column("createddate")
    private Timestamp createdDate;

    @Column("updatedby")
    private String updatedBy;

    @Column("updateddate")
    private Timestamp updatedDate;
}
