package com.example.quiz;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "StatServlet", value = "/stats")
public class StatServlet extends HttpServlet {
    List<User> users = new ArrayList<>();
    AtomicInteger maleCounter = new AtomicInteger();
    AtomicInteger femaleCounter = new AtomicInteger();
    AtomicInteger regularlyCounter = new AtomicInteger();
    AtomicInteger age24Counter = new AtomicInteger();
    AtomicInteger age34Counter = new AtomicInteger();
    AtomicInteger age50Counter = new AtomicInteger();
    AtomicInteger ageOver50Counter = new AtomicInteger();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = new User(request.getParameter("name"), request.getParameter("surname"), request.getParameter("sex"), request.getParameter("age"));
        users.add(currentUser);
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");


        if (currentUser.getSex().equals("Male")){
            maleCounter.getAndIncrement();
        }
        if (currentUser.getSex().equals("Female")){
            femaleCounter.getAndIncrement();
        }
        if (currentUser.getSex().equals("Regularly")){
            regularlyCounter.getAndIncrement();
        }
        if (currentUser.getAge().equals("18-24")){
            age24Counter.getAndIncrement();
        }
        if (currentUser.getAge().equals("24-34")){
            age34Counter.getAndIncrement();
        }
        if (currentUser.getAge().equals("35-50")){
            age50Counter.getAndIncrement();
        }
        if (currentUser.getAge().equals("50+")){
            ageOver50Counter.getAndIncrement();
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3><center>Voters</h3>\n");
        for(User s : users) {
            out.println(s.toString() + "<br>");
        }
        out.println("<br>");
        out.println("<h3><center>Statistics</h3>\n");
        out.println("Males voted: " + maleCounter + " times<br>");
        out.println("Females voted: " + femaleCounter + " times<br>");
        out.println("People who have it regularly voted: " + regularlyCounter + " times<br>");
        out.println("People aged between 18-24 voted: " + age24Counter + " times<br>");
        out.println("People aged between 25-34 voted: " + age34Counter + " times<br>");
        out.println("People aged between 35-50 voted: " + age50Counter + " times<br>");
        out.println("People aged over 50 voted: " + ageOver50Counter + " times<br>");
        out.println("<a href=\"/quiz\">Repeat quiz</a>");
        out.println("</body></html>");
    }
}
