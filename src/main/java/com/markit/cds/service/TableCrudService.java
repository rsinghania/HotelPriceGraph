package com.markit.cds.service;

import com.markit.cds.domain.UserInput;

public interface TableCrudService {

    void updateTableDataProcess(UserInput userinput);

    void insertTableDataProcess(UserInput userinput);

    void deleteTableDataProcess(UserInput userinput);

}
