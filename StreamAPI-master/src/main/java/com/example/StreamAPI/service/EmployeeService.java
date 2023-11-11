package com.example.StreamAPI.service;

import com.example.StreamAPI.model.EmployeesModel;

import java.util.Collection;

public interface EmployeeService {
    String addEmpl(String firstName, String lastName, int salary, int department);

    String deletedEmpl(String firstName, String lastName, int salary, int department);

    EmployeesModel searchEmpl(String firstName, String lastName, int salary, int department);

    Collection<EmployeesModel> fullList();
}
