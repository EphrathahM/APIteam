package pojo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class AdduserPojo {
	
	@JsonPropertyOrder({"user_first_name","user_last_name","user_contact_number","user_email_id","userAddress"})
	String user_first_name;
	String user_last_name;
	String user_contact_number;
	String user_email_id;
	AddressPOJO userAddress;
	
	@JsonGetter(value = "user_first_name")
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	
	@JsonGetter(value = "user_last_name")
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	
	@JsonGetter(value = "user_contact_number")
	public String getUser_contact_number() {
		return user_contact_number;
	}
	public void setUser_contact_number(String user_contact_number) {
		this.user_contact_number = user_contact_number;
	}
	
	@JsonGetter(value = "user_email_id")
	public String getUser_email_id() {
		return user_email_id;
	}
	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}
	
	@JsonGetter(value = "userAddress")
	public AddressPOJO getAddress() {
		return userAddress;
	}
	public void setAddress(AddressPOJO address) {
		this.userAddress= address;
	}
	

	// Add this in AdduserPojo class
	/*	@Override
		public String toString() {
		    return "AdduserPojo: {" +
		            "firstName='" + user_first_name + '\'' +
		            ", lastName='" + user_last_name + '\'' +
		            ", contactNumber='" + user_contact_number + '\'' +
		            ", email='" + user_email_id + '\'' +
		            ", address=" + userAddress +
		            '}';
		}*/
	
	
	
	
	
	
	
}
