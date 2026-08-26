package reading_json_12_2;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class Program {

	public static void main(String[] args) throws Exception {

		Gson gson = new Gson();

		String fileName = "src/customers.json";

		String content = Files.readString(Paths.get(fileName));

		Customer[] customers = gson.fromJson(content, Customer[].class);

		System.out.println("Customers read: " + customers.length);
		System.out.println(customers[0].CustomerID);
		System.out.println(customers[0].CompanyName);
	}

}
