package model.rent;

import java.time.LocalDate;

import model.customer.Customer;
import model.media.Media;

public class Rent {

	private int rentID;
	private int customerID;
	private String custumerName;
	private int mediaID;
	private String mediaName;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private boolean isAvailable;
	private Customer customer;
	private Media media;

	public Rent(int rentID, int customerID, String customerName, int mediaID, String mediaName, LocalDate rentDate,
			LocalDate returnDate, boolean isAvailable) {
		super();
		this.rentID = rentID;
		this.customerID = customerID;
		this.custumerName = customerName;
		this.mediaID = mediaID;
		this.mediaName = mediaName;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.isAvailable = isAvailable;
	}

	public Rent(Customer customer, Media media, LocalDate rentDate, LocalDate returnDate) {
		super();
		this.customer = customer;
		this.media = media;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public String getCustumerName() {
		return custumerName;
	}

	public void setCustumerName(String custumerName) {
		this.custumerName = custumerName;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public int getRentID() {
		return rentID;
	}

	public void setRentID(int rentID) {
		this.rentID = rentID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public boolean setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
		return true;
	}

	@Override
	public String toString() {
		return "\nRent List: Rent ID: " + rentID + "\nCustomer ID: " + customerID + "\nCustomer Name: " + custumerName
				+ "\nMedia ID: " + mediaID + "\nMedia Title: " + mediaName + "\nRent Date: " + rentDate
				+ "\nReturn Date: " + returnDate + "\nAvailability: " + isAvailable + "";
	}

}
