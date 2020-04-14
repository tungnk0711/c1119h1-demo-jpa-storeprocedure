package com.codegym.repository.impl;

import com.codegym.model.Employee;
import com.codegym.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> findAll() {
        StoredProcedureQuery getAllEmployee = em.createNamedStoredProcedureQuery("getAllEmployee");
        getAllEmployee.execute();
        List<Employee> employeeList = getAllEmployee.getResultList();

        return employeeList;
    }
}
