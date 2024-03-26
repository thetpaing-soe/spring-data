package com.example.bdatasourceboot;

import com.example.bdatasourceboot.dao.EmployeeDao;
import com.example.bdatasourceboot.dao.EmployeeJdbcClient;
import com.example.bdatasourceboot.ds.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.sql.Date;


@SpringBootApplication
@RequiredArgsConstructor
public class BDatasourceBootApplication implements CommandLineRunner {

    public final EmployeeDao employeeDao;

    public final EmployeeJdbcClient employeeJdbcClient;

//    @Bean
//    @Profile("dev")
//    public CommandLineRunner runner() {
//        return r -> {
//            employeeDao.listEmails().forEach(System.out::println);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(BDatasourceBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Find All Employees::");
        employeeJdbcClient.findAllEmployees().forEach(System.out::println);

        System.out.println("Find Employee By id::");
        System.out.println(employeeJdbcClient.findById(3));

//        employeeDao.listEmails().forEach(System.out::println);
//        System.out.println();
//        System.out.println("List All Employees");
//        employeeDao.listAllEmployees().forEach(System.out::println);
//        System.out.println("Average Salary::");
//        System.out.println("Average::" + employeeDao.avgSalaryRowCallBackHandler());
//        System.out.println("Average::" + employeeDao.avgSalaryResultSetExtractor());
//        System.out.println("Average::" + employeeDao.avgSalaryDatabaseLevel());
//        System.out.println("Average::" + employeeDao.avgSalaryModernWay());
//        System.out.println("Employee by Email::" + employeeDao.findEmployeeByEmail("charles@gmail.com"));
//
//        Employee employee = new Employee(
//                null,
//                "Mary",
//                "Chan",
//                "mary@gmail.com",
//                "666-66-66",
//                Date.valueOf("2024-03-16"),
//                3000
//                );
//
//        employeeDao.createEmployee(employee);
//        System.out.println("List All Employees::");
//        employeeDao.findAll().forEach(System.out::println);
//
//        System.out.println("High Salary Employee::");
//        System.out.println(employeeDao.highSalaryEmployee());
//
//        System.out.println("FindEmployee By FirstName and LastName::");
//        System.out.println(employeeDao.findEmployeeByFirstNameAndLastName("John", "Doe"));
//
//        System.out.println("Delete Employee::");
//        employeeDao.deleteEmployeeById(1);
//        System.out.println();
//        employeeDao.listAllEmployees().forEach(System.out::println);
    }
}
