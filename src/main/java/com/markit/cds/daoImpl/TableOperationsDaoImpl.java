package com.markit.cds.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.markit.cds.domain.UserInput;
import com.markit.cds.query.builder.QueryBuilderFactory;

@Repository
@Transactional
public class TableOperationsDaoImpl extends ModifiableCommonJDBCDao implements TableOperationsDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private QueryBuilderFactory queryBuilderFactory;

    public List<Map<String, Object>> fetchAllTables() {
	String query = "select * from config_tables";
	return queryForList(query);
    }

    @Override
    public Map<String, List<List<String>>> fetchSelectedTableData(String selectedTable) {
	Map<String, List<List<String>>> tableDataArray = new HashMap<String, List<List<String>>>();
	List<List<String>> columnArray = new ArrayList<List<String>>();
	List<List<String>> rowDataArray = new ArrayList<List<String>>();
	String query = "select * from " + selectedTable + "";
	List<Map<String, Object>> tableData = queryForList(query);
	tableDataArray.put("columns", extractColumns(columnArray, tableData));
	tableDataArray.put("data", extractRowsData(rowDataArray, tableData));
	return tableDataArray;
    }

    private List<List<String>> extractColumns(List<List<String>> columnArray, List<Map<String, Object>> list) {
	for (Map<String, Object> row : list) {
	    Set<String> set = row.keySet();
	    Iterator<String> iterator = set.iterator();
	    while (iterator.hasNext()) {
		List<String> column = new ArrayList<String>();
		column.add(StringUtils.trimWhitespace(iterator.next()));
		columnArray.add(column);
	    }
	    break;
	}
	return columnArray;
    }

    private List<List<String>> extractRowsData(List<List<String>> columnDataArray, List<Map<String, Object>> list) {
	for (Map<String, Object> row : list) {
	    Set<Entry<String, Object>> set = row.entrySet();
	    Iterator<Entry<String, Object>> iterator = set.iterator();
	    List<String> columnData = new ArrayList<String>();

	    while (iterator.hasNext()) {
		Map.Entry<String, Object> rowData = iterator.next();
		columnData.add(StringUtils.trimWhitespace(String.valueOf(rowData.getValue())));
	    }
	    columnDataArray.add(columnData);
	}
	return columnDataArray;
    }

    @Override
    public void update(UserInput userInput) {
	update(queryBuilderFactory.getBuilder(userInput.getSelectedOperation()).build(userInput), userInput.getMap());
    }

    @Override
    public void insert(UserInput userInput) {
	update(queryBuilderFactory.getBuilder(userInput.getSelectedOperation()).build(userInput), userInput.getMap());
    }

    @Override
    public void delete(UserInput userInput) {
	update(queryBuilderFactory.getBuilder(userInput.getSelectedOperation()).build(userInput), userInput.getMap());
    }

    @Override
    protected NamedParameterJdbcTemplate getJdbcTemplate() {
	return namedParameterJdbcTemplate;
    }

}
