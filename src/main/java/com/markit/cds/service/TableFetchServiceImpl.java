package com.markit.cds.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markit.cds.daoImpl.TableOperationsDao;

@Service
public class TableFetchServiceImpl implements TableFetchService {

    @Autowired
    private TableOperationsDao tableOperationsDao;

    @Override
    public List<Map<String, Object>> handleFetchAvailableTableProcess() {
	return tableOperationsDao.fetchAllTables();
    }

    @Override
    public Map<String, List<List<String>>> handleFetchTableDataProcess(String selectedTable) {
	Map<String, List<List<String>>> tableData = tableOperationsDao.fetchSelectedTableData(selectedTable);
	return tableData;
    }
}