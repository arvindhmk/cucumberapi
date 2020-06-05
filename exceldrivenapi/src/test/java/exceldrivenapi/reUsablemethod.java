package exceldrivenapi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class reUsablemethod 
{

	public static JsonPath rawtoJson(String res)
	{
		JsonPath js = new JsonPath(res);
		return js;
	}
	
	
	public static void main()
	{
		
	}
}
