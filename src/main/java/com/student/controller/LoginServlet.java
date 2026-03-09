package com.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String pass = req.getParameter("password");

        if ("admin".equals(userId) && "admin123".equals(pass)) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", userId);
            res.sendRedirect("welcome");
        } else {
            res.sendRedirect("login?error=1");
        }
    }
}
