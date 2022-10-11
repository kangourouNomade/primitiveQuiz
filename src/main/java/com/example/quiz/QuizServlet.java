package com.example.quiz;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuizServlet", value = "/quiz")
public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2><center>A few questions</center></h2>\n" +
                " \n" +
                "<form name=\"form\" action=\"stats\" method=\"post\">\n" +
                " \n" +
                "<p>Input your name:</p>\n" +
                "<p><input type=\"text\" name=\"name\"></p>" +
                "<p>Input your surname:</p>\n" +
                "<p><input type=\"text\" name=\"surname\"></p>" +
                "<p><b>1.Your sex:</b></p>\n" +
                "<p><input  name=\"sex\" type=\"radio\" value=\"Male\">Male<br>\n" +
                "<input name=\"sex\" type=\"radio\" value=\"Female\">Female<br>\n" +
                "<input name=\"sex\" type=\"radio\" value=\"Regularly\">Regularly<br></p>\n" +
                " \n" +
                " \n" +
                "<p><b>2.Your age:</b></p>\n" +
                "<p><input name=\"age\" type=\"radio\" value=\"18-24\">18-24<br>\n" +
                "<input name=\"age\" type=\"radio\" value=\"24-34\">24-34<br>\n" +
                "<input name=\"age\" type=\"radio\" value=\"35-50\">35-50<br>\n" +
                "<input name=\"age\" type=\"radio\" value=\"50+\">over 50<br></p>" +
                "<input type=\"submit\"/></form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
