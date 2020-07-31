package pojoExample2;

import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FinalPayload {

	public static void main(String[] args) throws JsonProcessingException {

		Car car1 = new Car("Ford", new ArrayList<String>(Arrays.asList("Fiesta", "Focus", "Mustang")));
		Car car2 = new Car("BMW", new ArrayList<String>(Arrays.asList("320", "X3", "X5")));
		Car car3 = new Car("Fiat", new ArrayList<String>(Arrays.asList("500", "Panda")));

		JsonObject jsonObject = new JsonObject("John", 30, new ArrayList<Car>(Arrays.asList(car1, car2, car3)));

		ObjectMapper objectMapper = new ObjectMapper();
		String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);

		System.out.println(payload);
	}

}
