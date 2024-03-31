package requestSpec;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import endpoints.URLs;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Respec {


	public static RequestSpecification reqspec;
	
	public static RequestSpecification requestspecification() throws IOException {
		
		if(reqspec==null) {
		PrintStream stream= new PrintStream(new FileOutputStream("logging.txt"));	
		
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		
		reqspec	=new RequestSpecBuilder().setBaseUri(URLs.BaseURL)
                 .addFilter(RequestLoggingFilter.logRequestTo(stream))
                 .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                 .setContentType(ContentType.JSON).build();
		
		return reqspec;
		}
		return reqspec;
	 }
	
   }
