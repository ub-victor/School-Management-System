package com.school.model;

public class Teacher extends Person{
    private String subjectSpecialization;
    private double salary;

    public Teacher(String id, String name, String email, String subjectSpecialization, double salary) {
        super(id, name, email);
        this.subjectSpecialization = subjectSpecialization;
        this.salary = salary;
    }

    



    @Override
    public String getRole() {
        return null;
    }
    
    
}