package com.example.connectiontransaction;

import com.example.connectiontransaction.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@RequiredArgsConstructor
public class ConnectionTransactionApplication implements ApplicationRunner {

    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(ConnectionTransactionApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        employeeService.withTransaction();
    }
}
