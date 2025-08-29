package com.automation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.After;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.excel.ExcelUtils;
import com.automation.json.JsonUtilsWithObjectMapper;
import com.automation.models.Credentials;
import com.automation.models.LoginDetails;
import com.automation.xml.XMLUtils;

import junit.framework.Assert;

public class TestNGTestCases extends BaseTestNGTest{

	ExcelUtils excelUtils = new ExcelUtils();
	JsonUtilsWithObjectMapper jsonUtilsObjMap = new JsonUtilsWithObjectMapper();
	XMLUtils xmlUtils = new XMLUtils();

	@Test(priority = 1, groups = { "ExcelFileTest", "SmokeTest", "SanityTest", "RegressionTest" })
	public void excelFileTest() {
		System.out.println("This is Excel file Test1");
		String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\InputExcel.xlsx";
		String sheetName = "Languages";

		List<Map<String, String>> excelData = excelUtils.readDataFromExcel(excelFilePath, sheetName);
		List<Map<String, String>> filteredList = excelData.stream()
				.filter(eachMap -> eachMap.get("Language").equalsIgnoreCase("Java")).collect(Collectors.toList());

		Assert.assertTrue(filteredList.size() > 0);
		Assert.assertEquals(filteredList.get(0).get("TypeOfLanguage"), "Object Oriendted Programming");
		Reporter.log("<span style=\"color: DarkGreen;\">TypeOfLanguage showing as Object Oriendted Programming</span>");
	}

	@Test(priority = 4, groups = { "ExcelFileTest", "SanityTest", "RegressionTest" })
	public void excelFileTest2() {
		System.out.println("This is Excel file Test2");
		String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\InputExcel.xlsx";
		String sheetName = "Languages";

		List<Map<String, String>> excelData = excelUtils.readDataFromExcel(excelFilePath, sheetName);
		List<Map<String, String>> filteredList = excelData.stream()
				.filter(eachMap -> eachMap.get("Language").equalsIgnoreCase("Java")).collect(Collectors.toList());

		Assert.assertTrue(filteredList.size() > 0);
		Assert.assertFalse(filteredList.get(0).get("TypeOfLanguage").equals("Object Oriendted Programming1"));
		Reporter.log("<span style=\"color: Red;\">TypeOfLanguage showing as Object Oriendted Programming1</span>");
	}

	@Test(priority = 0, groups = { "JsonFileTest", "SmokeTest", "SanityTest", "RegressionTest" })
	public void jsonFileTest() {
		System.out.println("This is JSON file Test1");
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\Credentials.json";
		Credentials credentials = jsonUtilsObjMap.readDataFromJson(jsonFilePath);
		Assert.assertNotNull(credentials);
		Assert.assertEquals("Password is not matching", credentials.getUserName(), "ABC123");
		Assert.assertEquals("Password is not matching", credentials.getPassword(), "abc123");
		Reporter.log("<span style=\"color: Red;\">Password is matching and password is " + credentials.getPassword()
				+ "</span>");
	}

	@Test(priority = 5, invocationCount = 3, groups = { "JsonFileTest", "RegressionTest" })
	public void jsonFileTest2() {
		System.out.println("This is JSON file Test2");
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\Credentials.json";
		Credentials credentials = jsonUtilsObjMap.readDataFromJson(jsonFilePath);
		Assert.assertNotNull(credentials);
		Assert.assertFalse("Username is matching", credentials.getUserName().equals("ABC1234"));
		Assert.assertFalse("Passsword is matching", credentials.getPassword().equals("abc1234"));
		Reporter.log("<span style=\"color: Green;\">Username is matching and password is " + credentials.getUserName()
				+ "</span>");
	}

	@Test(priority = 2, enabled = true, groups = { "XmlFileTest", "SmokeTest", "SanityTest", "RegressionTest" })
	public void xmlFileTest() {
		System.out.println("This is XML file Test1");
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Files\\LoginDetails.xml";
		LoginDetails loginDetails = xmlUtils.readDataFromXML(jsonFilePath);
		Assert.assertNotNull(loginDetails);
		Assert.assertEquals(loginDetails.getLoginUserName(), "User123");
		Assert.assertEquals(loginDetails.getLoginPassword(), "Password123");
		Reporter.log("<span style=\"color: Green;\">XML Username is matching and password is "
				+ loginDetails.getLoginUserName() + "</span>");
	}

	@Test(priority = 3, groups = { "XmlFileTest", "SanityTest"})
	public void accessXmlFileDataTest() {
		System.out.println("This is XML file Test2");
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Files\\LoginDetails.xml";
		LoginDetails loginDetails = xmlUtils.readDataFromXML(jsonFilePath);
		Assert.assertNotNull(loginDetails);
		Assert.assertEquals(loginDetails.getLoginUserName(), "User123");
		Assert.assertEquals(loginDetails.getLoginPassword(), "Password123");
		Reporter.log("<span style=\"color: Green;\">XML Password is matching and password is "
				+ loginDetails.getLoginPassword() + "</span>");
	}
}
