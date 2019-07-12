package stepDefinition;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class stepWeatherAPI2 {

	
    Response response;
    long startTime;
    long endTime;
    
    @Given("^Call Weather API \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" & \"([^\"]*)\" and check for the  \"([^\"]*)\"$")
    public void call_Weather_API_and_check_for_the(String endPoint, String latitude, String longitude, String key, String stateCode) throws Throwable {
    	
    	startTime = System.currentTimeMillis( );

    	for(int i=0;i<10;i++)
		{
    		response = RestAssured.given().config(RestAssured.config.sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                 .pathParam("lat", latitude)
                 .pathParam("lon", longitude)
                 .pathParam("key", key)
                 .when().log().all()
                 .get(endPoint + "?lat={lat}&lon={lon}&key={key}")
                 .then()
                 .extract().response();
    	 
    	 String responseStateCode = response.jsonPath().get("data[0].state_code");
         junit.framework.Assert.assertTrue(stateCode.equalsIgnoreCase(responseStateCode));
         
		}
    	endTime = System.currentTimeMillis( );
        long totalTime = endTime - startTime;
        System.out.println("Performance of the API after calling 10 times : " + totalTime);
		
    }


}
