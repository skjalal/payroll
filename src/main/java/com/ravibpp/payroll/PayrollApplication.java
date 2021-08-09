package com.ravibpp.payroll;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PayrollApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PayrollApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

}
