package stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.batchpostpayload;
import payload.batchputpayload;
import utils.Bearertoken;
import utils.Variables;


public class programbatchstepdef {
	
	static  RequestSpecification  reqspec;
    static Response response;
    static  RequestSpecification  getreqspec;
    static Response getresponse;
    static Response getresponsebyid;
    static Response  getbatchnameresponse;
	
	
	//static  RequestSpecification  reqspec;
	//  static  Response resp;
	//  static  String bearertoken;
	 // static  RequestSpecification reqspecpost;
	//  static  RequestSpecification reqspecput;
	//  static  RequestSpecification  reqspecmispost;
	//  static  Response responsepost;
	//  static  Response respmispost;////
	//  static  Response responseput;
	  //static  RequestSpecification  reqspecuserrolestaus;
	 // static  Response responseuserrolestatus;
	//String baseUrl = URLs.BaseURL;
	//String postcreateurl=URLs.postcreateendpoint;
	//String geturl=URLs.getallbatchendpoint;
	//RequestSpecification request = RestAssured.given().urlEncodingEnabled(true).log().all();

	
	//static RequestSpecification request = RestAssured.given().urlEncodingEnabled(true).log().all();
	//static Response response;
	//static String programid;


	
	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() throws InvalidFormatException, IOException {
	
		  reqspec=RestAssured.given().baseUri(URLs.BaseURL).header("Content-Type","application/json")
					  .header("Authorization", "Bearer " + Bearertoken.bearertoken()).body(batchpostpayload.adminbatch());
		   	}
		
	@When("Admin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() throws InvalidFormatException, IOException {
	    
			response=reqspec.when().post(URLs.postcreateendpoint);
		    						
			Variables.batchId =response.jsonPath().get("batchId").toString();
			
			}
		
	@Then("Admin receives {int} Created Status with response body.")
	public void admin_receives_created_status_with_response_body(Integer expectedcode) {
	    // Write code here that turns the phrase above into concrete actions
	   
		expectedcode=response.getStatusCode();
		Assert.assertEquals(expectedcode,201);
	
	 }
	
	@When("Admin sends HTTPS Request and  request Body with endpoint with missing field")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_missing_field() throws InvalidFormatException, IOException {
	    
		//responsepost=reqspecpost.when().post(URLs.postcreateendpoint);
		
		
		//String batchId=	responsepost.jsonPath().getString("batchid").toString();

		//response = request.body(batchpostpayload.adminbatch()).post(URLs.postcreateendpoint);
		 
	
	 /*programbatch1 newProgram = new programbatch1("API"+ common.getRandomInt(),1,"Active",16345);
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBodyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newProgram);
		System.out.println(reqBodyJson);*/
		//responsepost=reqspecpost.when().post(batchmissingpayload.adminmissbatch());
		//respmispost=reqspecmispost.when().post(URLs.postcreateendpoint);
	
	
	
	}
	@Then("Admin receives {int} ok")
	public void admin_receives_ok(Integer expec) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.statusCode(),500);
		response.prettyPrint();
	
	
	}
	
	@Given("Admin creates GET Request for the LMS API")
	public void admin_creates_get_request_for_the_lms_api() throws InvalidFormatException, IOException {
		 getreqspec=RestAssured.given().baseUri(URLs.BaseURL).header("Content-Type","application/json")
				  .header("Authorization", "Bearer " + Bearertoken.bearertoken());
				  
	  
	}
	
	
	@When("Admin sends HTTPS Request with endpoint batches")
	public void admin_sends_https_request_with_endpoint_batches() {
	
	getresponse	= getreqspec.when().get(URLs.getallbatchendpoint);
	
	
	
	}
	
	@Then("Admin receives {int} OK Status with response body.")
	public void admin_receives_ok_status_with_response_body(Integer exvalue) {
		Assert.assertEquals(getresponse.getStatusCode(),200);
		response.getBody().prettyPrint();
	}
	
	/*@Then("Admin receives batchStatus as Inactive with response body")
	public void Admin_receives_batchStatus_as_Inactive_with_response_body {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.body().asString().contains(null),200);
		 this.response.prettyPrint();
			
	}*/

	@When("Admin sends HTTPS Request with endpoint batchId")
	public void admin_sends_https_request_with_endpoint_batch_id() {
		getresponsebyid=getreqspec.when().get(URLs.getbatchidendpoint);
	System.out.println(getresponsebyid.asString());
	
	}

	@When("Admin sends HTTPS Request with endpoint batchName")
	public void admin_sends_https_request_with_endpoint_batch_name() {
		getbatchnameresponse	= getreqspec.when().get(URLs.getbatchnameendpoint);
	}

	/*@When("Admin sends HTTPS Request with endpoint programId")
	public void admin_sends_https_request_with_endpoint_program_id() {
	    // Write code here that turns the phrase above into concrete actions
		//response=request.get(URLs.getbatchprogramidendpoint);
	}

	@Given("Admin creates PUT Request for the LMS API")
	public void admin_creates_put_request_for_the_lms_api() throws InvalidFormatException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		//request.baseUri(URLs.BaseURL);
		//request.header("Authorization", "Bearer " + Bearertoken.bearertoken());
		//request.header("Content-Type","application/json");
	}
	@When("Admin sends HTTPS Request with endpoint batchId and request")
	public void admin_sends_https_request_with_endpoint_batch_id_and_request() throws InvalidFormatException, IOException {
	    
		//responseput=reqspecput.when().put( batchputpayload.adminputbatch());
		
		//response = request.body(batchputpayload.adminputbatch()).put(URLs.updatebatchidendpoint); 
		
		//responseput=reqspecput.when().put(URLs.updatebatchidendpoint);
	
	}

	@Given("Admin creates DELETE Request for the LMS API")
	public void admin_creates_delete_request_for_the_lms_api() throws InvalidFormatException, IOException {
	//	request.baseUri(URLs.BaseURL);
	//	request.header("Authorization", "Bearer " + Bearertoken.bearertoken());
	//	request.header("Content-Type","application/json");
	}
	
	
	@When("Admin sends HTTPS Request with endpoint id")
	public void admin_sends_https_request_with_endpoint_id() throws JsonProcessingException {
	  
	
	//	response=request.delete(URLs.deletebatchidendpoint);
		
	
	}	*/
}
