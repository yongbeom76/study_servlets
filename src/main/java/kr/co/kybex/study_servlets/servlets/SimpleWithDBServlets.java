package kr.co.kybex.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.kybex.study_servlets.dao.SimpleWithDB;

@WebServlet(urlPatterns = "/simple/WithDBServlets")
public class SimpleWithDBServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // biz with DB
        SimpleWithDB simpleWithDB = new SimpleWithDB();
        simpleWithDB.getList();
        // display
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<div>SimpleWithDBServlets</div>");
        printWriter.close();
    }
}
