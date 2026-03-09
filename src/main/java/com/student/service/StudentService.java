package com.student.service;

import com.student.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("S1", "A", "Dep 1", 35));
        students.add(new Student("S2", "B", "Dep 1", 70));
        students.add(new Student("S3", "C", "Dep 1", 60));
        students.add(new Student("S4", "D", "Dep 1", 90));
        students.add(new Student("S5", "E", "Dep 2", 30));
        students.add(new Student("S6", "F", "Dep 3", 32));
        students.add(new Student("S7", "G", "Dep 3", 70));
        students.add(new Student("S8", "H", "Dep 3", 20));

        return students;
    }

    public Map<String, String> passRates(List<Student> students) {
        Map<String, Integer> totalDept = new HashMap<>();
        Map<String, Integer> passRateDept = new HashMap<>();
        Map<String, String> result = new HashMap<>();

        for (Student s : students) {
            String dept = s.getDepartment();
            totalDept.put(dept, totalDept.getOrDefault(dept, 0) + 1);
            if (s.getMark() >= 40) {
                passRateDept.put(dept, passRateDept.getOrDefault(dept, 0) + 1);
            }
        }

        for (String dept : totalDept.keySet()) {
            int total = totalDept.get(dept);
            int pass = passRateDept.getOrDefault(dept, 0);
            double passRate = ((double) pass / total) * 100;
            result.put(dept, String.format("%.2f", passRate));
        }

        return result;
    }

}
