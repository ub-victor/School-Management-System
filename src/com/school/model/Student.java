package com.school.model;

public class Student extends Person {
    private double feesPaid;
    private double totalFees;
    
    public Student(String id, String name, String email, double feesPaid, double totalFees) {
        super(id, name, email);
        this.feesPaid = feesPaid;
        this.totalFees = totalFees;
    }   
}