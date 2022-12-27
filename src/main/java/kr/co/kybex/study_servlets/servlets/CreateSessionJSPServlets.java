package kr.co.kybex.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/createJSPServlets?username=yojulab&password=1234
@WebServlet(urlPatterns = "/session/createJSPServlets")
public class CreateSessionJSPServlets extends HttpServlet {
    // login 할때 참조할 코드
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // display
        // login
        HttpSession httpSession = null;
        HttpSession httpSession_false = null;

        // not exists jsessionid
        // httpSession_false = request.getSession(false); // null
        // httpSession = request.getSession(); // 무조건 인스턴스화

        // EXISTS JSESSIONID
        // httpSession_false = request.getSession(false);
        // httpSession = request.getSession();

        String path = null;
        if ("yojulab".equals(username) && "1234".equals(password)) {
            // login
            // httpSession = request.getSession(); // 새로 생성 안 하고 기존것을 그대로 쓴다. 만약에 기존것 없으면
            // 새로운 세션을 생성한다.
            httpSession = request.getSession(false); // 존재하면 인스턴스화
            if (httpSession == null) {
                httpSession = request.getSession();
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);
            }
            System.out.println(httpSession.getAttribute("username"));
            System.out.println(httpSession.getId());
            path = "/session/checkLogin.jsp";
        } else {
            // logout
            httpSession = request.getSession(false);
            if (httpSession != null) {
                httpSession.invalidate();
            }
            // System.out.println(httpSession.getAttribute("username"));
            // System.out.println(httpSession.getId());
            path = "/session/checkLogout.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
