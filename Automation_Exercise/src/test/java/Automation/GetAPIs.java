package Automation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetAPIs {
	
	
	
	String token = "b1d2268377b8a9715d2ad97c060aad777459be611690a8a6d577b7d4cf3f6a4a";
 
	// This test case is for verifying correct user data.
	@Test(priority = 1)
	public void getuser() {

		String endpoint = "https://gorest.co.in/public/v2/users/4226";
		
		given().auth().oauth2(token).when().get(endpoint).then().assertThat().statusCode(200)
				.body("name", equalTo("Fahad Mukhtar")).body("email", equalTo("fahad.mukhtar5555555555@gmail.com"))
				.body("gender", equalTo("male")).body("status", equalTo("inactive"));

	}

	// This test case is for verifying if any user data does not match.
	@Test(priority = 2)
	public void getuser1() {

		String endpoint = "https://gorest.co.in/public/v2/users/4226";
		
		given().auth().oauth2(token).when().get(endpoint).then().assertThat().statusCode(200)
				.body("name", equalTo("Fahad Mukhr")).body("email", equalTo("fahad.mukhtar5555555555@gmail.com"))
				.body("gender", equalTo("male")).body("status", equalTo("inactive"));

	}

	// This test case is for verifying correct post data.
	@Test(priority = 3)
	public void getpost() {

		String endpoint = "https://gorest.co.in/public/v2/posts/1656";
		
		given().auth().oauth2(token).when().get(endpoint).then().assertThat().statusCode(200)
				.body("title", equalTo("First Test Post"))
				.body("body", equalTo("This is first post to test Rest APIs."));

	}

	// This test case is for verifying if any post data does not match.
	@Test(priority = 4)
	public void getpost1() {

		String endpoint = "https://gorest.co.in/public/v2/posts/1656";
		
		given().auth().oauth2(token).when().get(endpoint).then().assertThat().statusCode(200)
				.body("title", equalTo("First Test Poster"))
				.body("body", equalTo("This is first post to test Rest APIs."));

	}

	// This test case is for verifying correct comment data.
	@Test(priority = 5)
	public void getcomment() {

		String endpoint = "https://gorest.co.in/public/v2/comments/1433";
		
		given().auth().oauth2(token).when().get(endpoint).then().assertThat().statusCode(200)
				.body("name", equalTo("First Test Comment")).body("email", equalTo("fahad.mukhtar5555555@gmail.com"))
				.body("body", equalTo("This is first Comment to test Rest APIs."));

	}

	// This test case is for verifying if any comment data does not match.
	@Test(priority = 6)
	public void getcomment1() {

		String endpoint = "https://gorest.co.in/public/v2/comments/1433";
		
		given().auth().oauth2(token).when().get(endpoint).then().assertThat().statusCode(200)
				.body("name", equalTo("First Test Comnt")).body("email", equalTo("fahad.mukhtar5555555555@gmail.com"))
				.body("body", equalTo("This is first Comment to test Rest APIs."));

	}

	// This test case is for verifying correct todos data.
	@Test(priority = 7)
	public void gettodos() {

		String endpoint = "https://gorest.co.in/public/v2/todos/1484";
		
		given().auth().oauth2(token).when().get(endpoint).then().assertThat().statusCode(200)
				.body("title", equalTo("First Test Todos")).body("due_on", equalTo("2022-09-09T00:00:00.000+05:30"))
				.body("status", equalTo("completed"));

	}

	// This test case is for verifying if any todos data does not match.
	@Test(priority = 8)
	public void gettodos1() {

		String endpoint = "https://gorest.co.in/public/v2/todos/1484";
		
		given().auth().oauth2(token).when().get(endpoint).then().assertThat().statusCode(200)
				.body("title", equalTo("First Test Todos")).body("due_on", equalTo("2022-09-09T00:00:00.000+05:30"))
				.body("status", equalTo("In Progress"));

	}

}
