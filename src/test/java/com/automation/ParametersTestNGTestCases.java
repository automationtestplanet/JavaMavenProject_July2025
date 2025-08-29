package com.automation;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTestNGTestCases extends BaseTestNGTest{

	@Test
	@Parameters({"UserName","Password"})
	public void primntParameters(String userName, String password) {
		System.out.println("UserName: "+userName);
		System.out.println("Password: "+password);
	}
}
