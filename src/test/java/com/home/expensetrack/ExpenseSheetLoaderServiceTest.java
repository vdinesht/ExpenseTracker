package com.home.expensetrack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.home.expensetrack.service.Impl.ExpenseSheetLoaderService;

class ExpenseSheetLoaderServiceTest {
	
	//@Autowired
	//private ExpenseSheetLoaderService expenseSheetDataLoaderService;
	

	@Test
	void test() {
		
		//String flatten = expenseSheetDataLoaderService.flattenAmountLine("12/20/2004,\"8,728.75\",INR,\"India Trip 2004 Dec - Chennai Saravana stores T Nagar - Mixie, Nokia cell phone\",Cash - INR,,,1065");
		//assertEquals("12/20/2004,8728.75,INR,India Trip 2004 Dec - Chennai Saravana stores T Nagar - Mixie? Nokia cell phone,Cash - INR,,,1065", flatten);
	}

}
