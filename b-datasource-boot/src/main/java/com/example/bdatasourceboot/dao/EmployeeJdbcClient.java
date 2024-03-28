package com.example.bdatasourceboot.dao;

import com.example.bdatasourceboot.ds.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeJdbcClient {
    // E = MC^2 == Error = More Code
    private final JdbcClient jdbcClient;

    public List<Employee> findAllEmployees() {
        return jdbcClient.sql("select * from employee")
                .query(Employee.class)
                .list();
    }

    public Optional<Employee> findEmployeeById(int id) {
        return jdbcClient.sql("select * from employee where id = :id")
                .param("id", id)
                .query(Employee.class)
                .optional();
    }

    public Optional<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return jdbcClient.sql("select * from employee where first_name = ? and last_name = ?")
                .param(1, firstName)
                .param(2, lastName)
                .query(Employee.class)
                .optional();
    }

    public void create(Employee employee) {
        jdbcClient.sql("""
                insert into employee (first_name, last_name, email, phone_number, start_date, salary)
                values (?, ?, ?, ?, ?, ?)
                """).params(List.of(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getStartDate(),
                employee.getSalary())
        ).update();
    }

    public void updateEmployee(Employee employee, int id) {
        jdbcClient.sql("""
                update employee set first_name = ?, last_name = ?, 
                email = ?, phone_number = ?,
                start_date = ?, salary = ? where id = ?
                """).params(List.of(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getStartDate(),
                employee.getSalary(),
                id)
        ).update();
    }

    public void deleteEmployee(int id) {
        jdbcClient.sql("delete from employee where id = ?").param(1, id).update();
    }
}
