package Model;

import java.io.Serializable;

public class Customer extends Person implements Serializable{

	private String CustomerId;
	private String PhoneNo;
	
	public Customer(String name, String ages, String customerId, String phoneNo) {
		super(name, ages);
		CustomerId = customerId;
		PhoneNo = phoneNo;
	}
	
	public Customer(){
		
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
}