
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ValidateCurrencyTest {

	@Test
	public void validateCurrencyDetails() {
		String endpoint = "https://api.coindesk.com/v1/bpi/currentprice.json";
		Response response = RestAssured.get(endpoint);
		JsonPath jsonPath = response.jsonPath();
		// Fetch number of records in "bpi"
		int numberOfRecords = jsonPath.getMap("bpi").size(); // Get the size of the "bpi" map
		// Fetch GBP currency value
		String gbpDescription = jsonPath.getString("bpi.GBP.description");

		// Print results
		System.out.println("Number of records in 'bpi': " + numberOfRecords);
		System.out.println("GBP description: " + gbpDescription);
	}

}
