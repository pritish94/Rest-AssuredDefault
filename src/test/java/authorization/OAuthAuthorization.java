package authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuthAuthorization {

	@Test
	public void OAuthAuthorizationTest() {

		Response response = RestAssured.given().auth()
				.oauth("consumerKey", "consumerSecret", "accessToken", "secretToken").post("uri");

		System.out.println(response.getStatusCode());
		System.out.println(response.jsonPath().prettify());
	}

}
