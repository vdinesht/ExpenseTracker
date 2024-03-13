package com.home.expensetrack.service.Impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.home.expensetrack.service.ExpenseSheetDataFile;

@Service
public class ExpenseSheetDataFileService implements ExpenseSheetDataFile {

	private final Logger  logger = LoggerFactory.getLogger(ExpenseSheetDataFileService.class);
	
	@Value( "${expense.sheet.csvfile.folder:/Users/dineshvincent/Documents/HomeBills}" )
	private String expenseSheetFolder;
	

	@Override
	public Optional<Path> GetLateshDataFile() {
		
		Optional<Path> latestFilePath = Optional.empty();
		
		Path dir = Paths.get(expenseSheetFolder);

		try {
			latestFilePath = Files.list(dir)    // here we get the stream with full directory listing
				    .filter(f -> f.toString().endsWith(".csv"))  // only csv files
				    .max(Comparator.comparingLong(f -> f.toFile().lastModified()));
			if (latestFilePath.isPresent()) {
				logger.info("Files found in " + expenseSheetFolder + ": " + latestFilePath.toString());
			}
			else {
				logger.info("No file found.");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
		return latestFilePath;
	}

}
