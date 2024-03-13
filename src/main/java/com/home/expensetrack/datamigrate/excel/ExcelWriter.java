package com.home.expensetrack.datamigrate.excel;

public interface ExcelWriter {
    boolean writeToFile(ExcelWriterRequest writerRequest);
}
