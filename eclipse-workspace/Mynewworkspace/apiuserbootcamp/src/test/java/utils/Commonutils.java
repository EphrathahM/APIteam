package utils;

import static io.restassured.RestAssured.baseURI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.AdduserPayload;
import pojo.AdduserPojo;

public class Commonutils extends FileUtils {

	
	public static ResourceBundle routes = ResourceBundle.getBundle("endpoint");	
	public static Logger log = LogManager.getLogger();
	
	// common variables
	public static RequestSpecification request;
	
	
   	 static String username;
   	 static String password;
   	
  	 public static void setBaseRequest() {
		 try {
            PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
            RequestSpecification     request1 = RestAssured.given()
                    .baseUri(baseURI)
                    .filter(RequestLoggingFilter.logRequestTo(stream))
                    .filter(ResponseLoggingFilter.logResponseTo(stream))
                    .header("Content-Type", "application/json");
                    
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
	
	public static void basicauth() throws IOException {
		List<LinkedHashMap<String, String>> list = FileUtils.getExcelDataAsListOfMap("LoginDetails");
		username = list.get(0).get("username");
	 	password = list.get(0).get("password");
	 	 }
	
	

     public static RequestSpecification getreq() throws IOException {
    	   basicauth();
    	   request= RestAssured.given().auth().basic(username,password)
		  .baseUri(routes.getString("baseurl"))
		  .header("Content-Type", "application/json");
	       return request;
		   }
	 
    
     public static RequestSpecification noauth() throws IOException {
  	  
    	 return   RestAssured.given().baseUri(routes.getString("baseurl")).header("Content-Type", "application/json");
	      
		   }

     public static RequestSpecification invalidcontentype() throws IOException {
  	   basicauth();
  	  return  request= RestAssured.given().auth().basic(username,password)
		  .baseUri(routes.getString("baseurl"))
		  .header("Content-Type", "application/xml");
	     
		   }
  
     
	
		
	
	
	
	
	
}
