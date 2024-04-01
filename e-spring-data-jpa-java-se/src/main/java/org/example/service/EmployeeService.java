package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public void saveEmployee() {
        Employee e1 = new Employee(1, "John", "Doe", "55-555-55", "john@gmail.com", Date.valueOf("2024-10-11"), 1000);
        Employee e2 = new Employee(2, "John", "William", "55-555-56", "william@gmail.com", Date.valueOf("2024-10-12"), 1500);
        Employee e3 = new Employee(3, "John", "Updike", "55-555-57", "updike@gmail.com", Date.valueOf("2024-10-15"), 2000);

        employeeDao.save(e1);
        employeeDao.save(e2);
        employeeDao.save(e3);
    }

    public List<Employee> listAllEmployees() {
        return employeeDao.findAll();
    }
}
