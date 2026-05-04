package com.school.service;

import com.school.model.*;

import java.util.*;

/**
 * Manages all school data and operations.
 * Acts as a central repository (composition).
 */
public class School {
    private String schoolName;
    private Map<String, Student> students; // ID -> Student
    private Map<String, Teacher> teachers; // ID -> Teacher
    private Map<String, Course> courses;   // courseCode -> Course

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new HashMap<>();
        this.teachers = new HashMap<>();
        this.courses = new HashMap<>();
    }

    // ----- Student Management -----
    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            System.out.println("Student with ID " + student.getId() + " already exists.");
        } else {
            students.put(student.getId(), student);
            System.out.println("Student added: " + student.getName());
        }
    }

    public Student findStudentById(String id) {
        return students.get(id);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        System.out.println("\n===== ALL STUDENTS =====");
        for (Student s : students.values()) {
            System.out.println(s);
        }
    }

    // ----- Teacher Management -----
    public void addTeacher(Teacher teacher) {
        if (teachers.containsKey(teacher.getId())) {
            System.out.println("Teacher with ID " + teacher.getId() + " already exists.");
        } else {
            teachers.put(teacher.getId(), teacher);
            System.out.println("Teacher added: " + teacher.getName());
        }
    }

    public Teacher findTeacherById(String id) {
        return teachers.get(id);
    }

    public void displayAllTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers registered.");
            return;
        }
        System.out.println("\n===== ALL TEACHERS =====");
        for (Teacher t : teachers.values()) {
            System.out.println(t);
        }
    }

    // ----- Course Management -----
    public void addCourse(Course course) {
        if (courses.containsKey(course.getCourseCode())) {
            System.out.println("Course code already exists.");
        } else {
            courses.put(course.getCourseCode(), course);
            System.out.println("Course added: " + course.getCourseName());
        }
    }

    public Course findCourseByCode(String code) {
        return courses.get(code);
    }

    public void assignTeacherToCourse(String teacherId, String courseCode) {
        Teacher teacher = findTeacherById(teacherId);
        Course course = findCourseByCode(courseCode);
        if (teacher == null) {
            System.out.println("Teacher not found.");
        } else if (course == null) {
            System.out.println("Course not found.");
        } else {
            course.setTeacher(teacher);
            System.out.println("Teacher " + teacher.getName() + " assigned to course " + course.getCourseName());
        }
    }

    public void enrollStudentInCourse(String studentId, String courseCode) {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);
        if (student == null) {
            System.out.println("Student not found.");
        } else if (course == null) {
            System.out.println("Course not found.");
        } else {
            course.enrollStudent(student);
        }
    }

    public void payStudentFees(String studentId, double amount) {
        Student student = findStudentById(studentId);
        if (student != null) {
            student.payFees(amount);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses created.");
            return;
        }
        System.out.println("\n===== ALL COURSES =====");
        for (Course c : courses.values()) {
            c.displayCourseInfo();
        }
    }

    public void displayCourseDetails(String courseCode) {
        Course c = findCourseByCode(courseCode);
        if (c != null) {
            c.displayCourseInfo();
        } else {
            System.out.println("Course not found.");
        }
    }
}