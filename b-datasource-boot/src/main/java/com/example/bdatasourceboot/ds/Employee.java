package com.example.bdatasourceboot.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date startingDate;
    private double salary;
}
