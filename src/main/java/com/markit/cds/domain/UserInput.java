package com.markit.cds.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInput {

    private String table;
    private List<String> rowContent;
    private List<String> columnDetails;
    private String selectedOperation;
    private String primaryKeyColumn;

    public String getPrimaryKeyColumn() {
	return primaryKeyColumn;
    }

    public void setPrimaryKeyColumn(String primaryKeyColumn) {
	this.primaryKeyColumn = primaryKeyColumn;
    }

    public List<String> getRowContent() {
	return rowContent;
    }

    public String getTable() {
	return table;
    }

    public void setTable(String table) {
	this.table = table;
    }

    public List<String> getColumnDetails() {
	return columnDetails;
    }

    public void setColumnDetails(List<String> columnDetails) {
	this.columnDetails = columnDetails;
    }

    public void setRowContent(List<String> rowContent) {
	this.rowContent = rowContent;
    }

    public String getSelectedOperation() {
	return selectedOperation;
    }

    public void setSelectedOperation(String selectedOperation) {
	this.selectedOperation = selectedOperation;
    }

    public Map<String, String> getMap() {
	Map<String, String> map = new HashMap<>();
	for (int i = 0; i < this.columnDetails.size(); i++) {
	    map.put(this.getColumnDetails().get(i), this.getRowContent().get(i));
	}
	return map;
    }

}
