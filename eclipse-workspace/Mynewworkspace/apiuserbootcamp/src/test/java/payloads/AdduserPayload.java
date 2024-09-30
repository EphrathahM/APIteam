package payloads;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import pojo.AddressPOJO;
import pojo.AdduserPojo;
import utils.Commonutils;
import utils.FileUtils;

public class AdduserPayload extends Commonutils {

  static AddressPOJO addresspojo= new AddressPOJO();
  static AdduserPojo  adduserpojo = new AdduserPojo();
     

	  public static AdduserPojo createUserPayload(LinkedHashMap<String, String> data) throws IOException {
	
		
	  adduserpojo.setUser_first_name(data.get("FirstName"));
	  adduserpojo.setUser_last_name(data.get("LastName"));
	  adduserpojo.setUser_contact_number((data.get("ContactNumber"))+RandomStringUtils.randomNumeric(5));
	  adduserpojo.setUser_email_id(data.get("Email")+RandomStringUtils.randomNumeric(4)+"@gmail.com");
	 
	  addresspojo.setPlotNumber(data.get("PlotNumber"));
	  addresspojo.setStreet(data.get("Street"));
	  addresspojo.setState(data.get("State"));
	  addresspojo.setCountry(data.get("Country"));
	  addresspojo.setZipCode(data.get("Zipcode"));
	  adduserpojo.setAddress(addresspojo);
	  
	  return adduserpojo; 
	  }
	  
	  
     public static List<LinkedHashMap<String, String>> getUserData(String sheetName) throws IOException {
	        return FileUtils.getExcelDataAsListOfMap(sheetName);
	    }
	  
     
     
     
     
     
     
     
     
     
     
     
}  
