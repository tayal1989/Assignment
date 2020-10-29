package apirequests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import base.TestBase;

public class APIRequests extends TestBase {

	/**
	 * It will create request using Rest assured
	 * @return rest api request
	 */
	public static RequestSpecification request() {
		return RestAssured.given().urlEncodingEnabled(false);
	}
	
	/**
	 * This is a get api to get available pets
	 * @param url - url of swagger
	 * @param api - api name
	 * @param petStatus - available/sold
	 * @return - response of api
	 */
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
	
	/**
	 * This is post request to add pets
	 * @param url - url of swagger
	 * @param api - api name
	 * @param idOfPet - id of pet
	 * @return - response of api
	 */
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

	/**
	 * This is put request to update pet status
	 * @param apiUrl - swagger url
	 * @param addPetApi - api name
	 * @param idOfPet - id of pet
	 * @param status - status to be changed
	 * @return - response of api
	 */
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
	
	/**
	 * This will delete pet information from swagger
	 * @param apiUrl - swagger url
	 * @param addPetApi - api name
	 * @param idOfPet - id of pet
	 * @return - response of api
	 */
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
