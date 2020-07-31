package authorization;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CookieBasedAuthentication {

	@Test
	public void createJsessionID() {

		JSONObject json = new JSONObject();
		json.put("username", "jiralocalusername");
		json.put("password", "jiralocalpassword");

		Response response = RestAssured.given().header("Content-Type", "application/json").body(json.toJSONString())
				.post("http://jira.example.com:8090/jira/rest/auth/1/session");

		System.out.println(response.getStatusCode());
		System.out.println(response.jsonPath().prettify());
		String sessionID = response.getCookies().get("JSESSIONID");

		Response resp = RestAssured.given().contentType(ContentType.JSON).cookie("JSESSIONID", sessionID).body(
				"{\"fields\": {\"project\":{\"key\": \"TEST\"},\"summary\": \"REST ye merry gentlemen.\",\"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\"issuetype\": {\"name\": \"Bug\"}}}")
				.post("http://localhost:8080/rest/api/2/issue/");

		System.out.println(resp.jsonPath().prettify());

	}

}
