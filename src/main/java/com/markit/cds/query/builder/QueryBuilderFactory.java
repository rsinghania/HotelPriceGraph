package com.markit.cds.query.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryBuilderFactory {

    @Autowired
    private UpdateQueryBuilder updateQueryBuilder;

    @Autowired
    private InsertQueryBuilder insertQueryBuilder;

    @Autowired
    private DeleteQueryBuilder deleteQueryBuilder;

    public QueryBuilder getBuilder(String operationType) {
	if (Operation.INSERT.getValue().equals(operationType)) {
	    return insertQueryBuilder;

	} else if (Operation.UPDATE.getValue().equals(operationType)) {
	    return updateQueryBuilder;

	} else if (Operation.DELETE.getValue().equals(operationType)) {
	    return deleteQueryBuilder;

	}
	return null;
    }

}
