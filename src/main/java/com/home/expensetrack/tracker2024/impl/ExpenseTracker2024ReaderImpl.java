package com.home.expensetrack.tracker2024.impl;

import com.home.expensetrack.excel.*;
import com.home.expensetrack.excel.impl.ExcelReaderImpl;
import com.home.expensetrack.tracker2024.DataRow2024;
import com.home.expensetrack.tracker2024.ExpenseTracker2024Reader;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseTracker2024ReaderImpl implements ExpenseTracker2024Reader {
    private List<DataRow2024> allRows = new ArrayList<>();
    private final String tracker2024File = "C:\\Temp\\ExpenseTracker\\OurHomeExpense2024.xlsx";
    @Override
    public List<DataRow2024> getAllRows() {
        if (allRows.isEmpty())
            readAllRecordsFromFile();

        return this.allRows;
    }

    private void readAllRecordsFromFile(){
        ExcelReadRequest readRequest = new ExpenseTracker2024ExcelReadRequestImpl(tracker2024File);

        ExcelReader excelReader = new ExcelReaderImpl();
        ExcelReadResponse response = excelReader.readFile(readRequest);
        List<ExcelCell[]> rows = response.rowData();

        for (ExcelCell[] row : rows) {
            allRows.add(getDataRow2024(row));
        }

    }

    private static DataRow2024 getDataRow2024(ExcelCell[] row) {
        LocalDate date = LocalDate.now();
        Double amount = 0D;
        String currency = "INR";
        String description = "";
        String debitAc = "";
        String creditAc = "";
        String debitSubAc = "";
        String creditSubAc = "";
        String groupTag = "";
        String glink = "";
        Integer id = 0;

        if (row[0].getType() == ExcelCellType.date)
            date = row[0].getDate();

        if (row[1].getType() == ExcelCellType.number)
            amount = row[1].getNumber();

        if(row[2].getType()==ExcelCellType.string)
            currency = row[2].getText();

        if(row[3].getType()==ExcelCellType.string)
            description = row[3].getText();

        if(row[4].getType()==ExcelCellType.string)
            debitAc = row[4].getText();

        if(row[5].getType()==ExcelCellType.string)
            creditAc = row[5].getText();

        if(row[6].getType()==ExcelCellType.string)
            debitSubAc = row[6].getText();

        if(row[7].getType()==ExcelCellType.string)
            creditSubAc = row[7].getText();

        if(row[9].getType()==ExcelCellType.string)
            groupTag = row[9].getText();

        if(row[10].getType()==ExcelCellType.string)
            glink = row[10].getText();

        if (row[11].getType() == ExcelCellType.number)
            id = row[11].getNumber().intValue();

        DataRow2024 dataRow = new DataRow2024Impl(date,amount,currency,description,debitAc,creditAc,debitSubAc, creditSubAc,groupTag,glink,id);
        return dataRow;
    }
}
