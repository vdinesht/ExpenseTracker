package com.home.expensetrack;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.expensetrack.controller.models.ExpenseRequestOptions;
import com.home.expensetrack.controller.models.LoadGSheetRequest;


@SpringBootTest
@AutoConfigureMockMvc
class ExpensetrackControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Expense Tracker is Working!")));
	}

	@Test
	public void expenseApiTestQueryStrings() throws Exception {
		
		//testing page
		this.mockMvc.perform(get("/api/expenses?page=1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("page: 1")));
		
		this.mockMvc.perform(get("/api/expenses")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("page: not provided")));
		
		ExpenseRequestOptions expenseRequest = new ExpenseRequestOptions();
		expenseRequest.setPage(0);
		expenseRequest.setSize(10);
		expenseRequest.setFromDate("2021-01-25");
		expenseRequest.setToDate("2021-10-05");
		ObjectMapper objMapper = new ObjectMapper();
		

		 this.mockMvc.perform(post("/api/expenses")
	                .contentType(MediaType.APPLICATION_JSON_VALUE)
	                .content(objMapper.writeValueAsString(expenseRequest)))
	                .andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.listExpenseItems").isArray());
		
		//testing filter
		
		//testing sort
		
		//testing from
		
		//testing to
		
		
		
	}
	
	@Test
	public void loadGSheetControllerTest() throws Exception {
		
		/*
		LoadGSheetRequest request = new LoadGSheetRequest("/Users/dineshvincent/Downloads/Our Home Expense Tracker - 2015 - Transactions16Oct2021.csv", true);

		ObjectMapper objMapper = new ObjectMapper();
		

		 this.mockMvc.perform(post("/loaddata")
	                .contentType(MediaType.APPLICATION_JSON_VALUE)
	                .content(objMapper.writeValueAsString(request)))
	                .andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.newRecordAddedToDB").value(0));
		
		*/
	}
	
}
