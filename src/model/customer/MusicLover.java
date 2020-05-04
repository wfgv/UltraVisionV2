package model.customer;

public class MusicLover extends Customer {

	public MusicLover(int customerID, String customerName, String customerEmail, MembershipOptions membershipOptions) {
		super(customerID, customerName, customerEmail, membershipOptions);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\nCustomer ID: " + this.customerID + " Name: "+this.customerName + " Email: "+this.customerEmail + " Subscription: " + this.membershipOptions;
	}

}
