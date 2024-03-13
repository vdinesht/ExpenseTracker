package com.home.expensetrack.data.models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HomeExpense {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGsheetId() {
		return gsheetId;
	}

	public void setGsheetId(Integer gsheetId) {
		this.gsheetId = gsheetId;
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

	@Override
	public String toString() {
		return "HomeExpense [id=" + id + ", gsheetId=" + gsheetId + ", date=" + date + ", currency=" + currency
				+ ", amount=" + amount + ", description=" + description + ", type=" + type + ", category=" + category
				+ ", googleDriveLink=" + googleDriveLink + ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + ", createdBy=" + createdBy + "]";
	}

	public HomeExpense() {
		
	}
	
	
}
