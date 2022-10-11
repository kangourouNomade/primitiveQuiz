package com.example.quiz;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/login")
public class HelloServlet extends HttpServlet {
    private String message;
    final String LOGIN = "admin";
    final String PASS = "qwerty";


    public void init() {
        message = "Invalid login or password. Please, re-enter";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        if (LOGIN.equals(login) && PASS.equals(password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
            response.sendRedirect("/quiz");
        }else
        out.println("<html><body>");
        out.println("<h3>" + message + "</h3>");
        out.println("<br>Click this link to <a href=\"/index.jsp\">login</a>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}