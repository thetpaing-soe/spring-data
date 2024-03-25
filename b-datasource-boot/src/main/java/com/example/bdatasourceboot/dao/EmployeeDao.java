package com.example.bdatasourceboot.dao;

import com.example.bdatasourceboot.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public List<String> listEmails() {
        return jdbcTemplate.queryForList("select email from employee", String.class);
    }

    public List<Employee> listAllEmployees() {
        return jdbcTemplate.query("select * from employee", this::mapEmployee);
    }

    public double avgSalaryRowCallBackHandler() {
        CustomRowCallBackHandler customRowCallBackHandler = new CustomRowCallBackHandler();
        jdbcTemplate.query("select salary from employee", customRowCallBackHandler);
        return customRowCallBackHandler.avgSalary();
    }

    public double avgSalaryResultSetExtractor() {
        return jdbcTemplate.query("select salary from employee", new CustomResultSetExtract());
    }

    public double avgSalaryDatabaseLevel() {
        return jdbcTemplate.queryForObject("select avg(salary) from employee", Double.class);
    }

    public double avgSalaryModernWay() {
        return jdbcTemplate.queryForList("select salary from employee", Double.class)
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();
    }

    public class CustomResultSetExtract implements ResultSetExtractor<Double> {

        @Override
        public Double extractData(ResultSet rs) throws SQLException, DataAccessException {

            double total = 0;
            int count = 0;

            while (rs.next()) {
                total += rs.getDouble("salary");
                count++;
            }

            return total / (double) count;
        }
    }

    public class CustomRowCallBackHandler implements RowCallbackHandler {

        private double total;
        private int count;

        @Override
        public void processRow(ResultSet rs) throws SQLException {
            total += rs.getDouble("salary");
            count++;
        }

        public double avgSalary() {
            return total / (double) count;
        }
    }

    // RowMapper
    @SneakyThrows
    private Employee mapEmployee(ResultSet rs, int i) {
        return new Employee(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getDate("start_date"),
                rs.getFloat("salary")
        );
    }
}