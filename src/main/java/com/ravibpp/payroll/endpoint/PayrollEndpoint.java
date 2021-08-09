package com.ravibpp.payroll.endpoint;

import com.ravibpp.payroll.dto.EmployeeDto;
import com.ravibpp.payroll.service.PayrollService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static com.ravibpp.payroll.util.Constant.EMP_DETAILS_API;
import static com.ravibpp.payroll.util.Constant.EMP_PAYROLL_API;
import static com.ravibpp.payroll.util.Constant.RESPONSE_CODE;
import static com.ravibpp.payroll.util.Constant.ROOT_API;

@RestController
@RequestMapping(value = ROOT_API)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PayrollEndpoint {

    private final PayrollService payrollService;

    @Operation(summary = EMP_DETAILS_API, responses = @ApiResponse(responseCode = RESPONSE_CODE, description = EMP_DETAILS_API))
    @GetMapping(value = EMP_PAYROLL_API, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<EmployeeDto> getAllEmployees() {
        return payrollService.get();
    }
}
