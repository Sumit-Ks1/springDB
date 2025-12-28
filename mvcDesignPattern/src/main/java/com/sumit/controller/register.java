package com.sumit.controller;

import com.sumit.dbcon.DbConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/regForm")
public class register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        String name = req.getParameter("name1");
        String email = req.getParameter("email1");
        String password = req.getParameter("pass1");
        String city = req.getParameter("city1");

        try {
            Connection con = DbConnection.getConnection();
            String insert_sql_query = "INSERT INTO register VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insert_sql_query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, city);

            int count = ps.executeUpdate();
            if (count > 0) {
                out.println("<h3 style='color:green'> Registration made successful </h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/login.html");
                rd.include(req,res);
            }
            else {
                out.println("<h3 style='color:red'> Registration was unsuccessful </h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/register.html");
                rd.include(req,res);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
