package com.home.expensetrack.datamigrate.excel.impl;

import com.home.expensetrack.datamigrate.excel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriterImpl implements ExcelWriter {

    private final Logger logger = LoggerFactory.getLogger(ExcelWriterImpl.class);
    private final int CentimeterToPoints = 1000;

    private static CellStyle dateCellStyle;
    private static CellStyle bottomBlackBorderCellStyle;

    private void InitializeWorkBookCellStyles(Workbook workbook) {
        dateCellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        dateCellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("dd MMM yyyy"));

        bottomBlackBorderCellStyle = workbook.createCellStyle();
        bottomBlackBorderCellStyle.setBorderBottom(BorderStyle.THIN);
        bottomBlackBorderCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    }
    @Override
    public boolean writeToFile(ExcelWriterRequest writerRequest) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(writerRequest.sheetName());
        InitializeWorkBookCellStyles(workbook);
        setColumnWidth(sheet, writerRequest.colSizes());
        fillColumnHeaders(workbook, sheet, writerRequest.colHeaders());
        fillRowData(workbook, sheet, writerRequest.colCount(), writerRequest.rowData());

        try {
            FileOutputStream outputStream = new FileOutputStream(writerRequest.fileName());
            workbook.write(outputStream);
        } catch (IOException ioException) {
            logger.info(ioException.toString());
            return false;
        }
        return true;
    }

    private void setColumnWidth(Sheet sheet, List<Integer> colWidths) {
        for (int i = 0; i < colWidths.size(); i++) {
            sheet.setColumnWidth(i, colWidths.get(i) * CentimeterToPoints);
        }
    }

    private void fillColumnHeaders(Workbook workbook, Sheet sheet, List<String> colHeaders) {
        Row header = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        headerStyle.setFont(font);
        headerStyle.setWrapText(true);

        for (int i = 0; i < colHeaders.size(); i++) {
            Cell headerCell = header.createCell(i);
            headerCell.setCellValue(colHeaders.get(i));
            headerCell.setCellStyle(headerStyle);
        }
    }

    private void fillRowData(Workbook workbook, Sheet sheet, int colCount, List<ExcelCell[]> rowData) {
        int rowCount = 1;
        Row row;
        //populate cell information
        for (ExcelCell[] dataCells : rowData) {
            row = sheet.createRow(rowCount);
            fillReportRow(workbook, row, colCount, dataCells);
            ++rowCount;
        }
    }

    private void fillReportRow(Workbook workbook, Row row, int colCount, ExcelCell[] dataCells) {

        for(int col = 0; col < colCount; ++col){
            Cell cell = row.createCell(col);
            setCellStyle(cell, dataCells[col]);
            setCellData(cell, dataCells[col]);
        }
    }

    private static void setCellStyle(Cell cell, ExcelCell dataCell) {
        if (dataCell.getType() == ExcelCellType.date) {  //Date
            cell.setCellStyle(dateCellStyle);
        }

        if (dataCell.getStyle() == ExcelCellStyle.bottomBlackBorder){
            cell.setCellStyle(bottomBlackBorderCellStyle);
        }
    }



    private static void setCellData(Cell cell, ExcelCell dataCell) {

        if (dataCell.getType() == ExcelCellType.date){  //Date
            cell.setCellValue(dataCell.getDate());
        } else if (dataCell.getType() == ExcelCellType.string){  //Text
            cell.setCellValue(dataCell.getText());
        } else if (dataCell.getType() == ExcelCellType.number){
            cell.setCellValue(dataCell.getNumber());
        }
    }
}
