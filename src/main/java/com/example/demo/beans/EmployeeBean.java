package com.example.demo.beans;

import com.example.demo.data.Employee;

import java.util.List;

public class EmployeeBean {
    private List<Employee> employees;

    public EmployeeBean(List<Employee> employees) {
        this.employees = employees;
    }
    public EmployeeBean() {
    }

    public int getSize(){
        return employees.size();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

