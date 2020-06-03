package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks 
{

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		stepdefinition step = new stepdefinition();
		if(stepdefinition.place_id==null)
		{
		step.add_place_Payload_with("shetty", "Malay", "Jalan tu seremban");
		step.user_calls_with_http_request("AddPlaceAPI", "POST");
		step.verify_place_id_created_maps_to_using("shetty", "GetPlaceAPI");
		}
	}
}
