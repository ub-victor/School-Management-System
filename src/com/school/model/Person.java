package com.school.model;

/**
 * Abstract base class representing a person in in the school.
 * Demostrates abstraction and encapsulation.
 */
public abstract class Person {
    private String id;
    private String name;
    private String email;
    
    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    // Getters and setters (encapsulation)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // Abstract method to be overridden by subclasses (Polymorphism)
    
    public abstract String getRole();
    // Here we tell Java I am replacing the toString() method that already exists in the parent class
    @Override
    // public String toString(){
        // It is a method used to build a formatted string

        return  String.format(
            "ID: %s | Name %s | Email: %s | Role: %s", 
            id, name, email, getRole()
        );
    }

    
    
}
