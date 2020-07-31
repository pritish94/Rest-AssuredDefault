package authorization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth2AceessTokenGeneration {

	@Test
	public void testValidDemo() {

		Response resp = RestAssured.given().formParam("client_id", "PritishAPP")
				.formParam("client_secret", "585e3888fcd46e8ef22c3e1480ee4b69")
				.formParam("grant_type", "client_credentials").post("http://coop.apps.symfonycasts.com/token");

		// System.out.println(resp.jsonPath().prettify());

		String token = resp.jsonPath().get("access_token");

		Response resp1 = RestAssured.given().auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/1182/chickens-feed");

		System.out.println(resp1.jsonPath().prettify());

		Assert.assertEquals(resp1.getStatusCode(), 200);

	}

	@Test
	public void testInvalidDemo() {

		Response resp = RestAssured.given().formParam("client_id", "PritishAPP")
				.formParam("client_secret", "585e3888fcd46e8ef22c3e1480ee4b69")
				.formParam("grant_type", "client_credentials").post("http://coop.apps.symfonycasts.com/token");

		// System.out.println(resp.jsonPath().prettify());

		String token = resp.jsonPath().get("access_token");

		Response resp1 = RestAssured.given().auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/1182/toiletseat-down");

		System.out.println(resp1.getBody().asString());

		Assert.assertEquals(resp1.getStatusCode(), 401);
	}

}
