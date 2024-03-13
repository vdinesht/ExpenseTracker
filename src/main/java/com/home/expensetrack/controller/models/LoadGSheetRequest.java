package com.home.expensetrack.controller.models;

public class LoadGSheetRequest {
	
	private String filePath;
	private Boolean dryRun;
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Boolean getDryRun() {
		return dryRun;
	}
	public void setDryRun(Boolean dryRun) {
		this.dryRun = dryRun;
	}
	public LoadGSheetRequest(String filePath, Boolean dryRun) {
		super();
		this.filePath = filePath;
		this.dryRun = dryRun;
	}
	@Override
	public String toString() {
		return "LoadGSheetRequest [filePath=" + filePath + ", dryRun=" + dryRun + "]";
	}
	
	

}
