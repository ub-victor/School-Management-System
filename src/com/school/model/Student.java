package com.school.model;

public class Student extends Person {
    private double feesPaid;
    private double totalFees;
    
    public Student(String id, String name, String email, double feesPaid, double totalFees) {
        super(id, name, email);
        this.feesPaid = feesPaid;
        this.totalFees = totalFees;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public void payFees(double amount){
        if (amount > 0 && amount <= getRemainingFrees()){
            feesPaid += amount;
            System.out.println("Payment of $" + amount + "received from" + getName()+ ". Total paid: $" + feesPaid);
        }else {
            System.out.println("Invalid payment amount or exceeds remaining fees");
        }
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
      
    
}