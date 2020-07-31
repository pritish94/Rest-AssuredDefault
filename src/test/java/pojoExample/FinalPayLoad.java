package pojoExample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FinalPayLoad {

	public static void main(String[] args) throws JsonProcessingException {

		JSON json = new JSON(new Fields(new Project("TEST"), "REST ye merry gentlemen.",
				"Creating of an issue using project keys and issue type names using the REST API",
				new IssueType("Bug")));

		ObjectMapper objectMapper = new ObjectMapper();
		String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

		System.out.println(payload);

	}

}
