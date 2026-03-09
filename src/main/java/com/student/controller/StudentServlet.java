package com.student.controller;

import com.student.model.Student;
import com.student.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/welcome")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        Map<String, String> passedRates = studentService.passRates(students);
        req.setAttribute("studentList", students);
        req.setAttribute("passedRates", passedRates);
        req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
    }
}
