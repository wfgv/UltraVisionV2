package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.customer.Customer;
import model.customer.MembershipOptions;
import model.customer.MusicLover;
import model.customer.Premium;
import model.customer.TVLover;
import model.customer.VideoLover;
import view.View;

public class Controller {

	private View view; // initialising the link between view and controller
	private List<Customer> customerList = new ArrayList<>(); // arraylist of customers @WillianVoelz
	private List<MusicLover> musicLoverList = new ArrayList<MusicLover>();
	private List<VideoLover> videoLoverList = new ArrayList<VideoLover>();
	private List<TVLover> tvLoverList = new ArrayList<TVLover>();
	private List<Premium> premiumList = new ArrayList<Premium>();
	private int customerCount = 1; // counter for customer ID , it increases by 1 every customer added.
	private Scanner myScanner; // @WillianVoelz
	boolean exitMainMenu = false; // boolean initialised for do while loop in the main Menu @WillianVoelz

	public Controller() {
		view = new View(this);
		view.Menu();
	}

	// -------------------------- New Customer Registration  --------------------------
	//	@WillianVoelz
	public void addCustomer() {
		
		myScanner = new Scanner(System.in);

		int id = customerCount;
		System.out.println("Enter customer Name: ");
		String name = myScanner.nextLine();
		System.out.println("Enter customer email: ");
		String email = myScanner.nextLine();
		MusicLover ml = null;
		VideoLover vl = null;
		TVLover tl = null;
		Premium p = null;
		System.out.println("Select subcription: ");
		view.printMembershipOptions(); // prompt membership options
		int membershipOption = myScanner.nextInt();
		if (membershipOption == 1) { // if statements, create different Customers according to subscription chosen
			ml = new MusicLover(id, name, email, MembershipOptions.MUSICLOVER);
			customerList.add(ml);
			musicLoverList.add(ml);
		} else if (membershipOption == 2) {
			vl = new VideoLover(id, name, email, MembershipOptions.VIDEOLOVER);
			customerList.add(vl);
			videoLoverList.add(vl);
		} else if (membershipOption == 3) {
			tl = new TVLover(id, name, email, MembershipOptions.TVLOVER);
			customerList.add(tl);
			tvLoverList.add(tl);
		} else if (membershipOption == 4) {
			p = new Premium(id, name, email, MembershipOptions.PREMIUM);
			customerList.add(p);
			premiumList.add(p);
		}

		System.out.println(name + " was succesfully added as a customer!");
		System.out.println("ID Number: " + id);
		System.out.println("email: " + email);
		// System.out.println("Subscription: " + ml.getMembership());

		customerCount = customerCount + 1; // add +1 for the ID variable each new customer created.

		view.addAnotherCustomerQuestion(); // method that doesn't let the Menu loop back instantly
		// it requires user permission beforehand.

	}

	// ----------------- View Customer - print arrayList with all details (test purposes )--------------------------
	//	@WillianVoelz	
	public void viewCustomer() { 
		
		System.out.println("All customers registered:");
		//System.out.println(musicLoverList);
		//System.out.println(tvLoverList);
		//System.out.println(videoLoverList);
		//System.out.println(premiumList);
		System.out.println(customerList);
	}

	// -------------- Search customer by NAME ------------------
	// @WillianVoelz
	public void searchCustomerByName() {
		
		myScanner = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String inputName = myScanner.nextLine();
		Customer result = null;

		for (Customer c : customerList) {
			if (inputName.equalsIgnoreCase(c.getName())) {
				result = c;
				System.out.println("Customer found: ");
				System.out.println(result);
				view.searchAnotherCustomer();
			}
		}
		System.out.println("Customer not found");
		view.searchAnotherCustomer();
	}
	// -------------- Search customer by NAME ------------------
	// @WillianVoelz
	public void searchCustomerByID() {
		
		myScanner = new Scanner(System.in);
		System.out.println("Enter ID: ");
		int targetID = myScanner.nextInt();
		Customer result = null;

		for (Customer c : customerList) {
			if (targetID == c.getID()) {
				result = c;
				System.out.println("Customer found: ");
				System.out.println(result);
				view.searchAnotherCustomer();

			}
		}
		System.out.println("Customer not found");
		view.searchAnotherCustomer();

	}
	
	// -------------- Update customer Subscription using customer ID ------------------
	// @WillianVoelz
	public void updateSubscription() {
		myScanner = new Scanner(System.in);
		System.out.println("Input Member ID: ");
		int customerID = myScanner.nextInt();

		System.out.println("Update to: \n1-Music Lover \n2-VideoLover \n3-TVLover \n4-Premium");
		int newSubscription = myScanner.nextInt();

		if (newSubscription == 1) {
			customerList.get(customerID - 1).setMembership(MembershipOptions.MUSICLOVER);
		} else if (newSubscription == 2) {
			customerList.get(customerID - 1).setMembership(MembershipOptions.VIDEOLOVER);
		} else if (newSubscription == 3) {
			customerList.get(customerID - 1).setMembership(MembershipOptions.TVLOVER);
		} else if (newSubscription == 4) {
			customerList.get(customerID - 1).setMembership(MembershipOptions.PREMIUM);
		}
		System.out.println("Customer subscription updated");
	}
}
