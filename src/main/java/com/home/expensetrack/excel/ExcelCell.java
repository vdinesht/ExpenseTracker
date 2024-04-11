package com.home.expensetrack.excel;

import java.time.LocalDate;

public interface ExcelCell {
    LocalDate getDate();
    Double getNumber();
    String getText();
    ExcelCellType getType();
    ExcelCellStyle getStyle();
}
