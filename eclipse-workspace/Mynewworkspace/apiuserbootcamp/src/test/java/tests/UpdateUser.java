package tests;

import java.io.IOException;

import org.junit.Assert;

import io.restassured.response.Response;
import pojo.AdduserPojo;
import utils.Commonutils;

public class UpdateUser extends Commonutils {

	private Response response;
	private AdduserPojo adduserpojo= new AdduserPojo();
	
	public  void setuserpojo(AdduserPojo adduserpojo) {
		this.adduserpojo=adduserpojo;
	}	
	
	  Createuser cu= new Createuser();
	  
	  
	 public Response updateuserwithid() throws IOException {
			
		 System.out.println(cu.userid);
    	 response=getreq().body(adduserpojo).put(routes.getString("updateuserbyid")+cu.userid);
    	 System.out.println(response.getBody().asPrettyString());
 	     return response;
	   }
	
	
	  public Response updateuserbyInvalidId() throws IOException {
 	       	
       	  response=getreq().body(adduserpojo).put(routes.getString("updateuserbyInvalidId"));
          System.out.println(response.getBody().asPrettyString());
    	  return response;
		}
        
	  
	   public Response updateuserbyInvaliddata() throws IOException {
	       	
       	  response=getreq().body(adduserpojo).put(routes.getString("updateuserbyid")+cu.userid);
          System.out.println(response.getBody().asPrettyString()); 
    	  return response;
		}
	          
        public Response updateuserWithInvalidMethod() throws IOException {
  	       	
       	 response=getreq().body(adduserpojo).get(routes.getString("updateuserbyid")+cu.userid);
       	 System.out.println(response.getBody().asPrettyString());
    	 return response;
		}
         
        
        public Response updateuserwithNoauth() throws IOException {
     		
       	 response=noauth().body(adduserpojo).put(routes.getString("updateuserbyid")+cu.userid);
        	System.out.println(response.getBody().asPrettyString());
    	     return response;
		}
	
        
        public Response updatewithInvalidContenttype() throws IOException {
        	
      		
       	response=invalidcontentype().body(paths.getString("externaljson")).put(routes.getString("updateuserbyid")+cu.userid);
       	System.out.println(response.getBody().asPrettyString());
    	     return response;
		} 
         
	
        public void validateresponseput(int expectedstatuscode) {
        	int actualstatuscode=	response.getStatusCode();
        	 Assert.assertEquals("Status code", expectedstatuscode, actualstatuscode);
        	 String responsebody = response.getBody().asString();
        	 
        	 
        	 if(expectedstatuscode==200){
        		 Assert.assertTrue(responsebody.contains("user_first_name"));
        		 Assert.assertTrue(responsebody.contains("user_last_name"));
        		 Assert.assertTrue(responsebody.contains("user_contact_number"));
        		 Assert.assertTrue(responsebody.contains("user_email_id"));
        		 
        	}else if(expectedstatuscode==401) {
        	       String errormessage =response.jsonPath().getString("error");
        	       Assert.assertTrue(errormessage.contains("Unauthorized"));
        	
        	}else if(expectedstatuscode==400) {
        		String errormessage =response.jsonPath().getString("status");
        	    Assert.assertTrue(errormessage.contains("400 BAD_REQUEST"));
        	
        	}else if(expectedstatuscode==404) {
        		String errormessage =response.jsonPath().getString("status");
        	    Assert.assertTrue(errormessage.contains("404 NOT_FOUND"));
        	
        	}else if(expectedstatuscode==405) {
        		String errormessage =response.jsonPath().getString("error");
        	    Assert.assertTrue(errormessage.contains("Method Not Allowed"));
        	
        	}else if(expectedstatuscode==415) {
        		String errormessage =response.jsonPath().getString("error");
        	    Assert.assertTrue(errormessage.contains("Unsupported Media Type"));
            
           	}else {
        		System.out.println("End of code");
        	}
	
        }
}
