package com.example.demo;



import com.example.demo.beans.DepartmentBean;
import com.example.demo.beans.EfficiencyBean;
import com.example.demo.beans.EmployeeBean;
import com.example.demo.dao.DepartmentDAO;
import com.example.demo.dao.EmployeeDAO;
import com.example.demo.data.Department;
import com.example.demo.data.Employee;
import com.example.demo.data.Preference;
import com.example.demo.db.ConnectionManager;
import com.example.demo.util.Utility;

import java.io.*;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "*.html")
public class MainServlet extends HttpServlet {
    private Connection connection;
    List<Department> departments = new DepartmentDAO().getAllDepartments();

    public void init() {
        String message = "Hello World!";
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
        String actionNewEmpl = request.getParameter("newempl");
        String actionEff = request.getParameter("newtime");
        if(actionEff != null) {
            int newTime = Integer.parseInt(actionEff);
            double efficiency = new Utility().calculateEfficiency(newTime);
            request.setAttribute("bean", new EfficiencyBean(efficiency));
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
        if(actionNewEmpl != null) {
            request.setAttribute("department", new DepartmentBean(departments));
            request.getRequestDispatcher("/newemployee.jsp").forward(request, response);
            String firstName = request.getParameter("first");
            String lastName = request.getParameter("last");
            int departmentId = Integer.parseInt(request.getParameter("department"));
            Preference preference = Preference.valueOf(request.getParameter("preference"));
            int positionId = Integer.parseInt(request.getParameter("position"));
            Employee employee = new Employee(firstName, lastName, departmentId, preference, positionId);

            new EmployeeDAO().addNewEmployee(employee);
            //request.setAttribute("employee", employee);
            request.getRequestDispatcher("employees.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}