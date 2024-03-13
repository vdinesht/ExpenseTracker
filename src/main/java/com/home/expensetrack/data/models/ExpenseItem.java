package com.home.expensetrack.data.models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExpenseItem {

	@Id
	private Integer gsheetId;
	
	private Date date;
	private String currency;
	private Float amount;
	private String description;

	private String type;
	private String category;
	private String googleDriveLink;
	
	private Timestamp createdTime;
	private Timestamp updatedTime;
	
	private String createdBy;
	
	
	
	public Integer getGsheetId() {
		return gsheetId;
	}


	public void setGsheetId(Integer gsheetId) {
		this.gsheetId = gsheetId;
	}

	

	public Timestamp getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}


	public Timestamp getUpdatedTime() {
		return updatedTime;
	}


	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
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
	@Override
	public String toString() {
		return "ExpenseItem:  date=" + date + ", currency=" + currency + ", amount=" + amount
				+ ", description=" + description + ", type=" + type + ", category=" + category + ", googleDriveLink="
				+ googleDriveLink + "]";
	}

	public ExpenseItem() {
		
	}
}
