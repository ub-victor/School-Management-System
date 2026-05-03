package com.school.model;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private String courseCode;
    private String courseName;
    private Teacher teacher;  // Composition (list of Student)
    private List<Student> enrolledStudents;
    private int maxCapacity;
}