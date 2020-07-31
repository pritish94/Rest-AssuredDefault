package authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicPreemptiveAuthenticationExtendingBase extends BaseClassSample {

	@Test
	public void basicPreemptiveAuthentication() {
		int statuscode = RestAssured.given().get().getStatusCode();

		System.out.println("Response status code is: " + statuscode);
	}

}
