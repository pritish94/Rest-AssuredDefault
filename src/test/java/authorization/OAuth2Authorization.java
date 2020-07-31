package authorization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth2Authorization {

	@Test
	public void oAuth2Authorization() {
		Response resp = RestAssured.given().auth().oauth2("ec291528fa6647faa6a49e8bc2040ec62a068d03")
				.post("http://coop.apps.symfonycasts.com/api/1182/chickens-feed");

		Assert.assertEquals(resp.getStatusCode(), 200);

		System.out.println(resp.jsonPath().prettify());

	}

}
