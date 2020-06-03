package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.googlejson;

public class Testdatabuild 
{
	public googlejson addPlacePayLoad(String name, String language, String address)
	{
		pojo.googlejson gj = new pojo.googlejson();
		gj.setAccuracy(20);
		gj.setAddress(address);
		gj.setLanguage(language);
		gj.setName(name);
		gj.setPhone_number("99944332223");
		gj.setWebsite("https://www.rahulshetty.com");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
		pojo.Location loc = new pojo.Location();
		loc.setLat(32.4324);
		loc.setLng(32.423);
		
		gj.setTypes(myList);
		gj.setLocation(loc);
		
		return gj;
		
	}
	
	public String deletePlacePayload(String placeId)
	{
		
		return "{\r\n\"place_id\": \""+placeId+"\"\r\n}";
	}

}
