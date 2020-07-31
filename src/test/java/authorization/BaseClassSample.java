package authorization;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClassSample {

	@BeforeClass
	public void setup() {
		RestAssured.authentication = RestAssured.preemptive().basic("admin", "admin");
		RestAssured.baseURI = "https://the-internet.herokuapp.com/basic_auth/";
	}

}
