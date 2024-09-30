package stepdefs;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import payloads.AdduserPayload;
import pojo.AdduserPojo;
import tests.Createuser;
import utils.Commonutils;


public class CreateuserSteps extends Commonutils{
	
	  private List<LinkedHashMap<String, String>> userpost;
	  private  LinkedHashMap<String, String> scenarioData;
	  private Createuser createuser;
	  
	
	 
	  public CreateuserSteps() {
		  
	  createuser= new Createuser();
	  }
	 
	@Given("Use creates  POST request with {string}")
	public void user_creates_post_request_with(String ScenarioType) throws IOException {
	  
	    userpost = AdduserPayload.getUserData("POST");
		scenarioData = null;
		
		
		for (LinkedHashMap<String, String> data : userpost) {
		String type=data.get("ScenarioType");
		 if(type!=null && type.equals(ScenarioType)) {
			scenarioData=data;
			break;
		 }
		}
		if (scenarioData == null) {
			throw new RuntimeException("Scenario type not found in Excel data: " + ScenarioType);
		}
        
		AdduserPojo adduserpojo =AdduserPayload.createUserPayload(scenarioData);
		createuser.setuserpojo(adduserpojo);
		
	}
		
	
	@When("User send POST http request with endpoint for {string}")
	public void user_send_post_http_request_with_endpoint_for(String ScenarioType) throws IOException {
		
		if(ScenarioType.equalsIgnoreCase("Validdata")) {
			createuser.createnewuserwithvaliddata();
					
		}else if(ScenarioType.equalsIgnoreCase("Invalid data")) {
			    createuser.createnewuserwithinvaliddata();  
			 
		}else if(ScenarioType.equalsIgnoreCase("InValid Endpoint")) {
			createuser.createnewuserwithinvalidendpoint();
			
		}else if(ScenarioType.equalsIgnoreCase("Invalid Method")) {
			createuser.createnewuserwithinvalidmethod();
			
		}else if(ScenarioType.trim().equalsIgnoreCase("No auth")) {
		    createuser.createnewuserwithNOauth();
		    
		}else if(ScenarioType.trim().equalsIgnoreCase("Invalid Content type")) {
		    createuser.createnewuserwithInvalidcontentType() ;   
			
		}
	 }
	
	@Then("User receives {int} and with response body")
	public void user_receives_and_with_response_body(Integer statusCode) throws IOException {
		
		createuser.validateresponse(statusCode);
		
	  if("Validdata".equals(scenarioData.get("ScenarioType"))) {
		createuser.validateschema(paths.getString("postschema"));
		}
	  
	}

	/*****************************Jsonfile*********************/
	
	@When("User send POST http request with endpoint to create user using jsonfile")
	public void user_send_post_http_request_with_endpoint_to_create_user_using_jsonfile() throws IOException {
		
	    createuser.createnewuserusingjson();
		
	}

		
	@Then("User receives {int} and with response body for external jsonfile")
	public void user_receives_and_with_response_body_for_external_jsonfile(Integer statuscode) {
	    
		  createuser.validateresponse(statuscode);
	}

	/*****************************Jsonfile with existing email*********************/

    
     @When("User send POST http request with endpoint to create user using jsonfile containing existing email and contact no")
     public void user_send_post_http_request_with_endpoint_to_create_user_using_jsonfile_containing_existing_email_and_contact_no() throws IOException {
 
		 createuser.createnewuserusingjsonwithexistingemail();
		 
	
      }

	
     
     
     
   }
