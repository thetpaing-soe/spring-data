package com.example.connectiontransaction.service;

import com.example.connectiontransaction.dao.EmployeeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public void withoutTransaction() {
        findEmployeeById();
    }

    @Transactional
    public void withTransaction() {
        findEmployeeById();
    }

    private void findEmployeeById() {
        System.out.println(employeeDao.findEmployeeById(2));
        System.out.println(employeeDao.findEmployeeById(3));
        System.out.println(employeeDao.findEmployeeById(4));
        System.out.println(employeeDao.findEmployeeById(6));
        System.out.println(employeeDao.findEmployeeById(7));
    }
}
