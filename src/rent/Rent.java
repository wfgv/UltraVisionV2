package rent;


import java.time.LocalDate;
import java.util.Date;

import controller.Controller;
import model.customer.Customer;
import model.media.Media;

public class Rent extends Controller{

	private int rentID;
	private int customerID;
	private int mediaID;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private String customerStatus;
	private boolean isAvailable;
	
	
	public Rent(int rentID, int customerID, int mediaID, LocalDate rentDate, LocalDate returnDate,
			String customerStatus, boolean isAvailable) {
		super();
		this.rentID = rentID;
		this.customerID = customerID;
		this.mediaID = mediaID;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.customerStatus = customerStatus;
		this.isAvailable = isAvailable;
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


	public String getCustomerStatus() {
		return customerStatus;
	}


	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	@Override
	public String toString() {
		return "Rent [rentID=" + rentID + ", customerID=" + customerID + ", mediaID=" + mediaID + ", rentDate="
				+ rentDate + ", returnDate=" + returnDate + ", customerStatus=" + customerStatus + ", isAvailable="
				+ isAvailable + "]";
	}
	
}
