package com.markit.cds.query.builder;

import org.springframework.stereotype.Service;

import com.markit.cds.domain.UserInput;

@Service
public class InsertQueryBuilder implements QueryBuilder{

    @Override
    public String build(UserInput userInput) {

	StringBuilder query = new StringBuilder();
	query.append("INSERT into " + userInput.getTable() + " values(");
	for (String column : userInput.getColumnDetails()) {
	    query.append(":" + column+","); 
	}
	query.deleteCharAt(query.toString().toCharArray().length-1);
	query.append(")");
	return query.toString();
    
    }

    
}
