package com.home.expensetrack.datamigrate.excel.impl;

import com.home.expensetrack.datamigrate.excel.ExcelCellType;
import com.home.expensetrack.datamigrate.excel.ExcelReadRequest;

public class ExcelReadRequestImpl implements ExcelReadRequest {


    @Override
    public int colCount() {
        return 0;
    }

    @Override
    public ExcelCellType[] colTypes() {
        return new ExcelCellType[0];
    }

    @Override
    public String fullFileName() {
        return null;
    }


}
