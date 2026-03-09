package com.student.controller;

import com.student.model.Student;
import com.student.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/welcome")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            res.sendRedirect("login");
            return;
        }

        List<Student> students = studentService.getAllStudents();
        Map<String, String> passedRates = studentService.passRates(students);
        req.setAttribute("studentList", students);
        req.setAttribute("passedRates", passedRates);
        req.getRequestDispatcher("/welcome.jsp").forward(req, res);
    }
}
