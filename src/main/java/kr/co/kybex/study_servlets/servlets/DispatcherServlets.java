package kr.co.kybex.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherServlets")
public class DispatcherServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String hiddenParam = request.getParameter("hiddenParam");

        // /dispatcherServlets?hiddenParam=searchFormServlet
        if ("searchFormServlet".equals(hiddenParam)) {
            response.sendRedirect("/searchFormServlet"); // cannot include parameters
            // /dispatcherServlets?hiddenParam=createCookieServlets
        } else if ("createCookieServlets".equals(hiddenParam)) {
            // 값을 전달할 수 있다.
            request.setAttribute("firstName", "yojulab");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cookies/createServlets");
            requestDispatcher.forward(request, response);
        } else {
            // normal display
            String message = "DispatcherServlets with message!";
            PrintWriter printWriter = response.getWriter();

            printWriter.println("<html lang='en'>");
            printWriter.println("<head>");
            printWriter.println("<title>" + message + "</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<button>call DispatcherServlets</button>");

            printWriter.println("</body>");
            printWriter.println("</html>");

            printWriter.close();

        }

    }
}
