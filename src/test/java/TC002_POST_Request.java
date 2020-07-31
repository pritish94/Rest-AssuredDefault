import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {

	@Test
	void registrationSuccessfull() {

		// Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request payLoad sending alone with post request
		JSONObject requestParams = new JSONObject();

		requestParams.put("FirstName", "sachin");
		requestParams.put("LastName", "Mohan123");
		requestParams.put("UserName", "virat123");
		requestParams.put("Password", "Desh123");
		requestParams.put("Email", "virat123@gmail.com");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		// Response object
		Response response = httpRequest.request(Method.POST, "/register");

		// Print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);

		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		Assert.assertEquals(statusCode, 201);

		// Success code validation
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println("Success code: " + successCode);
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}
}
