package com.example.demo.data;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int departmentId;
    private String department;
    private Preference preference;
    private int positionId;
    private String position;
    private String salary;

    public Employee(int id, String firstName, String lastName, int departmentId, String position, Preference preference) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.preference = preference;
        this.position = position;
    }

    public Employee(int id, String firstName, String lastName, String department, String salary, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.position = position;

    }

    public Employee(String firstName, String lastName, int departmentId, Preference preference, int positionId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.preference = preference;
        this.positionId = positionId;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }
}
