package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ModelAndView getAllEmployee(){
        List<Employee> listEmployee = employeeService.findAll();

        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("listEmployee", listEmployee);

        return modelAndView;
    }

}
