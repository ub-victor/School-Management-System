package com.school.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String courseName;
    private Teacher teacher;          // Association with Teacher
    private List<Student> enrolledStudents; // Composition (list of Student)
    private int maxCapacity;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters and setters
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public int getMaxCapacity() { return maxCapacity; }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity && !enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println(student.getName() + " enrolled in " + courseName);
            return true;
        } else {
            System.out.println("Enrollment failed: course full or student already enrolled.");
            return false;
        }
    }

    public void displayCourseInfo() {
        System.out.println("\n--- Course: " + courseName + " (" + courseCode + ") ---");
        // We use ternsry operator
        System.out.println("Teacher: " + (teacher != null ? teacher.getName() : "Not assigned"));
        System.out.println("Enrolled Students (" + enrolledStudents.size() + "/" + maxCapacity + "):");
        if (enrolledStudents.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Student s : enrolledStudents) {
                System.out.println("  - " + s.getName() + " (ID: " + s.getId() + ")");
            }
        }
    }
}