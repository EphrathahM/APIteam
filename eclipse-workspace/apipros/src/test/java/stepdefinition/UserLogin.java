package stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Userloginpayload;
import utils.ExcelReader_Rest;
import utils.Variables;

public class UserLogin {

	//private String BaseURL;
	//private String loginEndpoint;
	//private String requestBody;
	//RequestSpecification request = RestAssured.given();
	
  static String Jsonbody;
  static  RequestSpecification reqspecification;
  static Response  response;
 public  static String token; 
	
   @Given("Admin creates request with valid credentials")
    public void admin_creates_request_with_valid_credentials() throws InvalidFormatException, IOException {
		
		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.Excelpath, "Sheet 4 - Table 1-1");
		for (Map<String, String> row : map) {
			String mypwd = row.get("password");
			String userLoginEmailId = row.get("userLoginEmailId");
	
			Userloginpayload  ulp= new Userloginpayload();
			ulp.setUserLoginEmailId(userLoginEmailId);
			ulp.setPassword(mypwd);
			
			
			ObjectMapper om = new ObjectMapper();
	        Jsonbody=om.writerWithDefaultPrettyPrinter().writeValueAsString(ulp);
	          //  System.out.println(Jsonbody);
		           }
		 reqspecification=RestAssured.given().baseUri(URLs.BaseURL)
						                         .header("Content-Type","application/json")
						                         .body(Jsonbody);
				
			}	
		
   @When("Admin calls Post Https method  with valid endpoint")
   public void admin_calls_post_https_method_with_valid_endpoint() {
		
		 response=reqspecification.when().post(URLs.loginEndpoint);
		System.out.println(response.asString());
	   }

   @Then("Admin receives {int} created with auto generated token")
   public void admin_receives_created_with_auto_generated_token(Integer expcode) {
	   
	    token =response.jsonPath().get("token").toString();
		 System.out.println(token);
		
		 
			System.out.println(response.getStatusCode());
		    System.out.println(response.getStatusLine());
			expcode=response.getStatusCode();
		    Assert.assertEquals(200, expcode);
			 
		 
         }
	
     }
	
	
	
	
	
	
	
	
	