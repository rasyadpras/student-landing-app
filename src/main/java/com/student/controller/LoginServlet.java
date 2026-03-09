package com.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String pass = req.getParameter("password");

        if (userId.equals("admin") && pass.equals("admin123")) {
            req.setAttribute("userId", userId);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login.jsp?error=1");
        }
    }
}
