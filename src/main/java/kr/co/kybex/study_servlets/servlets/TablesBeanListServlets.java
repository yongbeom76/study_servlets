package kr.co.kybex.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.kybex.study_servlets.DatasInfor;
import kr.co.kybex.study_servlets.beans.MemberBean;

@WebServlet(urlPatterns = "/tablesBeanListServlets")
public class TablesBeanListServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8"); // 한글세팅
        DatasInfor datasInfor = new DatasInfor();
        // MemberBean memberBean = datasInfor.getDataWithMemberBean();
        HashMap<String, Object> bundlesData = datasInfor.getBundlesData();

        // ArrayList<String> tablesListWithString =
        // datasInfor.getTablesListWithString();

        // Display area
        PrintWriter printWriter = response.getWriter();
        // HashMap<String, String> searchForm = datasInfor.getSearchFormData();
        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8' />");
        printWriter.println("<meta http-equiv='X-UA-Compatible' content='IE=edge' />");
        printWriter.println("<meta name='viewport' content='width=device-width, initial-scale=1.0' />");
        printWriter.println("<title>Tables Bean List Servlets</title>");
        printWriter.println("<link");
        printWriter.println("href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printWriter.println("rel='stylesheet'");
        printWriter.println("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        printWriter.println("crossorigin='anonymous' />");
        printWriter.println("<link rel='stylesheet' href='./css/commons.css' />");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("   <div class='container'>");
        printWriter.println("       <div class='fs-3'>Tables Normal</div>");

        MemberBean memberBean2 = (MemberBean) bundlesData.get("dataWithMemberBean");
        printWriter.println("<div class='fs-4'>" + memberBean2.getFirstName() + " " + memberBean2.getSecondName() + " "
                + memberBean2.getHandleName() + "</div>");
        // printWriter.println("<div class='fs-4'>" + memberBean.getFirstName() + " " +
        // memberBean.getSecondName() + " "
        // + memberBean.getHandleName() + "</div>");

        printWriter.println("           <table class='table'>");
        printWriter.println("               <thead>");
        printWriter.println("                   <tr>");
        printWriter.println("                       <th scope=>#</th>");
        printWriter.println("                       <th scope=>First</th>");
        printWriter.println("                       <th scope=>Last</th>");
        printWriter.println("                           <th scope=>Handle</th>");
        printWriter.println("                   </tr>");
        printWriter.println("               </thead>");
        printWriter.println("               <tbody>");

        ArrayList<MemberBean> dataListWithMemberBean = (ArrayList<MemberBean>) bundlesData
                .get("dataListWithMemberBean");

        for (int i = 0; i < dataListWithMemberBean.size(); i++) {
            MemberBean memberBean = dataListWithMemberBean.get(i);
            printWriter.println("                   <tr>");
            printWriter.println("                       <th scope=2>" + (i + 1) + "</th>");
            String handle = memberBean.getHandleName();

            printWriter.println("                       <td>" + memberBean.getFirstName() + "</td>");
            printWriter.println("                       <td>" + memberBean.getSecondName() + "</td>");
            printWriter.println("                       <td>" + handle + "</td>");
            printWriter.println("                   </tr>");
        }
        printWriter.println("               </tbody>");
        printWriter.println("       </table>");

        printWriter.println("   </div>");
        printWriter.println("<script");
        printWriter.println("src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter.println("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println("crossorigin='anonymous'></script>");
        printWriter.println("</body>");
        printWriter.println("</html>");

        printWriter.close();
    }
}
