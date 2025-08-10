package com.automation.xml;

import java.nio.file.Paths;
import com.automation.models.LoginDetails;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLUtils {
	public LoginDetails readDataFromXML(String xmlFilePath) {
		try {
			XmlMapper xmpMap = new XmlMapper();
			LoginDetails loginDetails = xmpMap.readValue(Paths.get(xmlFilePath).toFile(), LoginDetails.class);
			return loginDetails;
		} catch (Exception e) {
			System.out.println("Exception occurred while reading the data form XML file: " + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		XMLUtils xmlUtils = new XMLUtils();
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Files\\LoginDetails.xml";
		LoginDetails loginDetails = xmlUtils.readDataFromXML(jsonFilePath);
		System.out.println(loginDetails.getLoginUserName());
		System.out.println(loginDetails.getLoginPassword());
	}
}
