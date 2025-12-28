package com.sumit.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Hello from IntelliJ Community!</h1>");
    }
}
