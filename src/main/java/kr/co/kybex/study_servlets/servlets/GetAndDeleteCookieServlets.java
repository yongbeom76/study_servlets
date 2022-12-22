package kr.co.kybex.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/getAndDeleteServlets")
public class GetAndDeleteCookieServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>GetAndDeleteCookieServlets</div>");
        // get Cookie
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            printWriter.println("<div>Cookie Name : " + name + ", value : " + value + "</div>");

            // delete cookie
            if (name.equals("secondName")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        printWriter.close();
    }
}
