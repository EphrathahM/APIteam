package endpoints;




public class URLs {
	

	
	
	

	public static String BaseURL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static String loginEndpoint = "/login";
	public static String logoutEndpoint ="/logoutlms";
	public static String Excelpath = "./src/test/resources/TestData/LoginCredentials2.xlsx";
	
	
	public static String postcreateendpoint="/batches";
	public static String getallbatchendpoint="/batches";
	public static String getbatchidendpoint="/batches/batchId/8596";
	public static String getbatchnameendpoint="/batches/batchName/API_Automator1s-SDET-05";
	public static String getbatchprogramidendpoint="/batches/program/{programId}";
	public static String updatebatchidendpoint="/batches/{batchId}";
	public static String deletebatchidendpoint=" /batches/{id}";
			
	
	
	//UserJustina-positive
	
		public static String GetUserwihroles="/roles";
		public static String GetCountofActiveAndInactiveUser="/users/byStatus";
		public static String GetByBatchID="/users/programBatch/";
		public static String GetByProgramId="/users/programs/16210";
		public static String UpdateAdminInfo="/users/{userId}";
		public static String UpdateUserrolestus="/users/roleStatus/{userID}";
	
	//public static String username = "Numpy@gmail.com";
	//public static String password ="userAPI";
		//public static String BaseUrl = "https://userapi-8877aadaae71.herokuapp.com/uap" ;
	
	
	   // public  static String Getallusers = "/users";
		//public static String CreateUser = "/createusers";
		//public static String Excelpath = "./src/test/resources/TestData/testdata.xlsx";
		//public static String GetUserById = "/user/{userId}";
		//public static String GetUserByFirstName = "/users/username/{userFirstName}";
		//public static String UpdateUser = "/updateuser/{userId}";
		//public static String DeleteUserByFirstName = "/deleteuser/username/{userfirstname}";
		//public static String DeleteUserByUserId = "/deleteuser/{userId}\r\n";
		
		//Invalid url and endpoint
		
		//public static String InvalidUrl ="https://userapi-8877aadaae71.herokuapp.com";
		//public static String Invalid_endpoint = "/ab";
	
	
	//public static String BaseUrl = "https://reqres.in/";
	//public static String createUser = "api/users/";
	//public static String Excelpath = "./src/test/resources/TestData/restPost.xlsx";
	
	//UserJustina-positive
	
	//public static String GetUserwihroles="/roles";
	//public static String GetCountofActiveAndInactiveUser="/users/byStatus";
	//public static String GetByBatchID="/users/programBatch/8220";
	//public static String GetByProgramId="/users/programs/16210";
	//public static String UpdateAdminInfo="/users/{userId}";
	//public static String UpdateUserrolestus="/users/roleStatus/{userID}";
			
	
	
	
	
}
