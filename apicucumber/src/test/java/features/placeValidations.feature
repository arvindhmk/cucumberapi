	Feature: Validating the place Api

@AddPlace
Scenario Outline: Verify if place is created successfully using AddPlaceApi

Given Add place Payload with "<name>" "<Language>" "<address>"
When user calls "AddPlaceAPI" with "post" http request
Then the api call is success with status code 200
And "status" in repsonse body is "OK"
And verify place_id created maps to "<name>" using "GetPlaceAPI"

Examples:

|name|Language|address|
|AAhouse|English|World center|
#|BBhouse|Spanish|World spain center|

@DeletePlace
Scenario: Verify if Delete Place funtionality is working

Given DelePlace Payload
When user calls "DeletePlaceAPI" with "POST" http request
Then the api call is success with status code 200
And "status" in repsonse body is "OK"

