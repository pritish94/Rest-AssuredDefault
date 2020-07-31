package authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicPreemptiveAuthentication {

	@Test
	public void basicPreemptiveAuthentication() {
		int statuscode = RestAssured.given().auth().preemptive().basic("admin", "admin")
				.get("https://the-internet.herokuapp.com/basic_auth/").getStatusCode();

		System.out.println("Response status code is: " + statuscode);
	}

}
