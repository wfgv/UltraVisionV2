package model.customer;

import model.media.Media;

public class VideoLover extends Customer {

	public VideoLover(int customerID, String customerName, String customerEmail, MembershipOptions membershipOptions, int loyaltyPoints) {
		super(customerID, customerName, customerEmail, loyaltyPoints);
		this.membershipOptions = membershipOptions;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "\nCustomer ID: " + this.customerID + " | Name: "+this.customerName + " | Email: "+this.customerEmail + " | Subscription: " + this.membershipOptions+ " | Loyalty Points: " + this.loyaltyPoints;
	}

}
