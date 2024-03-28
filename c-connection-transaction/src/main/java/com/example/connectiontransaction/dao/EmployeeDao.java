package com.example.connectiontransaction.dao;

import com.example.connectiontransaction.ds.Employee;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDao {

    private JdbcClient jdbcClient;

    public EmployeeDao(DataSource dataSource) {
        jdbcClient = JdbcClient.create(dataSource);
    }

    public Employee findEmployeeById(int id) {
        return jdbcClient.sql("select * from employee where id = ?")
                .param(1, id)
                .query(Employee.class)
                .single();
    }
}
