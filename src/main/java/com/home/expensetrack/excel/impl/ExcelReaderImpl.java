package com.home.expensetrack.excel.impl;

import com.home.expensetrack.excel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ExcelReaderImpl implements ExcelReader {
    private final Logger logger = LoggerFactory.getLogger(ExcelReaderImpl.class);
    @Override
    public ExcelReadResponse readFile(ExcelReadRequest request) {
        try {

            FileInputStream fileInputStream = new FileInputStream(request.fullFileName());
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = 0;
            List<ExcelCell[]> readRows = new ArrayList<>();
            for (Row row : sheet) {
                readRows.add(getRowCells(row, request));
                rowCount++;
            }
            ExcelReadResponse readResponse = new ExcelReadResponseImpl(request.colCount(),request.colTypes(),readRows );
            logger.info("Number of SSVP Journal Rows read: " + (rowCount-1));

            return readResponse;
        } catch (IOException ie) {
            logger.error(ie.toString());
            return new ExcelReadResponseImpl();
        }
    }

    private ExcelCell[] getRowCells(Row rowFromFile, ExcelReadRequest request){
        ExcelCell[] rowCells = new ExcelCell[request.colCount()];
        for (Cell cell : rowFromFile) {
            switch (cell.getCellType()) {
                case STRING -> {
                    ExcelCell readExcelCell = new ExcelCellImpl(cell.getStringCellValue(), ExcelCellType.string, ExcelCellStyle.none);
                    rowCells[cell.getColumnIndex()] = readExcelCell;
                }
                case NUMERIC -> {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        LocalDate localDate = cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        ExcelCell readExcelCell = new ExcelCellImpl(localDate, ExcelCellType.date,ExcelCellStyle.none);
                        rowCells[cell.getColumnIndex()] = readExcelCell;
                    } else {
                        ExcelCell readExcelCell = new ExcelCellImpl(cell.getNumericCellValue(), ExcelCellType.number,ExcelCellStyle.none);
                        rowCells[cell.getColumnIndex()] = readExcelCell;
                    }
                }
                default -> {
                    ExcelCell blankExcelCell = new ExcelCellImpl("", ExcelCellType.blank,ExcelCellStyle.none);
                    rowCells[cell.getColumnIndex()] = blankExcelCell;
                }
            }
        }
        return rowCells;
    }

}
