package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeDao employeeDao = new EmployeeDao();

    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = employeeDao.findAllEmployees();
        return  employees;
    }

    public List<Employee> getAllEmployeesByName(String firstName)
    {
        List<Employee> employees = employeeDao.findEmployeesByName(firstName);
        return  employees;
    }

    public Employee addEmployee(Employee employee){
        Employee _employee = new Employee( employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle());
        System.out.println(_employee.getEmployeeId());

        employeeDao.addEmployee(_employee);
        return _employee;
    }

    public void deleteEmployee(long id)
    {
        employeeDao.deleteByID(id);
    }

    public Employee findById(long id)
    {
        Employee employeeData = employeeDao.findByID(id);
        return employeeData;
    }

    public Employee updateEmployee(Employee employeeFound, Employee employee)
    {
        employeeFound.setFirstName(employee.getFirstName());
        employeeFound.setLastName(employee.getLastName());
        employeeFound.setDepartmentId(employee.getDepartmentId());
        employeeFound.setJobTitle(employee.getJobTitle());

        employeeDao.updateEmployee(employeeFound);
        return employeeFound;
    }
}
