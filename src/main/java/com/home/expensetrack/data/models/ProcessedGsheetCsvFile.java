package com.home.expensetrack.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProcessedGsheetCsvFile {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String csvFileName;
	private Long lastModifiedTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCsvFileName() {
		return csvFileName;
	}
	public void setCsvFileName(String csvFileName) {
		this.csvFileName = csvFileName;
	}
	public Long getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	@Override
	public String toString() {
		return "ProcessedGSheetCSVFile [id=" + id + ", csvFileName=" + csvFileName + ", lastModifiedTime="
				+ lastModifiedTime + "]";
	}
	public ProcessedGsheetCsvFile() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
