package com.example.demo.beans;

import com.example.demo.data.Department;

import java.util.List;

public class DepartmentBean {
    List<Department> departments;

    public DepartmentBean(List<Department> departments) {
        this.departments = departments;
    }

    public DepartmentBean() {
    }

    public int getSize(){
        return departments.size();
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
