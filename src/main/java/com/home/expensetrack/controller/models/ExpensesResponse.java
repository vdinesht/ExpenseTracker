package com.home.expensetrack.controller.models;

import java.util.List;

public class ExpensesResponse {

	private Integer totalCount;
	private Integer nextPage;
	private Integer prevPage;
	private Integer size;
	private List<String> listExpenseItems;
	
	

	public List<String> getListExpenseItems() {
		return listExpenseItems;
	}
	public void setListExpenseItems(List<String> listExpenseItems) {
		this.listExpenseItems = listExpenseItems;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	

	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}

	
	public ExpensesResponse(Integer totalCount, Integer nextPage, Integer prevPage,
			List<String> listExpenseItems) {
		super();
		this.totalCount = totalCount;
		this.nextPage = nextPage;
		this.prevPage = prevPage;
		this.listExpenseItems = listExpenseItems;
	}
	@Override
	public String toString() {
		return "ExpensesResponse [totalCount=" + totalCount + ", nextPage=" + nextPage + ", prevPage=" + prevPage
				+ ", size=" + size + ", listExpenseItems=" + listExpenseItems.toString() + "]";
	}
		
	
}
