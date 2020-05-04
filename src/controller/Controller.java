package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.customer.Customer;
import model.customer.MembershipOptions;
import model.customer.MusicLover;
import model.customer.Premium;
import model.customer.TVLover;
import model.customer.VideoLover;
import model.media.Movie;
import model.media.Music;
import view.View;

public class Controller {
	
	private View view; // initialising the link between view and controller
	private List<Customer> customerList = new ArrayList<>(); // arraylist of customers @WillianVoelz
	private List<MusicLover> musicLoverList = new ArrayList<MusicLover>();
	private List<VideoLover> videoLoverList = new ArrayList<VideoLover>();
	private List<TVLover> tvLoverList = new ArrayList<TVLover>();
	private List<Premium> premiumList = new ArrayList<Premium>();
	private int customerCount = 0; // counter for customer ID , it increases by 1 every customer added.
	private Scanner myScanner;								// @WillianVoelz
	boolean exitMainMenu = false; // boolean initialised for do while loop in the main Menu @WillianVoelz
	
	//UNUSED VARIABLES/ATTRIBUTES
	//private Scanner menuOption; // scanner to be used inside the switch menu @EdwardsJr
	//private MediaController mc; // instantiating MediaController class @EdwardsJr
	//private List<Movie> movieList = new ArrayList<>();
	//private List<Music> musicList = new ArrayList<>();

	public Controller() {
		view = new View(this);
		//new ArrayList<>();
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
		MusicLover ml = null;
		VideoLover vl = null;
		TVLover tl = null;
		Premium p = null;
		System.out.println("Select subcription: ");
		view.printMembershipOptions(); // prompt membership options
		int membershipOption = myScanner.nextInt();
		if (membershipOption == 1) { // if statements, create different Customers according to subscription chosen
			//c1 = new Customer(id, name, email, MembershipOptions.MUSICLOVER);
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
		//System.out.println("Subscription: " + ml.getMembership());
		
		customerCount = customerCount + 1; // add +1 for the ID variable each new customer created.
		
		view.exitQuestion(); // method that doesn't let the Menu loop back instantly
								// it requires user permission before.

	}

// -------------------------- View Customer - print arrayList with all details (test purposes )--------------------------
//	@WillianVoelz	
	public void viewCustomer() { // to be later converted to search Methods
		System.out.println("All customers registered:");
		System.out.println(musicLoverList);
		
		System.out.println(customerList);
	}
// -------------------------- View Customer - print arrayList with all details (test purposes )--------------------------
	public void searchCustomerByName() {
		myScanner = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String targetName = myScanner.nextLine();
		 
		    Customer result = null;
		    for (Customer c : customerList) {
		        if (targetName.equals(c.getName())) {
		            result = c;
		            break;
		            
		        }else {
		        	System.out.println("Customer not found ");
		        	view.searchAnotherCustomer();
		        }
		        
		    }
		    System.out.println("Customer found: ");
		    System.out.println(result);
		    view.searchAnotherCustomer();
	}

}
