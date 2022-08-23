package Automation;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;



public class APITests {

	String token = "b1d2268377b8a9715d2ad97c060aad777459be611690a8a6d577b7d4cf3f6a4a";

	// This test case is for creating a user will valid credentials and make sure
	// you need to use new email otherwise it will throw an error.
	@Test(priority = 1)
	public void createuser() {

		String endpoint = "https://gorest.co.in/public/v2/users";

		String body = """
				{
				"id": "00120",
				"name": "Fahad Mukhtar",
				"email": "fahad.mukhtar555555555555555555@gmail.com",
				"gender": "male",
				"status": "inactive"
				}
				""";
		;
		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(201);

		response.log().body();

	}

	// This test case is for creating a upost will valid data.
	@Test(priority = 2)
	public void createpost() {
		String endpoint = "https://gorest.co.in/public/v2/posts";

		String body = """
				{
				"id": "00120",
				"user_id": "4226",
				"title": "First Test Post",
				"body": "This is first post to test Rest APIs."
				}
				""";
		;

		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(201);

		response.log().body();

	}

	// This test case is for creating a comment with all valid data.
	@Test(priority = 3)
	public void creatcomment() {
		String endpoint = "https://gorest.co.in/public/v2/comments";
		String body = """
				{
				"id": "00120",
				"post_id": "00120",
				"name": "First Test Comment",
				"email": "fahad.mukhtar5555555@gmail.com",
				"body": "This is first Comment to test Rest APIs."
				}
				""";
		;

		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(201);

		response.log().body();

	}

	// This test case is for creating a todos will all valid data.
	@Test(priority = 4)
	public void createtodos() {
		String endpoint = "https://gorest.co.in/public/v2/todos";
		String body = """
				{
				"id": "00120",
				"user_id": "4226",
				"title": "First Test Todos",
				"due_on": "2022-09-09T00:00:00.000+05:30",
				"status": "Completed"
				}
				""";
		;
		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(201);

		response.log().body();

	}

	// This test case is to check if mandatory field like email is not given then it
	// should give an error.
	@Test(priority = 5)
	public void createuser1() {
		String endpoint = "https://gorest.co.in/public/v2/users";
		String body = """
				{
				"id": "00120",
				"name": "Fahad Mukhtar",
				"gender": "male",
				"status": "inactive"
				}
				""";
		;
		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(422);

		response.log().body();

	}

	// This test case is to check if mandatory field like user_id is not given then
	// it will give an error.
	@Test(priority = 6)
	public void createpost1() {
		String endpoint = "https://gorest.co.in/public/v2/posts";

		String body = """
				{
				"id": "00120",
				"title": "First Test Post",
				"body": "This is first post to test Rest APIs."
				}
				""";
		;
		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(422);

		response.log().body();

	}

	// This test case if to check if mandatory field like post_id is not given then
	// it will give an error.
	@Test(priority = 7)
	public void creatcomment1() {
		String endpoint = "https://gorest.co.in/public/v2/comments";
		String body = """
				{
				"id": "00120",
				"name": "First Test Comment",
				"email": "fahad.mukhtar5555555@gmail.com",
				"body": "This is first Comment to test Rest APIs."
				}
				""";
		;
		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(422);

		response.log().body();

	}

	// This test case is to verify if mandatory field like user_id is not given then
	// it will gave an error.
	@Test(priority = 8)
	public void createtodos1() {
		String endpoint = "https://gorest.co.in/public/v2/todos";
		String body = """
				{
				"id": "00120",
				"title": "First Test Todos",
				"due_on": "2022-09-09T00:00:00.000+05:30",
				"status": "Completed"
				}
				""";
		;
		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(422);

		response.log().body();

	}

	// This is negative test case to check if user can be created with already
	// registered email.
	@Test(priority = 9)
	public void createuser2() {
		String endpoint = "https://gorest.co.in/public/v2/users";

		String body = """
				{
				"id": "00120",
				"name": "Fahad Mukhtar",
				"email": "fahad.mukhtar5555555555@gmail.com",
				"gender": "male",
				"status": "inactive"
				}
				""";
		;
		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(422);

		response.log().body();

	}

	// This is negative test case to check that user should not be created with
	// wrong format email.
	@Test(priority = 10)
	public void createuser3() {
		String endpoint = "https://gorest.co.in/public/v2/users";
		String body = """
				{
				"id": "00120",
				"name": "Fahad Mukhtar",
				"email": "fahad.mukhtar5555555555",
				"gender": "male",
				"status": "inactive"
				}
				""";
		;
		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(422);

		response.log().body();

	}

	// This test case is for creating a comment with wrong format email.
	@Test(priority = 11)
	public void creatcomment3() {
		String endpoint = "https://gorest.co.in/public/v2/comments";
		String body = """
				{
				"id": "00120",
				"post_id": "00120",
				"name": "First Test Comment",
				"email": "fahad",
				"body": "This is first Comment to test Rest APIs."
				}
				""";
		;
		var response = given().auth().oauth2(token).body(body).when().contentType(ContentType.JSON).post(endpoint)
				.then().assertThat().statusCode(422);

		response.log().body();

	}

}
