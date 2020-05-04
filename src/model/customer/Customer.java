//@Author Willian Voelz 2018447

package model.customer;

public class Customer {

	//variables
	protected int customerID;
	protected String customerName;
	protected String customerEmail;
	protected MembershipOptions membershipOptions;
		
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
	public MembershipOptions getMembership() {
		return membershipOptions;
	}
	public void setMembership(MembershipOptions membershipOptions) {
		this.membershipOptions = membershipOptions;
	}
	

	@Override
	public String toString() {
		return "\nCustomer ID: " + this.customerID + " Name: "+this.customerName + " Email: "+this.customerEmail + " Subscription: " + this.membershipOptions;
	}
	
}