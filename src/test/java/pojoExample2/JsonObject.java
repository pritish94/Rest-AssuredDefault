package pojoExample2;

import java.util.ArrayList;

public class JsonObject {

	private String name;
	private int age;
	private ArrayList<Car> cars;

	public JsonObject(String name, int number, ArrayList<Car> cars) {
		this.name = name;
		this.age = number;
		this.cars = cars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

}
