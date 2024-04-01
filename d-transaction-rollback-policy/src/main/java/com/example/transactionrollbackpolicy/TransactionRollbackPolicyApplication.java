package com.example.transactionrollbackpolicy;

import com.example.transactionrollbackpolicy.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TransactionRollbackPolicyApplication implements ApplicationRunner {

    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionRollbackPolicyApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        employeeService.deleteAllEmployee();

        try {
            employeeService.createEmployeeWithTransaction();
        } catch (Exception e) {
            System.out.println("exception caught.");
        }

        employeeService.listAllEmployee().forEach(System.out::println);
    }
}
