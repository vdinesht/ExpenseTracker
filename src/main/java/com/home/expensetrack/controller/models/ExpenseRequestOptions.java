package com.home.expensetrack.controller.models;

import java.time.LocalDate;

public class ExpenseRequestOptions {
	private Integer page;
	private Integer size;
	private String filter;
	private String fromDate;
	private String toDate;
	
	
	
	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getSize() {
		return size;
	}


	public void setSize(Integer size) {
		this.size = size;
	}


	public String getFilter() {
		return filter;
	}


	public void setFilter(String filter) {
		this.filter = filter;
	}


	public String getFromDate() {
		return fromDate;
	}


	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}


	public String getToDate() {
		return toDate;
	}


	public void setToDate(String toDate) {
		this.toDate = toDate;
	}


	public ExpenseRequestOptions(Integer page, Integer size, String filter, String fromDate, String toDate) {
		super();
		this.page = page;
		this.size = size;
		this.filter = filter;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	
	public ExpenseRequestOptions() {
		super();
		// TODO Auto-generated constructor stub
		this.page = 1;
		this.size = 100;
		this.filter = "";
		
		LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1);
		
		this.fromDate =   firstDayOfMonth.toString(); //first day of this month
		this.toDate = LocalDate.now().toString(); //today
		 
	}


	@Override
	public String toString() {
		return "ExpenseRequestOptions [page=" + page + ", size=" + size + ", filter=" + filter + ", fromDate="
				+ fromDate + ", toDate=" + toDate + "]";
	}
	
	

}
