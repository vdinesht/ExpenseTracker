package com.home.expensetrack.excel;

public interface ExcelWriter {
    boolean writeToFile(ExcelWriterRequest writerRequest);
}
