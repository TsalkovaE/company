package com.example.demo.dao;

import com.example.demo.data.Employee;
import com.example.demo.db.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public List<Employee> findAll(){
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Employee> employees = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select e.id, e.firstname, e.lastname, e.preferences,\n" +
                    "d.title as department, p.title as position, d.typeofsalary\n" +
                    "from employees e\n" +
                    "join departments d on d.id = e.departmentid\n" +
                    "left join positions p on e.positionid = p.id\n" +
                    "order by e.id");
            while(rs.next()){
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String depart = rs.getString("department");
                String salary = rs.getString("typeofsalary");
                String position = rs.getString("position");
                Employee employee = new Employee(id, firstName, lastName, depart, salary, position);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void addNewEmployee(Employee employee) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into employees values(?, ?, ?, ?, ?, ?)");
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setInt(4, employee.getDepartmentId());
            statement.setInt(5, employee.getPreference());
            statement.setString(6, employee.getPosition());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
