package com.codegym.service.impl;

import com.codegym.model.Employee;
import com.codegym.repository.EmployeeRepository;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        List<Employee> listEmployee =  employeeRepository.findAll();
        return listEmployee;
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }
}
