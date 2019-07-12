package stepDefinition;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class stepWeatherAPI {

	
    Response response;
    
    
    @Given("^User invokes the Weather API \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" & \"([^\"]*)\"$")
	public void user_invokes_the_Weather_API(String endPoint, String latitude, String longitude,String key) {
    	
     response = RestAssured.given().config(RestAssured.config.sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .pathParam("lat", latitude)
                .pathParam("lon", longitude)
                .pathParam("key", key)
                .when().log().all()
                .get(endPoint + "?lat={lat}&lon={lon}&key={key}")
                .then()
                .extract().response();
	}

    @Then("^Verify the state code in the Response \"([^\"]*)\"$")
	public void verify_the_state_code_in_the_Response(String stateCode) {
	
		String responseStateCode = response.jsonPath().get("data[0].state_code");
        junit.framework.Assert.assertTrue(stateCode.equalsIgnoreCase(responseStateCode));
	}	    


}
