package APITesting.com.org.api;
//import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.Test;

import APITesting.com.org.Classes.Post;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class PostRequest 
{
	//@Test
	public void test_01()
	{
		Response resp= given().
				when().
				get("http://localhost:3000/posts");

		String conttype = resp.getContentType();

		System.out.println("Response code is:" +resp.getStatusCode());
		System.out.println("Response code is:" +resp.asString());
		System.out.println("response content type is:" +conttype);

		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	//@Test
	public void test_02()
	{
		Response resp= given().
				body(" {\"id\":\"2\", "+" \"title\":\"json-Postserver\", "+" \"author\":\"typicode\" }").
				when().
				contentType(ContentType.JSON).
				post("http://localhost:3000/posts");

		System.out.println("Response is:"+resp.asString());
	}
	//@Test
	public void Test_03()
	{
		//Post Posts= new Post();
		Post Posts1=new Post();
		Posts1.setid("6");
		Posts1.SetTitle("Harry potter and Deathly hallows part 1");
		Posts1.SetAuthor("J.K.Rowling");

		Response resp=given().
				when().
				contentType(ContentType.JSON).
				body(Posts1).post("http://localhost:3000/posts");

		System.out.println(resp.asString());

		Response Getresp=given().when().get("http://localhost:3000/posts/3");
		System.out.println(Getresp.asString());
	}
	
	//@Test
	public void Test_04()
	{
		//Post Posts= new Post();
		
		Response Getresp=given().when().get("http://localhost:3000/posts/2");
		System.out.println(Getresp.asString());
		
		Post Posts1=new Post();
		Posts1.setid("2");
		Posts1.SetTitle("Harry potter and Deathly hallows part 2");
		Posts1.SetAuthor("J.K.Rowling");

		Response resp=given().
				when().
				contentType(ContentType.JSON).
				body(Posts1).put("http://localhost:3000/posts/2");

		System.out.println(resp.asString());

		/*Response Getresp=given().when().get("http://localhost:3000/posts/3");
		System.out.println(Getresp.asString());*/
	}
	//@Test
	public void Test_05()
	{
		Post Posts= new Post();
		Posts.SetTitle("Updated by Patch request");
		
		Response Getresp=given().when().get("http://localhost:3000/posts/4");
		System.out.println(Getresp.asString());
		
				Response resp=given().
				//body("{\"title\":\"Updated by Patch request\"}").
				when().
				contentType(ContentType.JSON).
				body(Posts).patch("http://localhost:3000/posts/4");

		System.out.println(resp.asString());

		/*Response Getresp=given().when().get("http://localhost:3000/posts/3");
		System.out.println(Getresp.asString());*/
		
		
	}
	public void Test_06()
	{
		given().when().get("http://localhost:3000/posts/4").then().body;
	}
	
}

