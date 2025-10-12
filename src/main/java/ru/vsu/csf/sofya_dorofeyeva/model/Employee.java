package ru.vsu.csf.sofya_dorofeyeva.model;

import ru.vsu.csf.sofya_dorofeyeva.model.enums.EmployeeRole;

public class Employee {
    private int id;
    private String email;
    private String fullName;
    private String phone;
    private String password;
    private EmployeeRole role;


    public Employee(int id, String email, String fullName, String phone, String password, EmployeeRole role) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
