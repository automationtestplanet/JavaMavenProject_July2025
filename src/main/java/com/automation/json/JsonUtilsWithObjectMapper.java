package com.automation.json;

import java.nio.file.Paths;
import com.automation.models.Credentials;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtilsWithObjectMapper {

	public Credentials readDataFromJson(String jsonFilePath) {
		try {
			ObjectMapper objMapper = new ObjectMapper();
			Credentials credentials = objMapper.readValue(Paths.get(jsonFilePath).toFile(), Credentials.class);  // de-serilization
			return credentials;
		} catch (Exception e) {
			System.out.println("Exception occurred while reading the data from JSON file: " + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		JsonUtilsWithObjectMapper jsonUtilsObjMap = new JsonUtilsWithObjectMapper();
		String jsonFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Files\\Credentials.json";
		Credentials credentials = jsonUtilsObjMap.readDataFromJson(jsonFilePath);
		System.out.println(credentials.getUserName());
		System.out.println(credentials.getPassword());
	}

}
