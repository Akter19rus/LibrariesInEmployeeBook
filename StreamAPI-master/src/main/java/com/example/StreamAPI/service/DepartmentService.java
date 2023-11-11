package com.example.StreamAPI.service;

import com.example.StreamAPI.model.EmployeesModel;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<EmployeesModel> getFullDepartment(int department);

    EmployeesModel getMaxSalaryInDepartment(int department);

    EmployeesModel getMinSalaryInDepartment(int department);

    Map<Integer, List<EmployeesModel>> getFullDep();
}
