package model.customer;

import model.media.Media;

public class Premium extends Customer {

	public Premium(int customerID, String customerName, String customerEmail, MembershipOptions membershipOptions) {
		super(customerID, customerName, customerEmail);
		this.membershipOptions = membershipOptions;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "\nCustomer ID: " + this.customerID + " Name: "+this.customerName + " Email: "+this.customerEmail + " Subscription: " + this.membershipOptions;
	}

}
