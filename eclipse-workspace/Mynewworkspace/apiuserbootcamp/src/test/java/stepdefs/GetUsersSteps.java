package stepdefs;


import java.io.IOException;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.GetUsers;



public class GetUsersSteps {
	
	private GetUsers getusers= new GetUsers();
	
	
	 /**********************Get all users******************************/
	
	@When("User send GET http request with endpoint for {string}")
	public void user_send_get_http_request_with_endpoint_for(String ScenarioType) throws IOException {
	
		if(ScenarioType.equalsIgnoreCase("ValidEndPoint")) {
			
		   getusers.getalluserwithvalidendpoint();
			
		}else if(ScenarioType.equalsIgnoreCase("InValid Endpoint")) {
			
		   getusers.getalluserbyInvalidendpoint();
			
		}else if(ScenarioType.equalsIgnoreCase("Invalid Method")) {
			
		  getusers.getalluserWithInvalidMethod();
			
		}else if(ScenarioType.equalsIgnoreCase("No auth")) {
			
		  getusers.getalluserwithNoauth();	
		  
		}else if(ScenarioType.equalsIgnoreCase("Invalid Content type")) {
			
		  getusers.getalluserwithInvalidContenttype();	
					
	   }
		
	 }	
	
	 @Then("User receives {int} and with response body containing all user details")
	 public void user_receives_and_with_response_body_containing_all_user_details(Integer statusCode ) {
		   
		 getusers.validateresponse(statusCode, "getall");
			
		  }	
		
	  /************************Get User By Id********************************************/

    @When("User send GET http request with endpoint for {string} to get User by Id")
    public void user_send_get_http_request_with_endpoint_for_to_get_user_by_id(String ScenarioType) throws IOException  {
	
	    if(ScenarioType.equalsIgnoreCase("ValidEndPoint")) {
		
		  getusers.getuserbyIdwithvalidendpoint();
			
		}else if(ScenarioType.equalsIgnoreCase("InValid userId")) {
			
		   getusers.getuserbyInvalidId();
			
		}else if(ScenarioType.equalsIgnoreCase("Invalid Method")) {
		
			getusers.getuserbyIdWithInvalidMethod();
						
		}else if(ScenarioType.equalsIgnoreCase("No auth")) {
			
			getusers.getuserbyIdwithNoauth();	
		  
		}else if(ScenarioType.equalsIgnoreCase("Invalid Content type")) {
			
			getusers.getuserbyIdwithInvalidContenttype();
			
		}  	
	    
     }  
	    
	    @Then("User receives {int} and with response body containing  user with Id details")
	    public void user_receives_and_with_response_body_containing_user_with_id_details(Integer statusCode) {
	       
	    	 getusers.validateresponse(statusCode, "getuserbyid");
	    	
	    }  
	    
		 
    /************************Get User By Name********************************************/

    @When("User send GET http request with endpoint for {string} to get User by Name")
    public void user_send_get_http_request_with_endpoint_for_to_get_user_by_name(String ScenarioType) throws IOException {

	    if(ScenarioType.equalsIgnoreCase("ValidEndPoint")) {
		
		 getusers.getuserbyNamewithvalidendpoint();
			
		}else if(ScenarioType.equalsIgnoreCase("InValid userName")) {
			
		 getusers.getuserbyInvalidName();
			
		}else if(ScenarioType.equalsIgnoreCase("Invalid Method")) {
			
		getusers.getuserbyNameWithInvalidMethod();
			
		}else if(ScenarioType.equalsIgnoreCase("No auth")) {
			
		getusers.getuserbyNamewithNoauth();	
		  
		}else if(ScenarioType.equalsIgnoreCase("Invalid Content type")) {
			
		getusers.getuserbyNamewithInvalidContenttype();	
			  
		}
	
    }
    
    
    @Then("User receives {int} and with response body containing  user with Name details")
    public void user_receives_and_with_response_body_containing_user_with_name_details(Integer statusCode) {
        
    	getusers.validateresponse(statusCode, "getuserbyname");
    	
    }
	   
    }

	
	
	
	
	
 
