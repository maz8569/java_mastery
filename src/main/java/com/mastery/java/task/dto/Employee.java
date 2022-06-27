package com.mastery.java.task.dto;

public class Employee {

    private long employeeId;
    private String firstName;
    private String lastName;
    private long departmentId;
    private String jobTitle;

    public Employee()
    {
    }

    public Employee(long employeeId, String firstName, String lastName, Long departmentId, String jobTitle) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee [id=" + employeeId
                + ", first_name=" + firstName
                + ", last_name=" + lastName
                + ", department_id=" + departmentId
                + ", job_title=" + jobTitle
                + "]";
    }
}
