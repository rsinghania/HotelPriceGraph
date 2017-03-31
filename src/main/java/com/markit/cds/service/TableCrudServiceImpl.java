package com.markit.cds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markit.cds.daoImpl.TableOperationsDao;
import com.markit.cds.domain.UserInput;

@Service
public class TableCrudServiceImpl implements TableCrudService {

    @Autowired
    private TableOperationsDao tableOperationsDao;

    @Override
    public void updateTableDataProcess(UserInput userinput) {
	tableOperationsDao.update(userinput);
    }

    @Override
    public void insertTableDataProcess(UserInput userinput) {
	tableOperationsDao.insert(userinput);
    }

    @Override
    public void deleteTableDataProcess(UserInput userinput) {
	// tableOperationsDao.insert(userinput);
	tableOperationsDao.delete(userinput);
    }

}