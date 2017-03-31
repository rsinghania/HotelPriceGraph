package com.markit.cds.query.builder;

import org.springframework.stereotype.Service;

import com.markit.cds.domain.UserInput;

@Service
public class DeleteQueryBuilder implements QueryBuilder {

    @Override
    public String build(UserInput userInput) {
	StringBuilder query = new StringBuilder();
	query.append("DELETE FROM " + userInput.getTable());
	query.append(" WHERE " + userInput.getPrimaryKeyColumn() + " = " + userInput.getMap().get(userInput.getPrimaryKeyColumn()));
	return query.toString();
    }
}
