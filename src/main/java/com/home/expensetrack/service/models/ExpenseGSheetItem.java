package com.home.expensetrack.service.models;

public class ExpenseGSheetItem {
	private String date;
	private String currency;
	private String amount;
	private String description;

	private String type;
	private String category;
	private String googleDriveLink;
	private String gSheetId;
	
	
	
	public String getgSheetId() {
		return gSheetId;
	}
	public void setgSheetId(String gSheetId) {
		this.gSheetId = gSheetId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGoogleDriveLink() {
		return googleDriveLink;
	}
	public void setGoogleDriveLink(String googleDriveLink) {
		this.googleDriveLink = googleDriveLink;
	}

	
	public ExpenseGSheetItem() {
		
	}
	@Override
	public String toString() {
		return "ExpenseGSheetItem [date=" + date + ", currency=" + currency + ", amount=" + amount + ", description="
				+ description + ", type=" + type + ", category=" + category + ", googleDriveLink=" + googleDriveLink
				+ ", gSheetId=" + gSheetId + "]";
	}
	public ExpenseGSheetItem(String date, String currency, String amount, String description, String type,
			String category, String googleDriveLink, String gSheetId) {
		super();
		this.date = date;
		this.currency = currency;
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.category = category;
		this.googleDriveLink = googleDriveLink;
		this.gSheetId = gSheetId;
	}
	
	public Boolean isValidRecord() {
		return true;
	}
	
}
