package com.home.expensetrack.datamigrate.tracker2024.impl;

import com.home.expensetrack.datamigrate.excel.*;
import com.home.expensetrack.datamigrate.excel.impl.ExcelCellImpl;
import com.home.expensetrack.datamigrate.excel.impl.ExcelWriterImpl;
import com.home.expensetrack.datamigrate.tracker2024.DataRow2024;
import com.home.expensetrack.datamigrate.tracker2024.HomeExpenseTracker2024;

import java.util.ArrayList;
import java.util.List;

public class HomeExpenseTracker2024Impl implements HomeExpenseTracker2024 {

    private List<DataRow2024> allRows;
    private final int colCount = 12;
    @Override
    public boolean SaveToExcelFile(String fileName) {

        ExcelWriterRequest writerRequest = new ExpenseTracker2024ExcelWriterRequestImpl(fileName, getExcelData(allRows));
        ExcelWriter excelWriter = new ExcelWriterImpl();
        return excelWriter.writeToFile(writerRequest);
    }

    @Override
    public List<DataRow2024> getAllRows() {
        return this.allRows;
    }

    public HomeExpenseTracker2024Impl(List<DataRow2024> allRows) {
        this.allRows = allRows;
    }

    private List<ExcelCell[]> getExcelData(List<DataRow2024> dataRows){
        List<ExcelCell[]> rows = new ArrayList<>();
        for(DataRow2024 dataRow: dataRows){
           ExcelCell[] cells = new ExcelCell[colCount];
           cells[0] = new ExcelCellImpl(dataRow.date(), ExcelCellType.date,ExcelCellStyle.none);
           cells[1] = new ExcelCellImpl(dataRow.amount(),ExcelCellType.number,ExcelCellStyle.none);
           cells[2] = new ExcelCellImpl(dataRow.currency(),ExcelCellType.string, ExcelCellStyle.none);
           cells[3] = new ExcelCellImpl(dataRow.description(),ExcelCellType.string, ExcelCellStyle.none);
           cells[4] = new ExcelCellImpl(dataRow.debitAccount().getValue(),ExcelCellType.string, ExcelCellStyle.none);
           cells[5] = new ExcelCellImpl(dataRow.creditAccount().getValue(),ExcelCellType.string, ExcelCellStyle.none);
           cells[6] = new ExcelCellImpl(dataRow.debitSubAccount(),ExcelCellType.string, ExcelCellStyle.none);
           cells[7] = new ExcelCellImpl(dataRow.creditSubAccount(),ExcelCellType.string, ExcelCellStyle.none);
           cells[8] = new ExcelCellImpl(dataRow.transType2015(),ExcelCellType.string, ExcelCellStyle.none);
           cells[9] = new ExcelCellImpl(dataRow.groupTag().getValue(),ExcelCellType.string, ExcelCellStyle.none);
           cells[10] = new ExcelCellImpl(dataRow.gdriveLink(),ExcelCellType.string, ExcelCellStyle.none);
           cells[11] = new ExcelCellImpl(Double.parseDouble(Integer.toString(dataRow.id())),ExcelCellType.number,ExcelCellStyle.none);
           rows.add(cells);
        }

        return rows;

    }
}
