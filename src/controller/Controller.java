package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.customer.Customer;
import model.customer.MembershipOptions;
import model.media.Movie;
import model.media.Music;

public class Controller {

	private List<Customer> customerList = new ArrayList<>(); // arraylist of customers @WillianVoelz
	private List<Movie> movieList = new ArrayList<>();
	private List<Music> musicList = new ArrayList<>();
	private int customerCount = 0; // counter for customer ID , it increases by 1 every customer added.
									// @WillianVoelz
	boolean exitMainMenu = false; // boolean initialized for do while loop in the main Menu @WillianVoelz
	private Scanner MainMenuOption; // scanner used in Main Menu user inputs @WillianVoelz
	private Scanner adCust; // scanner used for customer registration ( name / email ) @WillianVoelz
	private Scanner menuOption; // scanner to be used inside the switch menu @EdwardsJr
	private MediaController mc; // instantiating MediaController class @EdwardsJr

	public Controller() {

		Menu();

	}

	// -------------------------- Method responsible for ONLY printing the Menu
	// Options--------------------------
	public void printMenu() {
		System.out.println("* Ultra Vision *");
		System.out.println("\nPlease select one of the following options");
		System.out.println("\n0 - Add Customer");
		System.out.println("1 - Update Customer");
		System.out.println("2 - Search Customer");
		System.out.println("3 - Add Title");
		System.out.println("4 - Update Title");
		System.out.println("5 - Search Title");
		System.out.println("6 - Rent Title");
		System.out.println("7 - Return Title");
		System.out.println("8 - Membership Options");
		System.out.println("9 - Exit");
	}

// -------------------------- Method responsible for ONLY printing the Membership Options --------------------------
//	@WillianVoelz
	public void printMembershipOptions() {
		System.out.println("1 - MUSIC lover");
		System.out.println("2 - VIDEO Lover");
		System.out.println("3 - TV Lover");
		System.out.println("4 - PREMIUM");
	}

// -------------------------- Method responsible for taking user Input and redirect to specific method --------------------------
	public void Menu() {

		do { // do while loop to keep the menu showing up until the Exit option is being
				// called.

			try {
				printMenu(); // prompt
				int choice; // used to store user choice
				MainMenuOption = new Scanner(System.in); // initialize Scanner called option
				choice = MainMenuOption.nextInt(); // nextInt to take user input and store in choice variable
				exitMainMenu = false; // boolean set to false, it stops the program once true;
				menuOption = new Scanner(System.in);// initialize Scanner for options inside the switch menu @EdwardsJr

				switch (choice) {
				case 0:
					System.out.println("Option 0");
					addCustomer();
					break;
				case 1:
					System.out.println("Option 1");
					viewCustomer();
					break;
				case 2:
					System.out.println("Option 2");
					break;
				case 3:
					System.out.println("Option 3");// add media
					mc = new MediaController();
					System.out.println(
							"Please select the type of media to be added:  \n1 - Movie \n2 - Music \n3 - Live Concert \n4 - BoxSet \n5 - Return to Main Menu");
					int option = menuOption.nextInt();
					if (option == 1) {
						System.out.println("Adding a Movie record: ");
						mc.addMovie();
					} else if (option == 2) {
						System.out.println("Adding a Music record: ");
						mc.addMusic();
					} else if (option == 3) {
						System.out.println("Adding a Live Concert record: ");
						mc.addLiveConcert();
					} else if (option == 4) {
						System.out.println("Adding a Box Set record: ");
						mc.addBoxSet();
					} else if (option == 5) {
						printMenu();
					}
					break;
				case 4:
					System.out.println("Option 4");// update media
					// if statement here to choose which type of media to update
					break;
				case 5:
					System.out.println("Option 5");// search
					// if statement here to choose which type of media to search
					mc = new MediaController();
					//mc.searchMovie();
					//mc.searchMedia();
					mc.fillAllMedia();
					break;
				case 6:
					System.out.println("Option 6");
					break;
				case 7:
					System.out.println("Option 7");
					break;
				case 8:
					System.out.println("Option 8");
					break;
				case 9:
					System.out.println("Option 9");
					exitMainMenu = true;
					break;
				default:
					System.out.println("Please enter a valid number");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Only numbers 1 to 9 - Please, try again"); // catch letters or anything except
																				// numbers
				Menu(); // restart Menu
			}
		} while (!exitMainMenu); // !exitMainMenu = true .. if true = kills program before loop

	}

// -------------------------- New Customer Registration  --------------------------
//	@WillianVoelz
	public void addCustomer() {
		adCust = new Scanner(System.in);

		int id = customerCount + 1;
		System.out.println("Enter customer Name: ");
		String name = adCust.nextLine();
		System.out.println("Enter customer email: ");
		String email = adCust.nextLine();

		printMembershipOptions(); // prompt membership options
		int membershipOption = adCust.nextInt();
		if (membershipOption == 1) { // if statements, create different Customers according to subscription chosen
			Customer c1 = new Customer(id, name, email, MembershipOptions.MUSICLOVER);
			customerList.add(c1);
		} else if (membershipOption == 2) {
			Customer c1 = new Customer(id, name, email, MembershipOptions.VIDEOLOVER);
			customerList.add(c1);
		} else if (membershipOption == 3) {
			Customer c1 = new Customer(id, name, email, MembershipOptions.TVLOVER);
			customerList.add(c1);
		} else if (membershipOption == 4) {
			Customer c1 = new Customer(id, name, email, MembershipOptions.PREMIUM);
			customerList.add(c1);
		}

		System.out.println(name + " was succesfully added as a customer!");
		System.out.println("ID Number: " + id);
		System.out.println("email: " + email);

		customerCount = customerCount + 1;

	}

// -------------------------- View Customer - print arrayList with all details (test purposes )--------------------------
//	@WillianVoelz	
	public void viewCustomer() { // to be later converted to search Methods
		System.out.println(customerList);
	}

}
