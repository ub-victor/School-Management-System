package com.school.model;

public class Teacher extends Person{
    private String subjectSpecialization;
    private double salary;

    public Teacher(String id, String name, String email, String subjectSpecialization, double salary) {
        super(id, name, email);
        this.subjectSpecialization = subjectSpecialization;
        this.salary = salary;
    }

    public String getSubjectSpecialization() {
        return subjectSpecialization;
    }

    public void setSubjectSpecialization(String subjectSpecialization) {
        this.subjectSpecialization = subjectSpecialization;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String getRole() {
        return "Teacher";
    }

    @Override
    public String toString() {
        return super.toString()+ String.format(" | Specialization: %s | Salary: $%.2f", subjectSpecialization, salary);
    }

    
    
    
}