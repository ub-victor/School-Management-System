package com.school.model;

public class Student extends Person {
    private double feesPaid;
    private double totalFees;
    
    public Student(String id, String name, String email, double feesPaid, double totalFees) {
        super(id, name, email);
        this.feesPaid = 0.0;
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

    public double getRemainingFees(){
        return totalFees - feesPaid;
    }
    // Safely accept and record a partial or full payment toward an outstanding fee balance, while preventing invalid or oversize payments.

    public void payFees(double amount){
        if (amount > 0 && amount <= getRemainingFees()){
            feesPaid += amount;
            System.out.println("Payment of $" + amount + "received from" + getName()+ ". Total paid: $" + feesPaid);
        }else {
            System.out.println("Invalid payment amount or exceeds remaining fees");
        }
    }
    // @Override getRole() method to return "Student" as the role of this class.
    // Override the toString() method to provide a string representation of the student, including their name, email, fees paid, total fees, and remaining fees.
    // Override is used to provide a specific implementation of a method defined in the parent class (Person) for the Student class, allowing us to specify that the role of this class is "Student" and to customize the string representation of the student object when it is printed or converted to a string.
    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Fees paid: $%.2f | Total Fees: $%.2f | Remaining: $%.2f",
        feesPaid, totalFees, getRemainingFees());

    } 
}