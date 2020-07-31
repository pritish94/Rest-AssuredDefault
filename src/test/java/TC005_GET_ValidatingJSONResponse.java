import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_ValidatingJSONResponse {

	@Test
	public void validatingJSONResponse() {

		// Specify base URI
		RestAssured.baseURI = "http://localhost:3030";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET, "/healthcheck");

		// Validating response
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("4321"));
	}

}
