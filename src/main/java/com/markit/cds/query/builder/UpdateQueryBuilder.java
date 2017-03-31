package com.markit.cds.query.builder;

import org.springframework.stereotype.Service;

import com.markit.cds.domain.UserInput;

@Service
public class UpdateQueryBuilder implements QueryBuilder {

    @Override
    public String build(UserInput userInput) {
	StringBuilder query = new StringBuilder();
	query.append("UPDATE " + userInput.getTable() + " SET ");
	for (String key : userInput.getColumnDetails()) {
	    query.append(key + " = :" + key + ",");
	}
	query.deleteCharAt(query.toString().toCharArray().length - 1);
	query.append(" WHERE " + userInput.getPrimaryKeyColumn() + " = :" + userInput.getPrimaryKeyColumn());
	return query.toString();
    }

}
