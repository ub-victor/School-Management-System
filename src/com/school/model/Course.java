package com.school.model;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private String courseCode;
    private String courseName;
    private Teacher teacher;  // Association  with Teacher
    private List<Student> enrolledStudents; // Composition (list of Student)
    private int maxCapacity;
}