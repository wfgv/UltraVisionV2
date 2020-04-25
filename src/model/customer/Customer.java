//@Author Willian Voelz 2018447

package model.customer;

public class Customer {

	//variables
	private int customerID;
	private String customerName;
	private String customerEmail;
		
	//constructor
	public Customer(int customerID, String customerName, String customerEmail) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}
	
	//getters and setters
	public int getID() {
		return customerID;
	}
	public void setID(int customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return customerName;
	}
	public void setName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return customerEmail;
	}
	public void setEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	
	
	//toString method
//	@Override
//	public String toString() {
//		return "Person [name=" + customerName + ", email=" + customerEmail + "]";
//	}
	@Override
	public String toString() {
		return "Customer ID: " + this.customerID + "/n Customer name:   "+this.customerName + "/n Customer email: "+this.customerEmail;
	}
	
}