package rent;


import java.util.Date;

import controller.Controller;
import model.customer.Customer;
import model.media.Media;

public class Rent extends Controller{

	private int rentID;
	private Customer customer;
	private Media media;
	private Date rentDate;
	private Date returnDate;
	private String customerStatus;
	private boolean isAvailable;
	
	
		public Rent(Integer rentID, Customer customer, Media media, Date rentDate, Date returnDate, String customerStatus,
			boolean isAvailable) {
		this.rentID = rentID;
		this.customer = customer;
		this.media = media;
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

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Media getMedia() {
			return media;
		}

		public void setMedia(Media media) {
			this.media = media;
		}

		public Date getRentDate() {
			return rentDate;
		}

		public void setRentDate(Date rentDate) {
			this.rentDate = rentDate;
		}

		public Date getReturnDate() {
			return returnDate;
		}

		public void setReturnDate(Date returnDate) {
			this.returnDate = returnDate;
		}

		public String getCustomerStatus() {
			return customerStatus;
		}

		public void setCustomerStatu(String customerStatus) {
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
			return "Rent [customer=" + customer + ", media=" + media + ", rentDate=" + rentDate + ", returnDate="
					+ returnDate + ", customerStatus=" + customerStatus + ", isAvailable=" + isAvailable + "]";
		}
	
	
	
	
	
}
