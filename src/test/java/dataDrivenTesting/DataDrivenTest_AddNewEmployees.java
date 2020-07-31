package dataDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployees {

	@Test(dataProvider = "categoryDataProvider")
	public void bestBuyCategoryPost(String cName, String cID) {

		RestAssured.baseURI = "http://localhost:3030";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		requestParams.put("name", cName);
		requestParams.put("id", cID);

		httpRequest.header("content-type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST, "/categories");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		Assert.assertTrue(responseBody.contains(cName));
		Assert.assertTrue(responseBody.contains(cID));
		Assert.assertEquals(response.getStatusCode(), 201);

	}

	@DataProvider(name = "categoryDataProvider")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\dataDrivenTesting\\testData.xlsx";

		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		// System.out.println(rowCount);
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		// System.out.println(colCount);

		String[][] data = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return data;
		// String[][] data = { { "abc124", "1995" }, { "abc125", "1996" } };
	}

}
