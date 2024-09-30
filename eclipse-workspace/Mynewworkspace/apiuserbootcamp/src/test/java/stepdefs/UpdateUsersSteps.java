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
import tests.UpdateUser;


public class UpdateUsersSteps extends UpdateUser {
     
	//  UpdateUser up= new UpdateUser();
	
	  private List<LinkedHashMap<String, String>> userpost;
	  private  LinkedHashMap<String, String> scenarioData;
	  private UpdateUser updateuser;
	
	 
	  public UpdateUsersSteps()  {
		  
	  updateuser= new UpdateUser();
	  }
	 
	
	
	@Given("User creates put request with {string} to update User by Id")
	public void user_creates_put_request_with_to_update_user_by_id(String ScenarioType) throws IOException {
	   
		userpost = AdduserPayload.getUserData("PUT");
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
		updateuser.setuserpojo(adduserpojo);
		
		
	}

	@When("User send put  http request with endpoint for {string} to update User by Id")
	public void user_send_put_http_request_with_endpoint_for_to_update_user_by_id(String ScenarioType) throws IOException {
		
		if(ScenarioType.equalsIgnoreCase("Validdata")) {
			     
			    updateuser.updateuserwithid();
				
			}else if(ScenarioType.equalsIgnoreCase("Invalid data")) {
			   updateuser.updateuserbyInvaliddata(); 
				 
			}else if(ScenarioType.equalsIgnoreCase("InValid Id")) {
				
               updateuser.updateuserbyInvalidId();
			
			}else if(ScenarioType.equalsIgnoreCase("Invalid Method")) {
				
				updateuser.updateuserWithInvalidMethod();
				
			}else if(ScenarioType.equalsIgnoreCase("No auth")) {
				
				updateuser.updateuserwithNoauth();
				
			}else if(ScenarioType.equalsIgnoreCase("Invalid Content type")) {
				
				updateuser.updatewithInvalidContenttype();
			}
		
	   }
	
	
	@Then("User receives {int} and with response body containing user details for put request")
	public void user_receives_and_with_response_body_containing_user_details_for_put_request(Integer statuscode) {
	   updateuser.validateresponseput(statuscode);
	}

	
	
}
