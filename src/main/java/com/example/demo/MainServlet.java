package com.example.demo;



import com.example.demo.beans.DepartmentBean;
import com.example.demo.beans.EmployeeBean;
import com.example.demo.dao.DepartmentDAO;
import com.example.demo.dao.EmployeeDAO;
import com.example.demo.data.Department;
import com.example.demo.data.Employee;
import com.example.demo.db.ConnectionManager;

import java.io.*;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "*.html")
public class MainServlet extends HttpServlet {
    private String message;
    private Connection connection;

    public void init() {
        message = "Hello World!";
        connection = ConnectionManager.getInstance().getConnection();
        if (connection != null) {
            message = "Database connected!";
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String actionEmpl = request.getParameter("allemployees");
        String actionDep = request.getParameter("alldepartments");
        if(actionEmpl != null) {
            List<Employee> employees = new EmployeeDAO().findAll();
            request.setAttribute("employeebean", new EmployeeBean(employees));
            try {
                request.getRequestDispatcher("/employees.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        if(actionDep != null) {
            List<Department> departments = new DepartmentDAO().getAllDepartments();
            request.setAttribute("departmentbean", new DepartmentBean(departments));
            try {
                request.getRequestDispatcher("/departments.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/newemployee.jsp").forward(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        int departmentId = Integer.parseInt(request.getParameter("department"));
        int preference = Integer.parseInt(request.getParameter("preference"));
        String position = request.getParameter("position");
        Employee employee = new Employee(id, firstName, lastName, departmentId, preference, position);

        new EmployeeDAO().addNewEmployee(employee);

    }

    public void destroy() {
    }
}