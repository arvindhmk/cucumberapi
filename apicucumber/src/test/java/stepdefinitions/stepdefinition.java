package stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIresources;
import resources.Testdatabuild;
import resources.Utils;

import static org.junit.Assert.*;

public class stepdefinition extends Utils
{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response res1;
	static String place_id;
	Testdatabuild td = new Testdatabuild();
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_Payload_with(String name, String language, String address) throws IOException 
	{
	    // Write code here that turns the phrase above into concrete actions
		res = given().spec(requestSpecification())
				.body(td.addPlacePayLoad(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIresources resourceAPI = APIresources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		res1 = res.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			res1 = res.when().get(resourceAPI.getResource());
		
	}

	@Then("the api call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(res1.getStatusCode(), 200);
	}

	@Then("{string} in repsonse body is {string}")
	public void in_repsonse_body_is(String keyvalue, String expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(getJsonPath(res1,keyvalue),expectedvalue);
	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException 
	{
	    // Write code here that turns the phrase above into concrete actions
		place_id = getJsonPath(res1,"place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request( resource, "GET");
		String actualName=getJsonPath(res1,"name");
		assertEquals(actualName,expectedName);
	}


	@Given("DelePlace Payload")
	public void deleplace_Payload() throws IOException 
	{
	    // Write code here that turns the phrase above into concrete actions

		res = given().spec(requestSpecification()).body(td.deletePlacePayload(place_id));
	}

	
}
