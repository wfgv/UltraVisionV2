package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.customer.Customer;
import model.customer.MembershipOptions;
import model.media.Movie;
import model.media.Music;
import view.View;

public class Controller {
	
	View view;

	private List<Customer> customerList = new ArrayList<>(); // arraylist of customers @WillianVoelz
	private List<Movie> movieList = new ArrayList<>();
	private List<Music> musicList = new ArrayList<>();
	private int customerCount = 0; // counter for customer ID , it increases by 1 every customer added.
	private Scanner myScanner;
									// @WillianVoelz
	boolean exitMainMenu = false; // boolean initialized for do while loop in the main Menu @WillianVoelz
	private Scanner menuOption; // scanner to be used inside the switch menu @EdwardsJr
	private MediaController mc; // instantiating MediaController class @EdwardsJr

	public Controller() {
		view = new View(this);
		view.Menu();
	}

	

// -------------------------- New Customer Registration  --------------------------
//	@WillianVoelz
	 public void addCustomer() {
		myScanner = new Scanner(System.in);

		int id = customerCount + 1;
		System.out.println("Enter customer Name: ");
		String name = myScanner.nextLine();
		System.out.println("Enter customer email: ");
		String email = myScanner.nextLine();
		Customer c1 = null;

		view.printMembershipOptions(); // prompt membership options
		int membershipOption = myScanner.nextInt();
		if (membershipOption == 1) { // if statements, create different Customers according to subscription chosen
			c1 = new Customer(id, name, email, MembershipOptions.MUSICLOVER);
			customerList.add(c1);
		} else if (membershipOption == 2) {
			c1 = new Customer(id, name, email, MembershipOptions.VIDEOLOVER);
			customerList.add(c1);
		} else if (membershipOption == 3) {
			c1 = new Customer(id, name, email, MembershipOptions.TVLOVER);
			customerList.add(c1);
		} else if (membershipOption == 4) {
			c1 = new Customer(id, name, email, MembershipOptions.PREMIUM);
			customerList.add(c1);
			
		}

		System.out.println(name + " was succesfully added as a customer!");
		System.out.println("ID Number: " + c1.getID());
		System.out.println("email: " + c1.getEmail());
		System.out.println("Subscription: " + c1.getMembership());
		
		customerCount = customerCount + 1;
		
		view.exitQuestion();

	}

// -------------------------- View Customer - print arrayList with all details (test purposes )--------------------------
//	@WillianVoelz	
	public void viewCustomer() { // to be later converted to search Methods
		System.out.println("All customers registered:");
		System.out.println(customerList);
	}

}
