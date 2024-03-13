package com.home.expensetrack.service;

import java.nio.file.Path;
import java.util.Optional;

public interface ExpenseSheetDataFile {

	Optional<Path> GetLateshDataFile();
}
