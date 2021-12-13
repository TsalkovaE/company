package com.example.demo.dao;

import com.example.demo.data.Department;
import com.example.demo.data.Employee;
import com.example.demo.db.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    public List<Department> getAllDepartments(){
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Department> departments = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from departments");
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String salary = rs.getString("typeofsalary");
                Department department = new Department(id, title, salary, new ArrayList<>());
                departments.add(department);
                List<Employee> employees = new EmployeeDAO().findAll();

                for (Department value : departments) {
                    for (Employee employee : employees) {
                        if (employee.getDepartment().equals(value.getTitle())) {
                            value.getEmployees().add(employee);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }
}
