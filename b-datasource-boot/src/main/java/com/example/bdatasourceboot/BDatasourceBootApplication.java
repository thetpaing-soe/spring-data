package com.example.bdatasourceboot;

import com.example.bdatasourceboot.dao.EmployeeDao;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class BDatasourceBootApplication implements CommandLineRunner {

    public final EmployeeDao employeeDao;

    public BDatasourceBootApplication(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

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

        employeeDao.listEmails().forEach(System.out::println);
        System.out.println();
        System.out.println("List All Employees");
        employeeDao.listAllEmployees().forEach(System.out::println);
        System.out.println("Average Salary::");
        System.out.println("Average::" + employeeDao.avgSalaryRowCallBackHandler());
        System.out.println("Average::" + employeeDao.avgSalaryResultSetExtractor());
        System.out.println("Average::" + employeeDao.avgSalaryDatabaseLevel());
        System.out.println("Average::" + employeeDao.avgSalaryModernWay());
    }
}
