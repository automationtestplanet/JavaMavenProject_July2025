package com.automation.json;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtils {

	public JSONObject readDataFromJson(String jsonFilePath) {
		try {
			JSONParser jParse = new JSONParser();
			JSONObject jsonData = (JSONObject) jParse.parse(new FileReader(new File(jsonFilePath)));
			return jsonData;
		} catch (Exception e) {
			System.out.println("Exception occurred while reading the data from JSON file: " + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		JsonUtils jsonUtils = new JsonUtils();
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Files\\Credentials.json";
		JSONObject jsonData= jsonUtils.readDataFromJson(jsonFilePath);
		System.out.println(jsonData.toString());		
		System.out.println(jsonData.get("userName"));
		System.out.println(jsonData.get("password"));
	}

}
