package com.home.expensetrack.datamigrate.excel.impl;


import com.home.expensetrack.datamigrate.excel.ExcelCell;
import com.home.expensetrack.datamigrate.excel.ExcelCellStyle;
import com.home.expensetrack.datamigrate.excel.ExcelCellType;

import java.time.LocalDate;

public class ExcelCellImpl implements ExcelCell {

    LocalDate date;
    Double number;
    String text;
    ExcelCellType cellType;
    ExcelCellStyle cellStyle;

    public ExcelCellImpl(String text, ExcelCellType cellType, ExcelCellStyle cellStyle) {
        this.text = text;
        this.cellType = cellType;
        this.cellStyle = cellStyle;
    }

    public ExcelCellImpl(Double number, ExcelCellType cellType, ExcelCellStyle cellStyle) {
        this.number = number;
        this.cellType = cellType;
        this.cellStyle = cellStyle;
    }

    public ExcelCellImpl(LocalDate date, ExcelCellType cellType, ExcelCellStyle cellStyle) {
        this.date = date;
        this.cellType = cellType;
        this.cellStyle = cellStyle;
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public Double getNumber() {
        return this.number;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public ExcelCellType getType() {
        return this.cellType;
    }

    @Override
    public ExcelCellStyle getStyle() {
        return this.cellStyle;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCellType(ExcelCellType cellType) {
        this.cellType = cellType;
    }

    public void setCellStyle(ExcelCellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }
}
