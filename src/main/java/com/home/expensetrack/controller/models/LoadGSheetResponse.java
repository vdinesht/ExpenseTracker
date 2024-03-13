package com.home.expensetrack.controller.models;

public class LoadGSheetResponse {
	private Integer totalRecordsInDB;
	private Integer totalRecordsInGSheet;
	private Integer newRecordAddedToDB;
	private Integer modifiedRecordInDB;
	
	public Integer getTotalRecordsInDB() {
		return totalRecordsInDB;
	}
	public void setTotalRecordsInDB(Integer totalRecordsInDB) {
		this.totalRecordsInDB = totalRecordsInDB;
	}
	public Integer getTotalRecordsInGSheet() {
		return totalRecordsInGSheet;
	}
	public void setTotalRecordsInGSheet(Integer totalRecordsInGSheet) {
		this.totalRecordsInGSheet = totalRecordsInGSheet;
	}
	public Integer getNewRecordAddedToDB() {
		return newRecordAddedToDB;
	}
	public void setNewRecordAddedToDB(Integer newRecordAddedToDB) {
		this.newRecordAddedToDB = newRecordAddedToDB;
	}
	public Integer getModifiedRecordInDB() {
		return modifiedRecordInDB;
	}
	public void setModifiedRecordInDB(Integer modifiedRecordInDB) {
		this.modifiedRecordInDB = modifiedRecordInDB;
	}
	public LoadGSheetResponse() {

	}
	
	@Override
	public String toString() {
		return "LoadGSheetResponse [totalRecordsInDB=" + totalRecordsInDB + ", totalRecordsInGSheet="
				+ totalRecordsInGSheet + ", newRecordAddedToDB=" + newRecordAddedToDB + ", modifiedRecordInDB="
				+ modifiedRecordInDB + "]";
	}


}
