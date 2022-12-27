package kr.co.kybex.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.protocol.Resultset;

public class PollWithDB {
    public ArrayList<HashMap> getAnswers_List(String questionsUid) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        String query = "SELECT ANSWERS.QUESTIONS_UID, EXAMPLE_LIST.ORDERS, EXAMPLE_LIST.EXAMPLE " +
                "FROM ANSWERS INNER JOIN EXAMPLE_LIST " +
                "ON ANSWERS.EXAMPLE_UID = EXAMPLE_LIST.EXAMPLE_UID " +
                "WHERE QUESTIONS_UID = '" + questionsUid + "' " +
                "ORDER BY QUESTIONS_UID ";
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<HashMap> answer_list = new ArrayList<HashMap>();
        while (resultSet.next()) {
            HashMap<String, Object> answer = new HashMap<String, Object>();
            answer.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            answer.put("ORDERS", resultSet.getInt("ORDERS"));
            answer.put("EXAMPLE", resultSet.getString("EXAMPLE"));
            answer_list.add(answer);
        }
        return answer_list;
    }

    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        // SELECT * FROM QUESTIONS_LIST
        // WHERE QUESTIONS_UID = 'Q2'

        String query = "SELECT * FROM QUESTIONS_LIST " +
                "WHERE QUESTIONS_UID = '" + questionsUid + "'";

        ResultSet resultSet = statement.executeQuery(query);
        HashMap<String, Object> result = null;
        while (resultSet.next()) {
            result = new HashMap<>();
            result.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            result.put("QUESTIONS", resultSet.getString("QUESTIONS"));
            result.put("ORDERS", resultSet.getInt("ORDERS"));
        }
        return result;
    }

    public ArrayList getQuestionsUidList() throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        String query = "SELECT questions_uid FROM questions_list";

        ResultSet resultSet = statement.executeQuery(query);
        ArrayList questionsUidList = new ArrayList<>();
        while (resultSet.next()) {
            questionsUidList.add(resultSet.getString("questions_uid"));
        }
        return questionsUidList;
    }

    public ArrayList getExampleUidList(String questionsUid) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        String query = "SELECT EXAMPLE_UID FROM answers WHERE questions_uid='" + questionsUid + "'";

        ResultSet resultSet = statement.executeQuery(query);
        ArrayList exampleUidList = new ArrayList<>();
        while (resultSet.next()) {
            exampleUidList.add(resultSet.getString("EXAMPLE_UID"));
        }
        return exampleUidList;
    }

    public ArrayList getAnswersList(ArrayList exampleUidList) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        String exampleUid;
        ArrayList examplesList = new ArrayList<>();

        for (int i = 0; i < exampleUidList.size(); i++) {
            exampleUid = (String) exampleUidList.get(i);
            String query = "select example from example_list where example_uid='" + exampleUid + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                examplesList.add(resultSet.getString("EXAMPLE"));
            }
        }

        return examplesList;
    }
}
