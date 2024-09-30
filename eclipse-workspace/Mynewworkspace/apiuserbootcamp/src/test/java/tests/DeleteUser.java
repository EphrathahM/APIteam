package tests;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Assert;

import io.restassured.response.Response;
import utils.Commonutils;

public class DeleteUser extends Commonutils{

	Createuser cu= new Createuser();
	
	private Response response;
	
	/********Delete  user by name*******************/
	
	
    public Response deleteuserbyName() throws IOException {
		
   	   response=getreq().delete(routes.getString("deleteuserbyname")+cu.userfirstname);
   	   System.out.println(response.getBody().asPrettyString());
	     return response;
	}
    
    
    public Response deleteuserbyInvalidName() throws IOException {
	       	
     	 response=getreq().delete(routes.getString("deleteuserbynvalidname"));
     	 System.out.println(response.getBody().asPrettyString());
  	     return response;
		}
      
     
      
      public Response deleteuserbyNameWithInvalidMethod() throws IOException {
	       	
     	 response=getreq().put(routes.getString("deleteuserbyname")+cu.userfirstname);
     	 System.out.println(response.getBody().asPrettyString());
  	     return response;
		}
       
      
      public Response deleteuserbyNamewithNoauth() throws IOException {
   		
     	 response=noauth().delete(routes.getString("deleteuserbyname")+cu.userfirstname);
     	 System.out.println(response.getBody().asPrettyString());
  	     return response;
		}
	
      
      public Response deleteuserbyNamewithInvalidContenttype() throws IOException {
    		
     	response=invalidcontentype().delete(routes.getString("deleteuserbyname")+cu.userfirstname);
     	 System.out.println(response.getBody().asPrettyString());
  	     return response;
		}   
    
   /************************Delete user by Id***********************/
    
    public Response deleteuserbyid() throws IOException {
		System.out.println(cu.userid_json);
		
   	 response=getreq().delete(routes.getString("deleteuserbyid")+cu.userid_json);
   	 System.out.println(response.getBody().asPrettyString());
	     return response;
	 }
    
    
    public Response deleteuserbyInvalidId() throws IOException {
	       	
  	  response=getreq().delete(routes.getString("deleteuserbyinvalidid"));
  	  System.out.println(response.getBody().asPrettyString());
	     return response;
	}
   
  
   
   public Response deleteuserbyIdWithInvalidMethod() throws IOException {
	       	
  	 response=getreq().put(routes.getString("deleteuserbyid")+cu.userid_json);
  	 System.out.println(response.getBody().asPrettyString());
	     return response;
	}
    
   
   public Response deleteuserbyIdwithNoauth() throws IOException {
		
  	 response=noauth().delete(routes.getString("deleteuserbyid")+cu.userid_json);
  	 System.out.println(response.getBody().asPrettyString());
	     return response;
	}

   
   public Response  deleteuserbyIdwithInvalidContenttype() throws IOException {
 		
  	response=invalidcontentype().delete(routes.getString("deleteuserbyid")+cu.userid_json);
  	 System.out.println(response.getBody().asPrettyString());
	     return response;
	} 
   
    
    /***********************validation******************************/
   
   
   public void validateresponsedelete(int expectedstatuscode) {
     	 int actualstatuscode=	response.getStatusCode();
     	 Assert.assertEquals("Status code", expectedstatuscode, actualstatuscode);
         String responsebody = response.getBody().asString();

     	 
       if(expectedstatuscode==200){
     		String successmessage =response.jsonPath().getString("status");		 
     		 Assert.assertTrue(successmessage.contains("Success"));
     		 Assert.assertTrue(responsebody.contains("message"));
     			
      }else if(expectedstatuscode==401) {
     	       String errormessage =response.jsonPath().getString("error");
     	       Assert.assertTrue(errormessage.contains("Unauthorized"));
     	
     	}else if(expectedstatuscode==404) {
     		
     		String errormessage =response.jsonPath().getString("status");
    	    Assert.assertTrue(errormessage.contains("404 NOT_FOUND"));
    	    
      }else if(expectedstatuscode==405) {
     		String errormessage =response.jsonPath().getString("error");
     	    Assert.assertTrue(errormessage.contains("Method Not Allowed"));
     	
     	}else if(expectedstatuscode==415) {
     		String errormessage =response.jsonPath().getString("error");
     	    Assert.assertTrue(errormessage.contains("Invalid content type"));
     	    
     	}else {
     		System.out.println("End of code");
     	}
       	 
      }
    
    
    
   
    
    
    
    
    
    
    
    
}
