//@Author Willian Voelz 2018447

package model.customer;

import model.media.Media;

public class Customer {

	// variables
	protected int customerID;
	protected String customerName;
	protected String customerEmail;
	protected MembershipOptions membershipOptions;
	protected Media[] mediaRented;
	protected int loyaltyPoints;

	// constructor
	public Customer(int customerID, String customerName, String customerEmail, int loyaltyPoints) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.mediaRented = new Media[4];// essa array e pra armazenar as locacoes... talvez seja melhor apenas um
										// contador, nao acha?
		this.loyaltyPoints = loyaltyPoints;
	}

	// getters and setters
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

	public Media[] getMediaRented() {
		return mediaRented;
	}

	public void setMediaRented(Media media) {// sinceramente nao entendi direito esses metodos, fiz essa parte com a
												// ajuda do Daniel e tals. Tenho uma ideia para podermos seguir
		// o que mandei naquela imagem via whatsapp

		for (int i = 0; i < this.mediaRented.length; i++)
			if (this.mediaRented[i] == null) {
				this.mediaRented[i] = media;

				break;
			}

	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;

	}

	public void add10PointsPerRent() {
		loyaltyPoints = loyaltyPoints + 10;

	}

	@Override
	public String toString() {
		return "\nCustomer ID: " + this.customerID + " Name: " + this.customerName + " Email: " + this.customerEmail
				+ " Subscription: " + this.membershipOptions + "Loyalty Points: " + this.loyaltyPoints;
	}

}