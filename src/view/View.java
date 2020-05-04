package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controller;
import controller.MediaController;

public class View {

	private Controller controller;
	boolean exitMainMenu = false; // boolean initialised for do while loop in the main Menu @WillianVoelz
	private Scanner myScanner;// @WillianVoelz

	private Scanner menuOption; // scanner to be used inside the switch menu @EdwardsJr
	private MediaController mc; // instantiating MediaController class @EdwardsJr

	public View(Controller controller) {
		this.controller = controller;


	}
	// ---------- Method responsible for ONLY printing the Menu Options--------
	//	@WillianVoelz
	public void printMenu() {
		System.out.println("* Ultra Vision *");
		System.out.println("\nPlease select one of the following options");
		System.out.println("\n1 - Add Customer");
		System.out.println("2 - Update Customer");
		System.out.println("3 - Search Customer");
		System.out.println("4 - Add Title");
		System.out.println("5 - Search Title");
		System.out.println("6 - Rent Title");
		System.out.println("7 - Return Title");
		System.out.println("8 - Membership Options");
		System.out.println("9 - Exit");
	}

	// ------------ Method responsible for ONLY printing the Membership Options
	//	@WillianVoelz
	
	public void printMembershipOptions() {
		System.out.println("1 - MUSIC lover");
		System.out.println("2 - VIDEO Lover");
		System.out.println("3 - TV Lover");
		System.out.println("4 - PREMIUM");
	}

	// - Method responsible for taking user Input and redirect to specific method
	public void Menu() {

		do { // do while loop to keep the menu showing up until the Exit option is being
				// called. - Bug prevention loop. (Program never stops)

			try {
				printMenu(); // prompt
				int choice; // used to store user choice
				myScanner = new Scanner(System.in); // initialise Scanner called option
				choice = myScanner.nextInt(); // nextInt to take user input and store in choice variable
				exitMainMenu = false; // boolean set to false, it stops the program once true;
				menuOption = new Scanner(System.in);// initialise Scanner for options inside the switch menu @EdwardsJr

				switch (choice) {
				case 1:
					System.out.println("Option 1: Add New Customer: ");
					controller.addCustomer();
					break;
					
				case 2:
					System.out.println("Option 2: Search for Customer: ");
					System.out.println("Please select Search: \n1- Name \n2- ID");
					choice = myScanner.nextInt();
					if (choice == 1 || choice == 01) {
						controller.searchCustomerByName();
					}
					if (choice == 2 || choice == 02) {
						controller.searchCustomerByID();
					}
					if (choice == 3 || choice == 03) {
						printMenu();
					} else {
						printMenu();
					}

					break;
					
				case 3:
					System.out.println("Option 3: Update Customer Subscription: ");
					controller.updateSubscription();
					break;
					
				case 4:// add media @EdwardsJr
					mc = new MediaController();
					System.out.println(
							"Please select the type of media to be added:  \n1 - Movie \n2 - Music \n3 - Live Concert \n4 - BoxSet \n5 - Return to Main Menu");
					int option = menuOption.nextInt();
					if (option == 1) {
						System.out.println("Adding a Movie record: ");
						mc.addMovie();
						exitQuestion();
					} else if (option == 2) {
						System.out.println("Adding a Music record: ");
						mc.addMusic();
						exitQuestion();
					} else if (option == 3) {
						System.out.println("Adding a Live Concert record: ");
						mc.addLiveConcert();
						exitQuestion();
					} else if (option == 4) {
						System.out.println("Adding a Box Set record: ");
						mc.addBoxSet();
						exitQuestion();
					} else if (option == 5) {
						printMenu();
					}
					break;
				case 5:// search media @EdwardsJr
					mc = new MediaController();
					System.out.println(
							"Please select the type of media to search for:  \n1 - Movie \n2 - Music \n3 - Live Concert \n4 - BoxSet \n5 - Return to Main Menu");
					int option1 = menuOption.nextInt();
					if (option1 == 1) {
						System.out.println("Searching for movies: ");
						mc.searchMovie();
						exitQuestion();
					} else if (option1 == 2) {
						System.out.println("Searching for music: ");
						mc.searchMusic();
						exitQuestion();
					} else if (option1 == 3) {
						System.out.println("Searching for live concerts: ");
						mc.searchLiveConcert();
						exitQuestion();
					} else if (option1 == 4) {
						System.out.println("Search for TV Shows: ");
						mc.searchBoxSet();
						exitQuestion();
					} else if (option1 == 5) {
						printMenu();
					}
					break;
				case 6:
					System.out.println("Option 5");
					break;
				case 7:
					System.out.println("Option 6");
					break;
				case 8:
					System.out.println("Option 7");
					break;
				case 9:
					System.out.println("Ultra Vision terminated");
					exitMainMenu = true;
					break;
				default:
					System.out.println("Please enter a valid number");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Only numbers 1 to 9 - Please, try again"); // catch letters or anything except
																				// numbers
				Menu();
			}
		} while (!exitMainMenu); // !exitMainMenu = true .. if true = kills program before loop

	}
	
	// Simple if statement method that takes input from user to go ahead with operations.
	// this method is designed to pause the Menu do/while loop and let customer decide to go ahead.
	//	@WillianVoelz
	public void exitQuestion() { 
								
		System.out.println("\nPress: \n1 to menu ");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();

		if (choice == 1 || choice == 01) {
			Menu();
		} else {

			exitQuestion();
		}

	}
	// Add another customer while still in the addCustomer Method
	//	@WillianVoelz
	public void addAnotherCustomerQuestion() { 
		System.out.println("\nPress: \n1 to Menu \n2 to Add Another Customer");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();

		if (choice == 1 || choice == 01) {
			Menu();
		}
		if (choice == 2 || choice == 02) {
			controller.addCustomer();

		} else {
			exitQuestion();
		}

	}
	// Search another customer or go back to Menu
	//	@WillianVoelz
	public void searchAnotherCustomer() { 

		System.out.println("\nPress: \n1 to Menu  \n2 to search Another Customer by Name \n3 Search another customer by ID ");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();

		if (choice == 1 || choice == 01) {
			Menu();

		} else if (choice == 2 || choice == 02) {

			controller.searchCustomerByName();
		} else if (choice == 3 || choice == 03) {

			controller.searchCustomerByID();
		}else {
			searchAnotherCustomer();
		}

	}

}
