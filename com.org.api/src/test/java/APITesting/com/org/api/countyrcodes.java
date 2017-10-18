package APITesting.com.org.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class countyrcodes {
	//Get request
	//@Test
	public void Test_01()
	{
		Response resp= given().
				param("lat", "50.01").
				param("lng", "10.2").
				when().
				get("http://api.geonames.org/astergdemJSON?formatted=true&username=demo1&style=full");

		System.out.println(resp.getStatusCode()); 
		Assert.assertEquals(resp.getStatusCode(), 200);		
	}

	//@Test
	public void Test_02()
	{
		//http://api.geonames.org/citiesJSON?
		given().
		param("formatted", "true").
		param("north", "44.1").
		param("east", "-22.4").
		param("south", "-9.9").
		param("west", "55.2").
		param("lang", "de").
		param("username", "de").
		param("style", "full").
		when().
		get("http://api.geonames.org/citiesJSON").
		then().
		assertThat().statusCode(200);
	}

	@Test
	public void Test_03()
	{
		Response resp= given().
				param("formatted", "true").
				param("north", "44.1").
				param("east", "-22.4").
				param("south", "-9.9").
				param("west", "55.2").
				param("lang", "de").
				param("username", "demo").
				param("style", "full").
				when().
				get("http://api.geonames.org/citiesJSON");

		System.out.println(resp.getContentType());
		System.out.println(resp.cookie("Mexico City"));
	}
}
