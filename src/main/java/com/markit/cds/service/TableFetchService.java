package com.markit.cds.service;

import java.util.List;
import java.util.Map;

public interface TableFetchService {

    List<Map<String, Object>> handleFetchAvailableTableProcess();

    Map<String, List<List<String>>> handleFetchTableDataProcess(String selectedTable);
    
}
