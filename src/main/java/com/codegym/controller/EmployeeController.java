package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/add-employee")
    public ModelAndView createEmployee(){

        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());

        return modelAndView;
    }

    @PostMapping("save-employee")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.add(employee);

        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());

        return modelAndView;
    }
}
