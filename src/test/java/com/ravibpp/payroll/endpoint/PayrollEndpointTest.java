package com.ravibpp.payroll.endpoint;

import com.ravibpp.payroll.domain.Department;
import com.ravibpp.payroll.domain.Employee;
import com.ravibpp.payroll.domain.Payroll;
import com.ravibpp.payroll.dto.EmployeeDto;
import com.ravibpp.payroll.dto.PayrollDto;
import com.ravibpp.payroll.mapper.DataMapper;
import com.ravibpp.payroll.repositories.DepartmentRepository;
import com.ravibpp.payroll.repositories.EmployeeRepository;
import com.ravibpp.payroll.repositories.PayrollRepository;
import com.ravibpp.payroll.service.impl.PayrollServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ActiveProfiles("test")
@Import(PayrollServiceImpl.class)
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = PayrollEndpoint.class)
class PayrollEndpointTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    EmployeeRepository employeeRepository;

    @MockBean
    DepartmentRepository departmentRepository;

    @MockBean
    PayrollRepository payrollRepository;

    @MockBean
    DataMapper dataMapper;

    @BeforeEach
    void setUp() {
        Mockito.when(employeeRepository.findAll()).thenReturn(Flux.just(getEmployee()));
        Mockito.when(dataMapper.map(any(Employee.class))).thenReturn(EmployeeDto.builder().build());
        Mockito.when(dataMapper.map(any(Payroll.class))).thenReturn(PayrollDto.builder().build());
        Mockito.when(departmentRepository.findById(anyLong())).thenReturn(Mono.just(Department.builder().build()));
        Mockito.when(payrollRepository.findByEmployeeId(anyLong())).thenReturn(Flux.just(Payroll.builder().build()));
    }

    @Test
    void testGetAllEmployees() {
        webTestClient.get().uri("/api/payrolldetails")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(EmployeeDto.class);
    }

    private Employee getEmployee() {
        return Employee.builder().employeeId(11L).departmentId(21L).build();
    }
}