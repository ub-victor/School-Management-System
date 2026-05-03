package com.school.model;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private String courseCode;
    private String courseName;
    private Teacher teacher;  // Association  with Teacher
    private List<Student> enrolledStudents; // Composition (list of Student)
    private int maxCapacity;
    
    public Course(String courseCode, String courseName, Teacher teacher, List<Student> enrolledStudents,
            int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.teacher = teacher;
        this.enrolledStudents = enrolledStudents;
        this.maxCapacity = maxCapacity;
    }

    



}