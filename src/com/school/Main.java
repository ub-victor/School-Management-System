package com.school;

import com.school.model.*;
import com.school.service.School;
import java.util.Scanner;

/**
 * Console-based user interface for the School Management System.
 * Demonstrates how to use all the OOP components.
 */
public class Main {
    private static School school = new School("Greenfield High");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🏫 Welcome to " + school.getSchoolName() + " Management System");
        // Pre-load some sample data for demonstration
        initializeSampleData();

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1: manageStudents(); break;
                case 2: manageTeachers(); break;
                case 3: manageCourses(); break;
                case 4: enrollStudent(); break;
                case 5: assignTeacherToCourse(); break;
                case 6: payFees(); break;
                case 7: viewAllData(); break;
                case 0: running = false; System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Add/View Students");
        System.out.println("2. Add/View Teachers");
        System.out.println("3. Add/View Courses");
        System.out.println("4. Enroll Student in Course");
        System.out.println("5. Assign Teacher to Course");
        System.out.println("6. Pay Student Fees");
        System.out.println("7. View All Data (Students, Teachers, Courses)");
        System.out.println("0. Exit");
    }

    // ----- Student Management Submenu -----
    private static void manageStudents() {
        System.out.println("\n--- Student Management ---");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        int choice = getIntInput("Choice: ");
        if (choice == 1) {
            String id = getStringInput("Student ID: ");
            String name = getStringInput("Name: ");
            String email = getStringInput("Email: ");
            double totalFees = getDoubleInput("Total Annual Fees: ");
            // Fixed: Added missing feesPaid parameter (0.0) to match Student constructor
            school.addStudent(new Student(id, name, email, 0.0, totalFees));
        } else if (choice == 2) {
            school.displayAllStudents();
        } else {
            System.out.println("Invalid option.");
        }
    }

    private static void manageTeachers() {
        System.out.println("\n--- Teacher Management ---");
        System.out.println("1. Add New Teacher");
        System.out.println("2. View All Teachers");
        int choice = getIntInput("Choice: ");
        if (choice == 1) {
            String id = getStringInput("Teacher ID: ");
            String name = getStringInput("Name: ");
            String email = getStringInput("Email: ");
            String subject = getStringInput("Specialization: ");
            double salary = getDoubleInput("Salary: ");
            school.addTeacher(new Teacher(id, name, email, subject, salary));
        } else if (choice == 2) {
            school.displayAllTeachers();
        } else {
            System.out.println("Invalid option.");
        }
    }

    private static void manageCourses() {
        System.out.println("\n--- Course Management ---");
        System.out.println("1. Add New Course");
        System.out.println("2. View All Courses");
        System.out.println("3. View Course Details by Code");
        int choice = getIntInput("Choice: ");
        switch (choice) {
            case 1:
                String code = getStringInput("Course Code: ");
                String name = getStringInput("Course Name: ");
                int capacity = getIntInput("Max Capacity: ");
                school.addCourse(new Course(code, name, capacity));
                break;
            case 2:
                school.displayAllCourses();
                break;
            case 3:
                String cCode = getStringInput("Enter Course Code: ");
                school.displayCourseDetails(cCode);
                break;
            default: System.out.println("Invalid option.");
        }
    }

    private static void enrollStudent() {
        String studentId = getStringInput("Enter Student ID: ");
        String courseCode = getStringInput("Enter Course Code: ");
        school.enrollStudentInCourse(studentId, courseCode);
    }

    private static void assignTeacherToCourse() {
        String teacherId = getStringInput("Enter Teacher ID: ");
        String courseCode = getStringInput("Enter Course Code: ");
        school.assignTeacherToCourse(teacherId, courseCode);
    }

    private static void payFees() {
        String studentId = getStringInput("Enter Student ID: ");
        double amount = getDoubleInput("Amount to pay: ");
        school.payStudentFees(studentId, amount);
    }

    private static void viewAllData() {
        school.displayAllStudents();
        school.displayAllTeachers();
        school.displayAllCourses();
    }

    // ----------------- Helper Input Methods -----------------
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.nextLine(); // discard invalid input line
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return num;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.nextLine(); // discard invalid input line
        }
        double num = scanner.nextDouble();
        scanner.nextLine();
        return num;
    }

    private static void initializeSampleData() {
        // Pre-populate to avoid empty system on first run
        // Fixed: Added missing feesPaid parameter (0.0) and changed 5000 to 5000.0 for double type
        Student s1 = new Student("S001", "Alice Johnson", "alice@example.com", 0.0, 5000.0);
        // Fixed: Added missing feesPaid parameter (0.0) and changed 5000 to 5000.0 for double type
        Student s2 = new Student("S002", "Bob Smith", "bob@example.com", 0.0, 5000.0);
        Teacher t1 = new Teacher("T001", "Dr. Emily Brown", "emily@school.com", "Mathematics", 55000);
        Teacher t2 = new Teacher("T002", "Prof. John Doe", "john@school.com", "Physics", 60000);
        Course c1 = new Course("CS101", "Intro to Programming", 30);
        Course c2 = new Course("MATH201", "Calculus I", 25);

        school.addStudent(s1);
        school.addStudent(s2);
        school.addTeacher(t1);
        school.addTeacher(t2);
        school.addCourse(c1);
        school.addCourse(c2);
        // Assign teacher to course (just for demo)
        school.assignTeacherToCourse("T001", "CS101");
        school.assignTeacherToCourse("T002", "MATH201");
        // Enroll sample students
        school.enrollStudentInCourse("S001", "CS101");
        school.enrollStudentInCourse("S002", "MATH201");
    }
}