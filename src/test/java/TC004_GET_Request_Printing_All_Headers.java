import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request_Printing_All_Headers {

	@Test
	public void printAllHeaders() {

		// Specify base URI
		RestAssured.baseURI = "http://localhost:3030";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET, "/services");

		// Printing response body
		String responseBody = response.getBody().asString();
		System.out.println("Response body is : " + responseBody);

		// Printing all response headers
		Headers allHeaders = response.headers();
		for (Header header : allHeaders) {
			System.out.println(header.getName() + " > " + header.getValue());
		}
	}

}
