package com.automation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import com.automation.excel.ExcelUtils;
import com.automation.json.JsonUtilsWithObjectMapper;
import com.automation.models.Credentials;
import com.automation.models.LoginDetails;
import com.automation.xml.XMLUtils;

import junit.framework.Assert;

public class TestNGTestCases {

	ExcelUtils excelUtils = new ExcelUtils();
	JsonUtilsWithObjectMapper jsonUtilsObjMap = new JsonUtilsWithObjectMapper();
	XMLUtils xmlUtils = new XMLUtils();

	@Test
	public void excelFileTest() {
		System.out.println("This is Excel file Test");
		String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\InputExcel.xlsx";
		String sheetName = "Languages";

		List<Map<String, String>> excelData = excelUtils.readDataFromExcel(excelFilePath, sheetName);
		List<Map<String, String>> filteredList = excelData.stream()
				.filter(eachMap -> eachMap.get("Language").equalsIgnoreCase("Java")).collect(Collectors.toList());

		Assert.assertTrue(filteredList.size() > 0);
		Assert.assertEquals(filteredList.get(0).get("TypeOfLanguage"), "Object Oriendted Programming");
	}

	@Test
	public void excelFileTest2() {
		System.out.println("This is Excel file Test");
		String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\InputExcel.xlsx";
		String sheetName = "Languages";

		List<Map<String, String>> excelData = excelUtils.readDataFromExcel(excelFilePath, sheetName);
		List<Map<String, String>> filteredList = excelData.stream()
				.filter(eachMap -> eachMap.get("Language").equalsIgnoreCase("Java")).collect(Collectors.toList());

		Assert.assertTrue(filteredList.size() > 0);
		Assert.assertFalse(filteredList.get(0).get("TypeOfLanguage").equals("Object Oriendted Programming1"));
	}

	@Test
	public void jsonFileTest() {
		System.out.println("This is JSON file Test");
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\Credentials.json";
		Credentials credentials = jsonUtilsObjMap.readDataFromJson(jsonFilePath);
		Assert.assertNotNull(credentials);
		Assert.assertEquals("Password is not matching", credentials.getUserName(), "ABC123");
		Assert.assertEquals("Password is not matching", credentials.getPassword(), "abc123");
	}

	@Test
	public void jsonFileTest2() {
		System.out.println("This is JSON file Test");
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\Credentials.json";
		Credentials credentials = jsonUtilsObjMap.readDataFromJson(jsonFilePath);
		Assert.assertNotNull(credentials);
		Assert.assertFalse("Username is matching", credentials.getUserName().equals("ABC1234"));
		Assert.assertFalse("Passsword is matching", credentials.getPassword().equals("abc1234"));
	}

	@Test
	public void xmlFileTest() {
		System.out.println("This is XML file Test");
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Files\\LoginDetails.xml";
		LoginDetails loginDetails = xmlUtils.readDataFromXML(jsonFilePath);
		Assert.assertNotNull(loginDetails);
		Assert.assertEquals(loginDetails.getLoginUserName(), "User123");
		Assert.assertEquals(loginDetails.getLoginPassword(), "Password123");
	}
}
