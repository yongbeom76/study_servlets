package kr.co.kybex.study_servlets.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.kybex.study_servlets.DatasInfor;

@WebServlet(urlPatterns = "/dispatcherJSP/TablesListServlets")
public class DispatcherJSPTablesListServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅
        DatasInfor datasInfor = new DatasInfor();
        ArrayList<String> tablesListWithString = datasInfor.getTablesListWithString();
        HashMap<String, String> searchForm = datasInfor.getSearchFormData();
        request.setAttribute("tablesListWithString", tablesListWithString);
        request.setAttribute("searchForm", searchForm);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tables_list.jsp");
        requestDispatcher.forward(request, response);
    }
}
