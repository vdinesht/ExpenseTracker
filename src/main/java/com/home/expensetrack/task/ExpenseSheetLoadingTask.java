package com.home.expensetrack.task;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.home.expensetrack.data.models.ProcessedGsheetCsvFile;
import com.home.expensetrack.data.repository.ProcessedGsheetCsvFileRepository;
import com.home.expensetrack.service.ExpenseSheetDataFile;
import com.home.expensetrack.service.ExpenseSheetDataLoader;


@Component
public class ExpenseSheetLoadingTask {
	private final Logger logger = LoggerFactory.getLogger(ExpenseSheetLoadingTask.class);
	
	@Autowired
	private ExpenseSheetDataFile expenseSheetDataFileService;
	
	@Autowired
	private ExpenseSheetDataLoader expenseSheetLoaderService;
	
	@Autowired
	private ProcessedGsheetCsvFileRepository processedCsvFileRepo;
	
	
	@Scheduled(initialDelay = 1000, fixedDelay=Long.MAX_VALUE) //Run only once
	public void loadExpenseSheetDataIntoDB() {
		
		logger.info("Loading Expense Sheet Data into Database...");
		Optional<Path> gSheetFilePath = expenseSheetDataFileService.GetLateshDataFile();
		
		if (gSheetFilePath.isPresent()) {
			
			String fileName = gSheetFilePath.get().getFileName().toString();
			Long lastModifiedTime = gSheetFilePath.get().toFile().lastModified();
			
			logger.info("File name: " + fileName);
			logger.info("Last Modified: " + lastModifiedTime);
			
			List<ProcessedGsheetCsvFile> listCsvFile = processedCsvFileRepo.findByCsvFileName(fileName);
			
			if (!listCsvFile.isEmpty()) //Same file name processed before
			{
				
				ProcessedGsheetCsvFile processedCsvFile = listCsvFile.get(0);
				logger.info("Processed CSV File found: " + processedCsvFile.toString());
				
				if (processedCsvFile.getLastModifiedTime() < lastModifiedTime) {
					
					//update the last modified time
					processedCsvFile.setLastModifiedTime(lastModifiedTime);
					logger.info("New file with same name found. Load data into DB.");
					expenseSheetLoaderService.loadDataIntoDB(gSheetFilePath.get());
					processedCsvFileRepo.save(processedCsvFile);
				}
				else {
					logger.info("Data from this CSV file is already processed.");
				}
				
			}
			else { //File not found in DB new file
				
				ProcessedGsheetCsvFile newCsvFile  = new ProcessedGsheetCsvFile();
				newCsvFile.setCsvFileName(fileName);
				newCsvFile.setLastModifiedTime(lastModifiedTime);
				logger.info("Saved new csv file & Load data into DB.");
				expenseSheetLoaderService.loadDataIntoDB(gSheetFilePath.get());
				processedCsvFileRepo.save(newCsvFile);
			}
		}
		
		logger.info("Loading Completed.");
	}
	
}
