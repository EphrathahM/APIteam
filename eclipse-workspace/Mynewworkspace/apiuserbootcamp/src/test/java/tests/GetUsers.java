package tests;



import java.io.IOException;

import org.json.JSONObject;
import org.junit.Assert;

import io.restassured.response.Response;
import utils.Commonutils;

public class GetUsers extends Commonutils {

	Createuser cu= new Createuser();
	
	private Response response;

	    
	   /**************************Get all users****************************************/
	
         public Response getalluserwithvalidendpoint() throws IOException {
		
        	 response=getreq().get(routes.getString("getallusers"));
        	 System.out.println(response.getBody().asPrettyString());
     	     return response;
		}
         
         
         public Response getalluserbyInvalidendpoint() throws IOException {
   	       	
       	  response=getreq().get(routes.getString("invalidgetallusers"));
       	System.out.println(response.getBody().asPrettyString());
    	     return response;
		}
        
       
        
        public Response getalluserWithInvalidMethod() throws IOException {
  	       	
       	 response=getreq().put(routes.getString("getallusers"));
        	System.out.println(response.getBody().asPrettyString());
    	     return response;
		}
         
        
        public Response getalluserwithNoauth() throws IOException {
     		
       	 response=noauth().get(routes.getString("getallusers"));
       	 System.out.println(response.getBody().asPrettyString());
    	     return response;
		}
	
        
        public Response getalluserwithInvalidContenttype() throws IOException {
      		
       	response=invalidcontentype().get(routes.getString("getallusers"));
       	System.out.println(response.getBody().asPrettyString());
    	     return response;
		} 
         
        /******************************Get User By Id ***************************************/
	
         public Response getuserbyIdwithvalidendpoint() throws IOException {
     		
        	 System.out.println(cu.userid);
        	  response=getreq().get(routes.getString("getusersbyid")+cu.userid);
        	  System.out.println(response.getBody().asPrettyString());
     	     return response;
		}
	
         public Response getuserbyInvalidId() throws IOException {
      	       	
        	  response=getreq().get(routes.getString("getuserbyinvalidId"));
        	  System.out.println(response.getBody().asPrettyString());
     	     return response;
		}
         
        
         
         public Response getuserbyIdWithInvalidMethod() throws IOException {
   	       	
        	 response=getreq().put(routes.getString("getusersbyid")+cu.userid);
        	 System.out.println(response.getBody().asPrettyString());
     	     return response;
		}
          
         
         public Response getuserbyIdwithNoauth() throws IOException {
      		
        	 response=noauth().get(routes.getString("getusersbyid")+cu.userid);
        	 System.out.println(response.getBody().asPrettyString());
     	     return response;
		}
	
         
         public Response getuserbyIdwithInvalidContenttype() throws IOException {
       		
        	response=invalidcontentype().get(routes.getString("getusersbyid")+cu.userid);
        	System.out.println(response.getBody().asPrettyString());
     	     return response;
		} 
         
         
         
         
  /*************************Get User By Name ******************************************/       
        
         public Response getuserbyNamewithvalidendpoint() throws IOException {
      		
        	 System.out.println(cu.userfirstname);
        	 response=getreq().get(routes.getString("getuserbyname")+cu.userfirstname);
        	 System.out.println(response.getBody().asPrettyString());
     	     return response;
		}
         
         
         public Response getuserbyInvalidName() throws IOException {
   	       	
       	  response=getreq().get(routes.getString("getuserbyinvalidname"));
       	  System.out.println(response.getBody().asPrettyString());
    	     return response;
		}
        
       
        
        public Response getuserbyNameWithInvalidMethod() throws IOException {
  	       	
       	 response=getreq().put(routes.getString("getuserbyname")+cu.userfirstname);
        	System.out.println(response.getBody().asPrettyString());
    	     return response;
		}
         
        
        public Response getuserbyNamewithNoauth() throws IOException {
     		
       	 response=noauth().get(routes.getString("getuserbyname")+cu.userfirstname);
       	 System.out.println(response.getBody().asPrettyString());
    	     return response;
		}
	
        
        public Response getuserbyNamewithInvalidContenttype() throws IOException {
      		
       	response=invalidcontentype().get(routes.getString("getuserbyname")+cu.userfirstname);
       	System.out.println(response.getBody().asPrettyString());
    	     return response;
		}   
         
         
         /********validation********************/
         
        public void validateresponse(int expectedstatuscode,String methodtype) {
       	 int actualstatuscode=	response.getStatusCode();
       	 Assert.assertEquals("Status code", expectedstatuscode, actualstatuscode);
         String responsebody = response.getBody().asString();

       	 
         if(expectedstatuscode==200){
       		if("getall".equals(methodtype)){
       		  		 
       		 Assert.assertTrue(responsebody.contains("user_first_name"));
       		 Assert.assertTrue(responsebody.contains("user_last_name"));
       		 Assert.assertTrue(responsebody.contains("user_contact_number"));
       		 Assert.assertTrue(responsebody.contains("user_email_id"));
       		 
       		}else if("getuserbyid".equals(methodtype)) {
       			
          	JSONObject jsonResponse = new JSONObject(responsebody);
       	    JSONObject userAddress = jsonResponse.getJSONObject("userAddress");	 
       	    
       	 	 Assert.assertTrue(userAddress.has("state"));
       		 Assert.assertTrue(userAddress.has("street"));
       		 Assert.assertTrue(responsebody.contains("user_contact_number"));
       		 Assert.assertTrue(responsebody.contains("user_email_id"));	
       			
       		}else if("getuserbyname".equals(methodtype)){
       		
             Assert.assertTrue(responsebody.contains("user_first_name"));
      		 Assert.assertTrue(responsebody.contains("user_last_name"));
      		 Assert.assertTrue(responsebody.contains("user_contact_number"));
      		 Assert.assertTrue(responsebody.contains("user_email_id"));
       		}
       	
       	}else if(expectedstatuscode==401) {
       	       String errormessage =response.jsonPath().getString("error");
       	       Assert.assertTrue(errormessage.contains("Unauthorized"));
       	
       	}else if(expectedstatuscode==404) {
       		
       		String errormessage1 =response.jsonPath().getString("error");
       		String errormessage2 =response.jsonPath().getString("status");
       		
       		if(errormessage1!=null) {
       			  Assert.assertTrue(errormessage1.contains("Not Found"));
       		  }else if(errormessage2 !=null){
       			  Assert.assertTrue(errormessage2.contains("404 NOT_FOUND"));
       		  }else {
       			  System.out.println("Response body is null");
       		  }
       		  
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

