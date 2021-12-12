package com.example.demo.util;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.data.Employee;

import java.util.List;

public class Utility {
    public double calculateEfficiency(int newTime){
        double result1 = 0;
        double result2 = 0;
        List<Employee> employeesList = new EmployeeDAO().findAll();
        long emplMatchLater = employeesList.stream().filter(e -> e.getPreference()==1).count();
        long emplMatchEarlier = employeesList.stream().filter(e -> e.getPreference()==2).count();
        int standard = 9;
        int hours = newTime - standard;

        if(newTime > standard){ //later
            result1 = emplMatchLater * hours * 0.2;
            result2 = emplMatchEarlier * hours * 0.2 * -1;
        } else {
            if (newTime < standard) { //earlier
                result1 = emplMatchLater * hours * 0.2 * -1;
                result2 = emplMatchEarlier * hours * 0.2;
            }
        }
        return result1 + result2;
    }
}
