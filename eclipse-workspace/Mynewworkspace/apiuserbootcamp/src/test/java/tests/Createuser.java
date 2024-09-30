package tests;

import java.io.File;
import java.io.IOException;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.AdduserPojo;

import utils.Commonutils;

public class Createuser extends Commonutils {

	private Response response;
	private AdduserPojo adduserpojo= new AdduserPojo();
	static String userfirstname;
	static  String userid;
	static  String userid_json;	
	
   		
	public  void setuserpojo(AdduserPojo adduserpojo) {
		this.adduserpojo=adduserpojo;
	}	
	
	public   Response createnewuserwithvaliddata() throws IOException {
		
	  response=	getreq().body(adduserpojo).post(routes.getString("adduser"));
	  System.out.println(response.getBody().asPrettyString());
	     userid	= response.jsonPath().getString("user_id");
	     userfirstname= response.jsonPath().getString("user_first_name");
	     return response;
	}

	public   Response createnewuserusingjson() throws IOException {
		
		File jsonfile= new File(paths.getString("externaljson"));
		
		response=	getreq().body(jsonfile).post(routes.getString("adduser"));
		System.out.println(response.getBody().asPrettyString());
		     userid_json= response.jsonPath().getString("user_id");
		     System.out.println(userid_json);
		     return response;
		 }
	
      public   Response createnewuserusingjsonwithexistingemail() throws IOException {
		
		File jsonfile= new File(paths.getString("existingemail"));
		
		response=	getreq().body(jsonfile).post(routes.getString("adduser"));
		System.out.println(response.getBody().asPrettyString());
		        return response;
		 }
	
	public Response createnewuserwithinvaliddata() throws IOException {
		
		  response=	getreq().body(adduserpojo).post(routes.getString("adduser"));
		  System.out.println(response.getBody().asPrettyString());
		  return response;
	}
	
	public Response createnewuserwithinvalidendpoint() throws IOException {
		
		  response=	getreq().body(adduserpojo).post(routes.getString("invalidadduser"));
		  System.out.println(response.getBody().asPrettyString());
		  return response;
	}
		
	public Response createnewuserwithinvalidmethod() throws IOException {
		
		  response=	getreq().body(adduserpojo).get(routes.getString("adduser"));
		  System.out.println(response.getBody().asPrettyString());
		  return response;
	}
	
	
	public Response createnewuserwithNOauth() throws IOException {
		
		  response=	noauth().body(adduserpojo).post(routes.getString("adduser"));
		  System.out.println(response.getBody().asPrettyString());
		  return response;
	}
	
	public Response createnewuserwithInvalidcontentType() throws IOException {
		
		  response=	invalidcontentype().body(paths.getString("externaljson")).post(routes.getString("adduser"));
		  System.out.println(response.getBody().asPrettyString());
		  return response;
	}
	
	
	public void validateresponse(int expectedstatuscode) {
	int actualstatuscode=	response.getStatusCode();
	 Assert.assertEquals("Status code", expectedstatuscode, actualstatuscode);
	 String responsebody = response.getBody().asString();
	 
	 
	 if(expectedstatuscode==201){
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
		String errormessage =response.jsonPath().getString("error");
	    Assert.assertTrue(errormessage.contains("Not Found"));
	
	}else if(expectedstatuscode==405) {
		String errormessage =response.jsonPath().getString("error");
	    Assert.assertTrue(errormessage.contains("Method Not Allowed"));

	}else if(expectedstatuscode==409) {
		String errormessage =response.jsonPath().getString("status");
	    Assert.assertTrue(errormessage.contains("409 CONFLICT"));  
	    
    }else if(expectedstatuscode==415) {
			String errormessage =response.jsonPath().getString("error");
		    Assert.assertTrue(errormessage.contains("Unsupported Media Type"));
		        
	    
  }else {
		System.out.println("End of code");
	}
   }
	
	
	/************************schema validation********************************************/
	
      public  void validateschema(String schemafile) throws IOException {
    	 
       File file= new File(schemafile);	 
    	 
       response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));	 
	   
     }
     
  }	
  
