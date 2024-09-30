package stepdefs;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.DeleteUser;

public class DeleteUsersteps {

	private DeleteUser deleteuser= new DeleteUser();
	
	
	/********************delete user by name********************/


	@When("User send  Delete  http request with endpoint for {string} to Delete User by Name")
	public void user_send_delete_http_request_with_endpoint_for_to_delete_user_by_name(String ScenarioType) throws IOException {
		
		  if(ScenarioType.equalsIgnoreCase("ValidEndPoint")) {
			
			   deleteuser.deleteuserbyName();
				
			}else if(ScenarioType.equalsIgnoreCase("InValid userName")) {
			
				deleteuser.deleteuserbyInvalidName();
				
			}else if(ScenarioType.equalsIgnoreCase("Invalid Method")) {
			
			    deleteuser.deleteuserbyNameWithInvalidMethod();	
			    
			}else if(ScenarioType.equalsIgnoreCase("No auth")) {
				
				deleteuser.deleteuserbyNamewithNoauth();
			  
			}else if(ScenarioType.equalsIgnoreCase("Invalid Content type")) {
				
				deleteuser.deleteuserbyNamewithInvalidContenttype();
				
			}
	  }
	
	/*********************delete user by id**************************/
	


      @When("User send  Delete  http request with endpoint for {string} to Delete User by Id")
      public void user_send_delete_http_request_with_endpoint_for_to_delete_user_by_id(String ScenarioType) throws IOException {
	
	 if(ScenarioType.equalsIgnoreCase("ValidEndPoint")) {
		
		    deleteuser.deleteuserbyid();
			
		}else if(ScenarioType.equalsIgnoreCase("InValid userId")) {
			
			deleteuser.deleteuserbyInvalidId();
		
		}else if(ScenarioType.equalsIgnoreCase("Invalid Method")) {
			
		   deleteuser.deleteuserbyIdWithInvalidMethod();
			
		}else if(ScenarioType.equalsIgnoreCase("No auth")) {
			
			deleteuser.deleteuserbyIdwithNoauth();
			
	    }else if(ScenarioType.equalsIgnoreCase("Invalid Content type")) {
			
			deleteuser.deleteuserbyIdwithInvalidContenttype();
			
		}
   
    }

@Then("User receives {int} and with response body containing delete details")
public void user_receives_and_with_response_body_containing_delete_details(Integer statuscode) {
	
	  deleteuser.validateresponsedelete(statuscode);
   
    }
	
	
	
	
	
	
	
	
}
