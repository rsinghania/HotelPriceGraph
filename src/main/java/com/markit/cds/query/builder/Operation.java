package com.markit.cds.query.builder;

public enum Operation {

    INSERT("INSERT"),
    UPDATE("UPDATE"),
    DELETE("DELETE");
    
    private String value;
    
    private Operation(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}
