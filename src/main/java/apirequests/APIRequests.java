package apirequests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import base.TestBase;

public class APIRequests extends TestBase {

	public static RequestSpecification request() {
		return RestAssured.given().urlEncodingEnabled(false);
	}
	
	public Response getAvailablePets(String url, String api, String petStatus) {
		Response response = null ;
		try {
			response = request().header("Content-Type", "application/json")
					.get(url + api + "?" + "status=" + petStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response ;
	}
	
	public Response addAvailablePets(String url, String api, int idOfPet) {
		Response response = null ;
		try {
			String body = "{\r\n" + 
					"    \"id\": " + idOfPet + ",\r\n" + 
					"    \"category\": {\r\n" + 
					"        \"id\": 0,\r\n" + 
					"        \"name\": \"string\"\r\n" + 
					"    },\r\n" + 
					"    \"name\": \"doggie\",\r\n" + 
					"    \"photoUrls\": [\r\n" + 
					"        \"string\"\r\n" + 
					"    ],\r\n" + 
					"    \"tags\": [\r\n" + 
					"        {\r\n" + 
					"            \"id\": 0,\r\n" + 
					"            \"name\": \"string\"\r\n" + 
					"        }\r\n" + 
					"    ],\r\n" + 
					"    \"status\": \"available\"\r\n" + 
					"}";
			response = request()
						.header("accept", "application/json")
						.header("Content-Type", "application/json")
						.body(body)
						.post(url + api);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public Response updatePetStatus(String apiUrl, String addPetApi, int idOfPet, String status) {
		Response response = null ;
		try {
			String body = "{\r\n" + 
					"    \"id\": " + idOfPet + ",\r\n" + 
					"    \"category\": {\r\n" + 
					"        \"id\": 0,\r\n" + 
					"        \"name\": \"string\"\r\n" + 
					"    },\r\n" + 
					"    \"name\": \"doggie\",\r\n" + 
					"    \"photoUrls\": [\r\n" + 
					"        \"string\"\r\n" + 
					"    ],\r\n" + 
					"    \"tags\": [\r\n" + 
					"        {\r\n" + 
					"            \"id\": 0,\r\n" + 
					"            \"name\": \"string\"\r\n" + 
					"        }\r\n" + 
					"    ],\r\n" + 
					"    \"status\": \"" + status + "\"\r\n" + 
					"}";
			response = request()
						.header("Content-Type", "application/json")
						.body(body)
						.put(apiUrl + addPetApi);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public Response deletePetInfo(String apiUrl, String addPetApi, int idOfPet) {
		Response response = null ;
		try {
			response = request()
						.header("Content-Type", "application/json")
						.delete(apiUrl + addPetApi + "/" + idOfPet);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
