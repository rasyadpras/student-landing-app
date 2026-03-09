package com.student.model;

public class Student {
    private String studentId;
    private String studentName;
    private String department;
    private int mark;

    public Student(String studentId, String studentName, String department, int mark) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.mark = mark;
    }

    public String getStudentId() { return studentId; }

    public String getStudentName() { return studentName; }

    public String getDepartment() { return department; }

    public int getMark() { return mark; }

}