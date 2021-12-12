package com.example.demo.data;

import java.util.List;

public class Department {
    private int id;
    private String title;
    private String typeOfSalary;
    List<Employee> employees;

    public Department(int id, String title, String typeOfSalary, List<Employee> employees) {
        this.id = id;
        this.title = title;
        this.typeOfSalary = typeOfSalary;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTypeOfSalary() {
        return typeOfSalary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTypeOfSalary(String typeOfSalary) {
        this.typeOfSalary = typeOfSalary;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

