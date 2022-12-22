package kr.co.kybex.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/createServlets?username=yojulab&password=1234
@WebServlet(urlPatterns = "/session/createServlets")
public class CreateSessionServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>CreateCookieServlets</div>");
        // login
        // if (username.equals("yojulab") && password.equals("1234")) {
        if ("yojulab".equals(username) && "1234".equals(password)) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);
            printWriter.println("<div>" + username + ", " + password + "</div>");

        } else {
            printWriter.println("<div>Failed</div>");
        }
        printWriter.close();
    }
}
