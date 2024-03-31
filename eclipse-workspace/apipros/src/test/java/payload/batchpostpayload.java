package payload;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import endpoints.URLs;



import utils.ExcelReader_Rest;

public class batchpostpayload {


    private  String batchDescription;
	private  String batchName;
	private   int batchNoOfClasses;
	private  String batchStatus;
    private   int programId;
    static  String Jsonbody;



   public String getBatchDescription() {
		return batchDescription;
	}
	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public int getBatchNoOfClasses() {
		return batchNoOfClasses;
	}
	public void setBatchNoOfClasses(int batchNoOfClasses) {
		this.batchNoOfClasses = batchNoOfClasses;
	}
	public String getBatchStatus() {
		return batchStatus;
	}
	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}

public static  String adminbatch() throws InvalidFormatException, IOException {
	

		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.Excelpath, "Sheet 4 - Table 1-1");
		
		for (Map<String, String> row : map) {
			
			String batchDescription = row.get("batchDescription");
			String batchName= row.get("batchName");
			int batchNoOfClasses= Integer.parseInt(row.get("batchNoOfClasses")); 
			String batchStatus= row.get("batchStatus");
			int programId = Integer.parseInt(row.get("programId")); 
			
			batchpostpayload postpayload= new batchpostpayload();
			postpayload.setBatchDescription(batchDescription);
			postpayload.setBatchName(batchName);
			postpayload.setBatchNoOfClasses(batchNoOfClasses);
			postpayload.setBatchStatus(batchStatus);
			postpayload.setProgramId(programId);
			
		ObjectMapper om = new ObjectMapper();
        Jsonbody=om.writerWithDefaultPrettyPrinter().writeValueAsString(postpayload);
        System.out.println(Jsonbody);	
		}
        return Jsonbody;		

	}
		
	
	/*public static String userrolestatus() throws JsonProcessingException {
		
		UserPutPayload12 putpayloadrolestatus= new UserPutPayload12();
		putpayloadrolestatus.setRoleId("etet");
		putpayloadrolestatus.setUserRoleStatus("ewete");
		
		ObjectMapper om = new ObjectMapper();
        Jsonbodyuserrole=om.writerWithDefaultPrettyPrinter().writeValueAsString(putpayloadrolestatus);
        System.out.println(Jsonbodyuserrole);
        return Jsonbodyuserrole;	
		}*/
	 
	public static void main(String[] args) throws InvalidFormatException, IOException {
		adminbatch() ;
		//userrolestatus();
	
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	


	
	
	

