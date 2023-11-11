package com.example.StreamAPI.controller;

import com.example.StreamAPI.model.EmployeesModel;
import com.example.StreamAPI.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

        public DepartmentController(DepartmentService departmentService) {
            this.departmentService = departmentService;
        }

        @GetMapping("/all")
        public Map<Integer, List<EmployeesModel>> getFullDep() {
            return departmentService.getFullDep();
        }

        @GetMapping(value = "/all", params = "department")
        public List<EmployeesModel> getFullDepartment(@RequestParam int department) {
            return departmentService.getFullDepartment(department);
        }


        @GetMapping("/max-salary")
        public EmployeesModel getMaxSalaryInDepartment(@RequestParam int department) {
            return departmentService.getMaxSalaryInDepartment(department);
        }

        @GetMapping("/min-salary")
        public EmployeesModel getMinSalaryInDepartment(@RequestParam int department) {
            return departmentService.getMinSalaryInDepartment(department);
        }
    }
