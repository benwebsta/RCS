package com.revature.driver;

import com.revature.service.HRService;

public class Driver {

	public static void main(String[] args) {

		HRService hrService = new HRService();
		System.out.println(hrService.getAllEmployeesInHousing());
		
	}

}
