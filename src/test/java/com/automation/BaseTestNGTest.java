package com.automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestNGTest {

	@BeforeSuite(alwaysRun = true)
	public void beforeSuit() {
		System.out.println("This is Before Suit");
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("This is Before Test");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("This is Before Class");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("This is after Method");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("This is After Class");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("This is After Test");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuit() {
		System.out.println("This is After Suit");
	}
}
