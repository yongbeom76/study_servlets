package kr.co.kybex.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB {
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
