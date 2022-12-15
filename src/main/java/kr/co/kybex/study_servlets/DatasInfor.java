package kr.co.kybex.study_servlets;

import java.util.ArrayList;
import java.util.HashMap;

public class DatasInfor {
    public HashMap<String, String> getSearchFormData() {
        HashMap<String, String> searchForm = new HashMap<String, String>();
        searchForm.put("search_key", "Search Title");
        searchForm.put("name", "김용범");
        searchForm.put("id", "ID0001");
        return searchForm;
    }

    public ArrayList<String> getTablesListWithString() {
        ArrayList<String> tablesListDataWithString = new ArrayList<String>();
        tablesListDataWithString.add("@mdo");
        tablesListDataWithString.add("@fat");
        tablesListDataWithString.add("@twitter");

        return tablesListDataWithString;
    }

    public HashMap<String, Object> getBundlesData() {
        DatasInfor datasInfor = new DatasInfor();
        HashMap<String, String> searchForm = datasInfor.getSearchFormData();
        ArrayList<String> tablesListDataWithString = datasInfor.getTablesListWithString();

        HashMap<String, Object> bundlesData = new HashMap<>();
        bundlesData.put("searchForm", searchForm);
        bundlesData.put("tablesListDataWithString", tablesListDataWithString);
        return bundlesData;
    }
}
