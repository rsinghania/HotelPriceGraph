package com.markit.cds.query.builder;

import com.markit.cds.domain.UserInput;

public interface QueryBuilder {

    String build(UserInput userInput);
}
