package kr.co.kybex.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.kybex.study_servlets.dao.PollWithDB;

@WebServlet(urlPatterns = "/polls/PollServlet")
public class PollDetailServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB and Class
        PollWithDB pollWithDB = new PollWithDB();
        HashMap<String, Object> question = null;
        ArrayList questionsUidList = null;
        ArrayList exampleUidList = null;
        ArrayList answersList = null;
        ArrayList<HashMap> answer_list = null;
        try {
            question = pollWithDB.getQuestion(questions_Uid);
            questionsUidList = pollWithDB.getQuestionsUidList();

            exampleUidList = pollWithDB.getExampleUidList(questions_Uid);
            answersList = pollWithDB.getAnswersList(exampleUidList);

            System.out.println(question.get("QUESTIONS_UID"));
            System.out.println(question.get("QUESTIONS"));
            System.out.println(question.get("ORDERS"));
            System.out.println(questionsUidList);
            System.out.println(exampleUidList);
            System.out.println(answersList);

            answer_list = pollWithDB.getAnswers_List(questions_Uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < answer_list.size(); i++) {
            HashMap<String, Object> answer = answer_list.get(i);
            System.out.println(answer.get("ORDERS"));
            System.out.println(answer.get("EXAMPLE"));
        }

        // output with html
        request.setAttribute("question", question);
        request.setAttribute("questionsUidList", questionsUidList);
        request.setAttribute("exampleUidList", exampleUidList);
        request.setAttribute("answersList", answersList);
        request.setAttribute("questionsUid", questions_Uid);

        request.setAttribute("answer_list", answer_list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/polls/details.jsp");
        requestDispatcher.forward(request, response);

    }
}
