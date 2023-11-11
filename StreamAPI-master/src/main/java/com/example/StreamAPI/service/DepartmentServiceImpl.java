package com.example.StreamAPI.service;

import com.example.StreamAPI.exception.EmployeeNotFoundException;
import com.example.StreamAPI.model.EmployeesModel;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public List<EmployeesModel> getFullDepartment(int department) {
        return employeeServiceImpl.fullList()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeesModel getMaxSalaryInDepartment(int department) {
        return employeeServiceImpl.fullList()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(EmployeesModel::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудники отдела номер " + department + " не найдены"));
    }

    @Override
    public EmployeesModel getMinSalaryInDepartment(int department) {
        return employeeServiceImpl.fullList()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(EmployeesModel::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудники отдела номер " + department + " не найдены"));
    }

    @Override
    public Map<Integer, List<EmployeesModel>> getFullDep() {
        return employeeServiceImpl.fullList()
                .stream().collect(Collectors.groupingBy(EmployeesModel::getDepartment));
    }
}
