package com.markit.cds.daoImpl;

import java.util.List;
import java.util.Map;

import com.markit.cds.domain.UserInput;

public interface TableOperationsDao {

    List<Map<String, Object>> fetchAllTables();

    Map<String, List<List<String>>> fetchSelectedTableData(String selectedTable);

    void update(UserInput userinput);

    void insert(UserInput userinput);

    void delete(UserInput userinput);
}
