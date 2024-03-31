package payload;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import utils.ExcelReader_Rest;

public class batchputpayload {
	private String batchDescription;
    private int batchId;
	private String batchName;
	private int batchNoOfClasses;
	private String batchStatus;
    private int programId;
    private String programName;
      static  String Jsonbody;




    public String getBatchDescription() {
		return batchDescription;
	}
	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
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
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	

	public static  String adminputbatch() throws InvalidFormatException, IOException {
		
			List<Map<String, String>>map =ExcelReader_Rest.getData(URLs.Excelpath, "Sheet 4 - Table 1-1");
			
			for (Map<String, String> row : map) {
				
				String batchDescription = row.get("batchDescription");
				int batchId=Integer.parseInt(row.get("batchId"));
				String batchName= row.get("batchName");
				int batchNoOfClasses= Integer.parseInt(row.get("batchNoOfClasses")); 
				String batchStatus= row.get("batchStatus");
				int programId = Integer.parseInt(row.get("programId")); 
				String programName=row.get("programName");
				
				
				 batchputpayload putpayload= new batchputpayload ();
				 putpayload.setBatchDescription(batchDescription);
				 putpayload.setBatchId(batchId);
				 putpayload.setBatchName(batchName);
				 putpayload.setBatchNoOfClasses(batchNoOfClasses);
				 putpayload.setBatchStatus(batchStatus);
				 putpayload.setProgramId(programId);
				 putpayload.setProgramName(programName);
			
				 
		    ObjectMapper om = new ObjectMapper();
	        Jsonbody=om.writerWithDefaultPrettyPrinter().writeValueAsString(putpayload);
	        //System.out.println(Jsonbody);	
			}
	        return Jsonbody;		

		}
			
	public static void main(String[] args) throws InvalidFormatException, IOException {
		adminputbatch() ;
		//userrolestatus();
	
	}
	


}
