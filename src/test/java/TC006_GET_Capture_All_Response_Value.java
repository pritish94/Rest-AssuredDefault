import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_Capture_All_Response_Value {

	@Test
	public void captureAllResponseValue() {

		// Specify base URI
		RestAssured.baseURI = "http://localhost:3030";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET, "/healthcheck");

		JsonPath jsonPath = response.jsonPath();

		// to print response in readable JSON format
		System.out.println(jsonPath.prettify());

		System.out.println(jsonPath.get("uptime"));
		System.out.println(jsonPath.get("readonly"));
		System.out.println(jsonPath.get("documents"));
		System.out.println(jsonPath.get("stores")); // nested object

		Assert.assertEquals(jsonPath.get("readonly"), false);
	}
}
